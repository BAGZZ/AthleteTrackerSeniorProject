package mainclient;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.AthleteTrackerDatabase;
import edu.adams.backendboys.Injury;
import edu.adams.backendboys.InjuryProgress;
import edu.adams.backendboys.PhysicianVisit;
import edu.adams.backendboys.SOAPNotes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * This class controls all functionality within the add injury window.
 * @author ZBagby
 *
 */
public class AddInjuryWindowController implements Initializable{

	@FXML
	private TextArea addInjurySNotesTextArea,
		addInjuryONotesTextArea, 
		addInjuryANotesTextArea, 
		addInjuryPNotesTextArea,
		addInjuryNewProgressNotesTextArea, 
		addInjuryNewPhysicianNotesTextArea;
	@FXML
	private DatePicker addInjuryInjuryDateDatePicker,
		addInjuryNewPhysicianNotesDatePicker,
		addInjuryNewProgressNotesDatePicker;
	@FXML
	private Button addInjuryButton;
	@FXML
	private ComboBox<String> addInjurySeasonComboBox,
		addInjuryBodyPartComboBox,
		addInjuryInjuryTypeComboBox;
	@FXML
	private CheckBox activeInjuryAddInjuryCheckBox;
	
	private final long REFRESHTIMEOUT = 1000/2;
	private long previous=0;
	
	AthleteTrackerDatabase atdb = new AthleteTrackerDatabase();
	private Athlete currentAthlete = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		//populate combo boxes
		addInjurySeasonComboBox.getItems().setAll(atdb.getSeasons());
		addInjuryBodyPartComboBox.getItems().setAll(atdb.getAllBodyParts());
		addInjuryInjuryTypeComboBox.getItems().setAll("Select Body Part");
	}
	
	/**
	 * Injury type needs a body part before it can be filled. This fills the injury type 
	 * combobox once a body part is selected
	 * @param me mouse event
	 */
	public void injuryTypeAction(MouseEvent me){
		if(addInjuryBodyPartComboBox.getValue() != null){
			me.consume();
			if((System.currentTimeMillis()-previous)>=REFRESHTIMEOUT){
				previous=System.currentTimeMillis();
				ArrayList<String> injuryTypes = atdb.getInjuryTypeByBodyPart(addInjuryBodyPartComboBox.getValue());
				Collections.sort(injuryTypes);
				addInjuryInjuryTypeComboBox.getItems().setAll(injuryTypes);
	        }
		}
	}
	
	/**
	 * creates a new injury using information user has added and adds it 
	 * to the database for the current athlete. It will also close this 
	 * window when pressed. If A field is not working a message will
	 * come up saying "fill all fields". 
	 * @param me action event
	 */
	public void addInjuryButtonAction(ActionEvent me){
		if(addInjuryInjuryDateDatePicker.getValue() == null || addInjuryNewPhysicianNotesDatePicker.getValue() == null || addInjuryNewProgressNotesDatePicker.getValue() == null
				|| addInjurySNotesTextArea.getText().isEmpty() || addInjuryONotesTextArea.getText().isEmpty() || addInjuryANotesTextArea.getText().isEmpty() ||
				addInjuryPNotesTextArea.getText().isEmpty() || addInjuryNewPhysicianNotesTextArea.getText().isEmpty() || addInjuryNewProgressNotesTextArea.getText().isEmpty() ||
				addInjuryBodyPartComboBox.getValue() == null || addInjuryInjuryTypeComboBox.getValue() == null || addInjurySeasonComboBox.getValue() == null)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error Adding");
			alert.setHeaderText(null);
			alert.setContentText("Please Fill all fields");

			alert.showAndWait();
		}else
		{
		LocalDate localDate1 = addInjuryInjuryDateDatePicker.getValue();
		Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
		Date date1 = Date.from(instant1);
		
		LocalDate localDate2 = addInjuryNewPhysicianNotesDatePicker.getValue();
		Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
		Date date2 = Date.from(instant2);
		
		LocalDate localDate3 = addInjuryNewProgressNotesDatePicker.getValue();
		Instant instant3 = Instant.from(localDate3.atStartOfDay(ZoneId.systemDefault()));
		Date date3 = Date.from(instant3);
		
		ArrayList<SOAPNotes> soapnotes = new ArrayList<SOAPNotes>();
		SOAPNotes soap = new SOAPNotes(addInjurySNotesTextArea.getText(), addInjuryONotesTextArea.getText(),
				addInjuryANotesTextArea.getText(), addInjuryPNotesTextArea.getText(), new java.sql.Date(System.currentTimeMillis()));
		soapnotes.add(soap);
		
		ArrayList<PhysicianVisit> pval = new ArrayList<PhysicianVisit>();
		PhysicianVisit pv = new PhysicianVisit(new java.sql.Date(date2.getTime()), addInjuryNewPhysicianNotesTextArea.getText());
		pval.add(pv);
		
		ArrayList<InjuryProgress> inprog = new ArrayList<InjuryProgress>();
		InjuryProgress ip = new InjuryProgress(new java.sql.Date(date3.getTime()), addInjuryNewProgressNotesTextArea.getText());
		inprog.add(ip);
		
		Injury injury = new Injury(atdb.getBodyPartID(addInjuryBodyPartComboBox.getValue()), addInjuryInjuryTypeComboBox.getValue(), new java.sql.Date(date1.getTime()), activeInjuryAddInjuryCheckBox.isSelected(), addInjurySeasonComboBox.getValue(), soapnotes, pval, inprog);
		System.out.println(injury);
		atdb.addInjury(currentAthlete, injury);
		
		Stage stage = (Stage) addInjuryButton.getScene().getWindow();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add Successful");
		alert.setHeaderText(null);
		alert.setContentText("Injury added successfully");

		alert.showAndWait();
		stage.close();
		}
	}

	public void setAthlete(Athlete currentAthlete) {
		this.currentAthlete = currentAthlete;
		
	}

	

}
