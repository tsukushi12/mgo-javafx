package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MinePlayController extends AnchorPane implements Initializable {
	/**
	 * xml values
	 */
	@FXML Label label;

	/**
	 * instance member
	 * @prams ラベルテキスト
	 */
	public String labelText;

	/**
	 * initializer
	 * @param lt ラベルテキスト
	 */
	public MinePlayController(String lt) {
		this.labelText = lt;

		loadFXML();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		label.setText(labelText);
	}

	/**
	 * FXMLのロード
	 */
	public void loadFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(MusicGO.class.getResource("minePlay.fxml"));
	        fxmlLoader.setRoot(this);

	        // 自分自身をコントロールとして設定
	        fxmlLoader.setController(this);

	        try {
	            fxmlLoader.load();
	        } catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
	}

	/**
	 *ボタンクリックアクション
	 */
	@FXML
	protected void handleButtonAction() {
		MusicGO.getInstance().sendOtherPlayController("page2です");
	}

}
