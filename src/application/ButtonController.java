/**
 *
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * @author yuki
 *
 */
public class ButtonController extends AnchorPane implements Initializable {

	/**
	 * @params btn
	 */
	@FXML private Button btn;


	public String filename;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void setMusicName(String name) {
		filename = name;
		btn.setText(name);
	}

	@FXML
	protected void playButtonAction() {

	}
}
