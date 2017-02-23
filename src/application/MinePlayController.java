package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.sounds.MusicFiles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MinePlayController extends AnchorPane implements Initializable {
	/**
	 * application
	 * xml values
	 */

	private MusicFiles musicFiles = MusicFiles.getInstance();
	/**
	 * minePlay
	 * fxml values
	 */
	@FXML private Label label;
	@FXML private VBox btnTarget;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		label.setText("再生リスト");
		for (String name: musicFiles.getFileNames()) {
			this.addButton(name);
		}

	}


	public void addButton(String filename) {
	       try {
	    	btnTarget.getChildren().add(ApplicationController.getMusicButton(filename, musicFiles));
	       } catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
	}

}
