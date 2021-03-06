
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
 
/**
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFXPixel extends Application {
     
    ImageView myImageView;
     
    @Override
    public void start(Stage primaryStage) {
         
        Button btnLoad = new Button("Load");
        btnLoad.setOnAction(btnLoadEventListener);
         
        myImageView = new ImageView();        
         
        VBox rootBox = new VBox();
        rootBox.getChildren().addAll(btnLoad, myImageView);
         
        Scene scene = new Scene(rootBox, 300, 300);
         
        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        
    	if (Desktop.isDesktopSupported()) {
    	    try {
    	        File myFile = new File("C:/Users/ZBagby/Documents/BAGBY_ZACHARY_RESUME.PDF");
    	        Desktop.getDesktop().open(myFile);
    	    } catch (IOException ex) {
    	        // no application registered for PDFs
    	    }
    	}
    	launch(args);
    }
     
    EventHandler<ActionEvent> btnLoadEventListener
    = new EventHandler<ActionEvent>(){
 

        @Override
        public void handle(ActionEvent t) {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
//            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
//            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
//            FileChooser.ExtensionFilter extFilterPDF = new FileChooser.ExtensionFilter("PDF files (*.pdf", "*.PDF");
//            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG,extFilterPDF);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                    String path = file.getAbsolutePath();  
                    System.out.println(path);
//            try {
//                BufferedImage bufferedImage = ImageIO.read(file);
//                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
//                myImageView.setImage(image);
//            } catch (IOException ex) {
//                Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    };
}