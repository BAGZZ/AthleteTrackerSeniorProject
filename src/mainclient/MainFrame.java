package mainclient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

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
	private static String password = "pass";
	
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
        JFrame frame = new JFrame("Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();
        label.setText("Enter Password");
        JPasswordField passField = new JPasswordField(15);
        
        panel.add(label, BorderLayout.WEST);
        panel.add(passField, BorderLayout.EAST);
        
        Container content = frame.getContentPane();
        content.add(panel, BorderLayout.NORTH);
        frame.setSize(300, 75);
        //frame.add(panel);
        frame.setVisible(true);
        

        passField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                char[] p = passField.getPassword();
                String pass = new String(passField.getPassword());
                if(pass.equals(password)){
                	JOptionPane.showMessageDialog(null, "Welcome to the best Athlete Tracking software ever!");
                	frame.setVisible(false);
                	Application.launch( MainFrame.class, args );
                }
                else{
    				JOptionPane.showMessageDialog(null, "Incorrect Password");
                }
            }
        });
	}
}
