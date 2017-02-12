/**
 *
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
/**
 * @author yuki
 *
 */
public class OtherPlayController extends AnchorPane implements Initializable {

	/**
	 * FXML values
	 */
	@FXML Label label;

	/**
	 * instance membar
	 * @prams labelText ラベルテキスト
	 */
	public String labelText;

	/**
	 * initializer
	 * @param lt ラベルテキスト
	 */
	public OtherPlayController(String lt) {
		this.labelText = lt;

		loadFXML();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		label.setText("text");
	}

	/**
	 * FXMLのロード
	 */
	public void loadFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(MusicGO.class.getResource("otherPlay.fxml"));
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
		MusicGO.getInstance().sendMinePlayController("page1です");
	}

}
