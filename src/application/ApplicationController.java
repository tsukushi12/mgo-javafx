package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.sounds.Resouce;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ApplicationController extends AnchorPane implements Initializable {
	/**
	 * application
	 * xml values
	 */
	@FXML private Pane target;


	/**
	 * initializer
	 * @param filename targetに埋め込むFXMLファイル名
	 */
	public ApplicationController(String filename) {
		FXMLLoader rootLoader = new FXMLLoader(MusicGO.class.getResource("fxml/application.fxml"));
        rootLoader.setRoot(this);
        // 自分自身をコントロールとして設定
        rootLoader.setController(this);
        //@ターゲットに埋め込むテンプレート
	    FXMLLoader mainLoader = new FXMLLoader(MusicGO.class.getResource(filename));

        try {
            rootLoader.load();
            target.getChildren().add((AnchorPane)mainLoader.load());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	  this.getStylesheets().add(MusicGO.class.getResource("css/application.css").toExternalForm());
	}

	public static AnchorPane getMusicButton(String name, Resouce resouce) throws IOException{
		FXMLLoader buttonLoader = new FXMLLoader(MusicGO.class.getResource("fxml/musicButton.fxml"));
		AnchorPane pane = buttonLoader.load();
		ButtonController ctr = buttonLoader.getController();
		ctr.setMusicName(name, resouce);
		return pane;
	}

	/**
	 *ボタンクリックアクション
	 */
	@FXML
	protected void mineButtonAction() {
		MusicGO.getInstance().sendMinePlayController();
	}

	@FXML
	protected void otherButtonAction() {
		MusicGO.getInstance().sendOtherPlayController();
	}
}