package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MinePlayController extends AnchorPane implements Initializable {
	/**
	 * application
	 * xml values
	 */
	@FXML private Pane target;

	/**
	 * minePlay
	 * fxml values
	 */
	@FXML private Label label;
	/**
	 * initializer
	 * @param lt ラベルテキスト
	 */
	public MinePlayController() {


	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		label.setText("test");
	}


}
