package mainclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.*;
/**
 * This class is where the application begins by providing a main method to launch the main frame.
 * @author ZBagby
 *
 */
public class MainFrame extends Application {
	private Stage stage;
	
	@Override
	public void start(Stage arg0) throws Exception {
		this.stage = arg0;
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ATHLETETRACKER.fxml"));
		Scene scene = new Scene(root, 800, 600);
		this.stage.setScene(scene);
		this.stage.setTitle("Athlete Tracker");
		this.stage.setResizable(false);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("asuIcon.png")));
		//stage.getIcons().add(new Image("asuIcon.png"));
		
		scene.getStylesheets().add("css/athleteTracker.css");
		
		this.stage.show();
	}
	
	/**
	 * Main method
	 * @param args args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
}
