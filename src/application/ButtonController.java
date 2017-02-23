/**
 *
 */
package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.sounds.MinePCM;
import application.sounds.MusicFiles;
import application.sounds.Player;
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
		try {
			File f = new File(MusicFiles.rootpath + filename);
			MinePCM mpcm = new MinePCM(f);
			Player player = Player.getInstance();
			player.setLine(mpcm);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
