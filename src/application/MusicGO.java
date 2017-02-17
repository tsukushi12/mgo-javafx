/**
 *
 */
package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author yuki
 *
 */
public class MusicGO extends Application {

	/**
	 * singleton instance of MusicGO
	 */
	private static MusicGO instance;

	/**
	 * ステージ
	 */
	private Stage stage;

	/**
	 * @return MusicGO instance
	 */
	public static MusicGO getInstance() {
		return instance;
	}

	/* (非 Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		instance = this;

		stage = primaryStage;

		sendMinePlayController();
		stage.show();
	}

	/**
	 * @param args
	 * ********************************
	 * main method
	 * ********************************
	 */
	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * MinePlayへの遷移
	 * @params lt ラベルテキスト
	 */
	public void sendMinePlayController() {
		stage.setTitle("MinePlay");

		ApplicationController ctr = new ApplicationController("fxml/minePlay.fxml");
		this.replaceSceneContent(ctr);
	}

	public void sendOtherPlayController() {
		stage.setTitle("OtherPlay");

		ApplicationController ctr = new ApplicationController("fxml/otherPlay.fxml");
		this.replaceSceneContent(ctr);
	}
	/**
	 * sceneの変更
	 * @param ctr
	 */
	public void replaceSceneContent(Parent ctr) {
		Scene scene = stage.getScene();
		if (scene == null) {
			scene = new Scene(ctr);
			stage.setScene(scene);
		} else {
			stage.getScene().setRoot(ctr);
		}
	}
}
