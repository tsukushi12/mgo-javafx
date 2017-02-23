/**
 *
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.sounds.OtherResouce;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * @author yuki
 *
 */
public class OtherPlayController extends AnchorPane implements Initializable {

	/**
	 * application
	 * FXML values
	 */
	@FXML private Label label;
	@FXML private VBox btnTarget;

	public OtherResouce resouce = OtherResouce.getInstance();

	/**
	 * initializer
	 */
	public OtherPlayController() {
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		label.setText("再生リスト");
		ScheduledService<Boolean> ss = new ScheduledService<Boolean>() {

		    @Override
		    protected Task<Boolean> createTask() {
		        // タスクを定義
		        Task<Boolean> task = new Task<Boolean>() {
		            @Override
		            protected Boolean call() throws Exception {

		                Platform.runLater( () ->{
		                	resouce.others.forEach((name, souce) -> {
		                		addButton(name);
		                	});
		                });
		            	Thread.sleep( 5000 );

		                return true;
		            };
		        };
		        return task;
		    }
		};
		ss.start();

	}


	public void addButton(String name) {
	       try {
	    	btnTarget.getChildren().add(ApplicationController.getMusicButton(name, resouce));
	       } catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
	}

}
