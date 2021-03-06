package mainclient;

import java.net.URL;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.panemu.tiwulfx.table.CheckBoxColumn;
import com.panemu.tiwulfx.table.TextColumn;

import javafx.application.Preloader.ProgressNotification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.AthleteTrackerDatabase;
import edu.adams.backendboys.Injury;
import edu.adams.backendboys.InjuryProgress;
import edu.adams.backendboys.PhysicianVisit;
import edu.adams.backendboys.SOAPNotes;
/**
 * controls all functionality within the edit injury window
 * @author ZBagby
 *
 */
public class EditInjuryWindowController implements Initializable {
	
	AthleteTrackerDatabase atdb = new AthleteTrackerDatabase();
	
	@FXML 
	private Label editInjuryAthleteNameLabel,
	editInjuryBodyPartLabel1,
	editInjuryInjuryTypeLabel1,
	editInjuryInjuryDateLabel1;
	
	@FXML
	private DatePicker editInjuryNewProgressNotesDatePicker,
		editInjuryNewPhysicianNotesDatePicker;
	

	@FXML 
	private TextArea editInjurySNotesTextArea,
		editInjuryONotesTextArea,
		editInjuryANotesTextArea,
		editInjuryPNotesTextArea,
		editInjuryNewProgressNotesTextArea,
		editInjuryNewPhysicianNotesTextArea;

	
	@FXML
	private CheckBox editInjuryActiveInjuryCheckBox;
	
	@FXML
	private Button makeChangesButton,
		editInjuryNewProgressNotesAddNoteButton,
		editInjuryNewPhysicianNotesAddNoteButton;
	
	@FXML 
	private TableView<InjuryProgress> editInjuryProgressNotesTableView;
	
	@FXML
	private TableView<PhysicianVisit>editInjuryPhysicianNotesTableView;

		TextColumn<InjuryProgress> columnProgressDateInjury;
		TextColumn<InjuryProgress> columnProgressNoteInjury;
		
		TextColumn<PhysicianVisit> columnPhysicianDateInjury;
		TextColumn<PhysicianVisit> columnPhyscicianNoteInjury;
		
	private Athlete currentAthlete = null;
	private Injury currentInjury = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		editInjuryAthleteNameLabel.setText("");
		editInjuryBodyPartLabel1.setText("");
		editInjuryInjuryTypeLabel1.setText("");
		editInjuryInjuryDateLabel1.setText("");
		editInjuryActiveInjuryCheckBox.setSelected(true);
		editInjurySNotesTextArea.setText("");
		editInjuryONotesTextArea.setText("");
		editInjuryANotesTextArea.setText("");
		editInjuryPNotesTextArea.setText("");
		//injury table
		columnProgressDateInjury = new TextColumn<InjuryProgress>("date");
		columnProgressNoteInjury = new TextColumn<InjuryProgress>("note");
		
		columnPhysicianDateInjury = new TextColumn<PhysicianVisit>("date");
		columnPhyscicianNoteInjury = new TextColumn<PhysicianVisit>("note");
	
		//injury width
		columnProgressDateInjury.setMinWidth(150);
		columnProgressNoteInjury.setMinWidth(480);
		
		columnPhysicianDateInjury.setMinWidth(150);
		columnPhyscicianNoteInjury.setMinWidth(480);

		columnProgressDateInjury.setResizable(false);
		columnProgressNoteInjury.setResizable(false);
		
		columnPhysicianDateInjury.setResizable(false);
		columnPhyscicianNoteInjury.setResizable(false);
	
		//set titles
		columnProgressDateInjury.setText("Date");
		columnProgressNoteInjury.setText("Note");
		
		columnPhysicianDateInjury.setText("Date");
		columnPhyscicianNoteInjury.setText("Note");
	}	
	
	/**
	 * Calls all current injury information and adds it into the window.
	 * @param currentAthlete current athlete
	 */
	public void setInformation(Athlete currentAthlete) {
		this.currentAthlete = currentAthlete;
		this.currentInjury =currentAthlete.getCurrentInjury();
		
		editInjuryAthleteNameLabel.setText(currentAthlete.getFirstName()+" "+currentAthlete.getLastName());
		editInjuryBodyPartLabel1.setText(atdb.getBodyPartByID(currentAthlete.getCurrentInjury().getBodyPartID()));
		editInjuryInjuryTypeLabel1.setText(currentAthlete.getCurrentInjury().getInjuryType());
		editInjuryInjuryDateLabel1.setText(currentAthlete.getCurrentInjury().getInjuryDate().toString());
		editInjuryActiveInjuryCheckBox.setSelected(currentInjury.getActive());
		editInjurySNotesTextArea.setText(currentInjury.getSoapNotes().get(0).getSubjective());
		editInjuryONotesTextArea.setText(currentInjury.getSoapNotes().get(0).getObjective());
		editInjuryANotesTextArea.setText(currentInjury.getSoapNotes().get(0).getAssessment());
		editInjuryPNotesTextArea.setText(currentInjury.getSoapNotes().get(0).getPlan());
		
		//injury table
		columnProgressDateInjury = new TextColumn<InjuryProgress>("date");
		columnProgressNoteInjury = new TextColumn<InjuryProgress>("note");
		
		columnPhysicianDateInjury = new TextColumn<PhysicianVisit>("date");
		columnPhyscicianNoteInjury = new TextColumn<PhysicianVisit>("note");
	
		//injury width
		columnProgressDateInjury.setMinWidth(150);
		columnProgressNoteInjury.setMinWidth(480);
		
		columnPhysicianDateInjury.setMinWidth(150);
		columnPhyscicianNoteInjury.setMinWidth(480);

		columnProgressDateInjury.setResizable(false);
		columnProgressNoteInjury.setResizable(false);
		
		columnPhysicianDateInjury.setResizable(false);
		columnPhyscicianNoteInjury.setResizable(false);
	
		//set titles
		columnProgressDateInjury.setText("Date");
		columnProgressNoteInjury.setText("Note");
		
		columnPhysicianDateInjury.setText("Date");
		columnPhyscicianNoteInjury.setText("Note");
		
		//add columns to injury table
		editInjuryProgressNotesTableView.getColumns().clear();
		editInjuryProgressNotesTableView.getColumns().add(columnProgressDateInjury);
		editInjuryProgressNotesTableView.getColumns().add(columnProgressNoteInjury);
		
		editInjuryPhysicianNotesTableView.getColumns().clear();
		editInjuryPhysicianNotesTableView.getColumns().add(columnPhysicianDateInjury);
		editInjuryPhysicianNotesTableView.getColumns().add(columnPhyscicianNoteInjury);
		
		editInjuryProgressNotesTableView.getItems().setAll(currentInjury.getInjuryProgressNotes());
		editInjuryPhysicianNotesTableView.getItems().setAll(currentInjury.getPhysicianVisit());
		
		editInjurySNotesTextArea.setEditable(false);
		editInjuryONotesTextArea.setEditable(false);
		editInjuryANotesTextArea.setEditable(false);
		editInjuryPNotesTextArea.setEditable(false);
		
	}
	
	/**
	 * Makes changes to whether injury is active or not and updates the database.
	 * @param me action event 
	 */
	public void makeChangesButtonPressed(ActionEvent ae){
		System.out.println("make Changes button pressed");
		Injury newInjury = new Injury(currentAthlete.getCurrentInjury().getBodyPartID(), currentAthlete.getCurrentInjury().getInjuryID(), 
				currentAthlete.getCurrentInjury().getInjuryType(), currentAthlete.getCurrentInjury().getInjuryDate(),
				currentAthlete.getCurrentInjury().getActive(), currentAthlete.getCurrentInjury().getSeason(), currentAthlete.getCurrentInjury().getSoapNotes(), 
				currentAthlete.getCurrentInjury().getPhysicianVisit(), currentAthlete.getCurrentInjury().getInjuryProgressNotes());
		newInjury.setActive(editInjuryActiveInjuryCheckBox.isSelected());
		atdb.editActiveInjury(currentAthlete.getCurrentInjury(), newInjury);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Changes were made");
		alert.setHeaderText(null);
		alert.setContentText("Athlete active change made successfully");
		alert.showAndWait();
		
	}
	
	/**
	 * Takes information from the text box and date picker to create a new progress note
	 * then adds that note to the current athlete in the database.
	 * @param me mouse event
	 */
	public void addNoteProgressButton(ActionEvent me){
			LocalDate localDate = editInjuryNewProgressNotesDatePicker.getValue();
			Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
			Date date = Date.from(instant);
			InjuryProgress progressNote = new InjuryProgress(new java.sql.Date(date.getTime()), editInjuryNewProgressNotesTextArea.getText());
			System.out.println(progressNote);
			atdb.addProgressNote(currentInjury, progressNote);
			JOptionPane.showMessageDialog(null, "Progress Note Added", "Added", JOptionPane.OK_OPTION);
			editInjuryNewProgressNotesDatePicker.setValue(null);
			editInjuryNewProgressNotesTextArea.setText(null);
	}
	//TODO doesn't work
	/**
	 * Takes information from the text box and date picker to create a new physician note
	 * then adds that note to the current athlete in the database.
	 * @param me mouse event
	 */
	public void addNotePhysicianButton(ActionEvent me){
			LocalDate localDate = editInjuryNewPhysicianNotesDatePicker.getValue();
			Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
			Date date = Date.from(instant);
			PhysicianVisit progressNote = new  PhysicianVisit(new java.sql.Date(date.getTime()), editInjuryNewPhysicianNotesTextArea.getText());
			System.out.println(progressNote);
			System.out.println(progressNote.getDate());
			System.out.println(progressNote.getNote());
			atdb.addPhysicianVisit(currentInjury, progressNote);
			JOptionPane.showMessageDialog(null, "Progress Note Added", "Added", JOptionPane.OK_OPTION);
		
	}

}
