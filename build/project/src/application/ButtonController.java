/**
 *
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.sounds.PCMReader;
import application.sounds.Player;
import application.sounds.Resouce;
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
	public Resouce resouce;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void setMusicName(String name, Resouce r) {
		filename = name;
		btn.setText(name);
		resouce = r;
	}

	@FXML
	protected void playButtonAction() {
		try {
			PCMReader reader = resouce.getResouce(filename);
			Player player = Player.getInstance();
			player.setLine(reader);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
