package mainclient;

import java.net.URL;
import java.util.ResourceBundle;

import sun.security.jca.GetInstance;
import edu.adams.backendboys.Athlete;
import edu.adams.backendboys.AthleteTrackerDatabase;
import edu.adams.backendboys.Injury;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * This class provides all of the functionality to the insurance window.
 * @author ZBagby
 *
 */
public class InsuranceWindowController implements Initializable {
	
	AthleteTrackerDatabase atdb = new AthleteTrackerDatabase();
	
	private Athlete currentAthlete = null;
	@FXML
	private Button insuranceInformationEditButton,
		insuranceInformationCancelButton;
	@FXML
	private TextField athleteFirstNameInsuranceInformationLabel1,
		athleteMiddleInitialInsuranceInformationLabel1,
		athleteLastNameInsuranceInformationLabel1,
		dobInsuranceInformationLabel1,
		athleteCellInsuranceInformationLabel1,
		ssnInsuranceInformationLabel1,
		genderInsuranceInformationLabel1,
		sportsInsuranceInformationLabel1,
		allergiesInsuranceInformationLabel1,
		medicationsInsuranceInformationLabel1,
		ecInsuranceInformationLabel11,
		ecPhoneInsuranceInformationLabel11,
		ecInsuranceInformationLabel21,
		ecPhoneInsuranceInformationLabel21,
		insuranceNameInsuranceInformationLabel11,
		insuranceAddressInsuranceInformationLabel1,
		insurancePhoneInsuranceInformationLabel1,
		groupNumberInsuranceInformationLabel1,
		effectiveDateInsuranceInformationLabel1,
		expirationDateInsuranceInformationLabel1,
		coverAthleteInjuryInsuranceInformationLabel1,
		precertificationPhoneInsuranceInformationLabel1,
		policyHolderInsuranceInformationLabel1,
		policyHolderPhoneInsuranceInformationLabel1,
		policyHolderAddressInsuranceInformationLabel1,
		policyIdInsuranceInformationLabel1,
		limitInsuranceInformationLabel1,
		deductibleInsuranceInformationLabel1,
		copayInsuranceInformationLabel1,
		referralInsuranceInformationLabel1,
		primaryPhysicianInsuranceInformationLabel1,
		physicianPhoneInsuranceInformationLabel1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	/**
	 * Fills in all insurance information from current athlete.
	 * @param currentAthlete current athlete
	 */
	public void setAthlete(Athlete currentAthlete){
		this.currentAthlete = currentAthlete;
		athleteFirstNameInsuranceInformationLabel1.setText(currentAthlete.getFirstName());
		athleteMiddleInitialInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getMiddleInitial()));
		athleteLastNameInsuranceInformationLabel1.setText(currentAthlete.getLastName());
		dobInsuranceInformationLabel1.setText(currentAthlete.getDateOfBirth().toString());
		athleteCellInsuranceInformationLabel1.setText(currentAthlete.getCellNumber());
		ssnInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getStudentSSN());
		genderInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getGender()));
		sportsInsuranceInformationLabel1.setText(currentAthlete.getSports());
		allergiesInsuranceInformationLabel1.setText(currentAthlete.getAllergies());
		medicationsInsuranceInformationLabel1.setText(currentAthlete.getMedications());
		ecInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Name());
		ecPhoneInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Phone());
		ecInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Name());
		ecPhoneInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Phone());
		insuranceNameInsuranceInformationLabel11.setText(currentAthlete.getInsuranceInfo().getCompanyName());
		insuranceAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getAddress());
		insurancePhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getInsurancePhone());
		groupNumberInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getGroupNummber());
		effectiveDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyEffective().toString());
		expirationDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyExpiration().toString());
		coverAthleteInjuryInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getCoverAthleticInjury().toString());
		precertificationPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPreCertPhone());
		policyHolderInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolder());
		policyHolderPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderPhone());
		policyHolderAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderAddress());
		policyIdInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyID());
		limitInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getLimit());
		deductibleInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getDeductible());
		copayInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getCoPay());
		referralInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getReferral().toString());
		primaryPhysicianInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPrimaryPhysician());
		physicianPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPhysicianPhone());
	
	}
	
	/**
	 * Toggle button allowing text to be editable and saves and makes changes.
	 * @param ae action event
	 */
	public void insuranceInformationEditButtonAction(ActionEvent ae){
			ae.consume();
		if(insuranceInformationEditButton.getText().startsWith("Edit"))
		{
			insuranceInformationEditButton.setText("Save");
			
			athleteFirstNameInsuranceInformationLabel1.setEditable(true);
			athleteMiddleInitialInsuranceInformationLabel1.setEditable(true);
			athleteLastNameInsuranceInformationLabel1.setEditable(true);
			dobInsuranceInformationLabel1.setEditable(true);
			athleteCellInsuranceInformationLabel1.setEditable(true);
			ssnInsuranceInformationLabel1.setEditable(true);
			genderInsuranceInformationLabel1.setEditable(true);
			sportsInsuranceInformationLabel1.setEditable(true);
			allergiesInsuranceInformationLabel1.setEditable(true);
			medicationsInsuranceInformationLabel1.setEditable(true);
			ecInsuranceInformationLabel11.setEditable(true);
			ecPhoneInsuranceInformationLabel11.setEditable(true);
			ecInsuranceInformationLabel21.setEditable(true);
			ecPhoneInsuranceInformationLabel21.setEditable(true);
			insuranceNameInsuranceInformationLabel11.setEditable(true);
			insuranceAddressInsuranceInformationLabel1.setEditable(true);
			insurancePhoneInsuranceInformationLabel1.setEditable(true);
			groupNumberInsuranceInformationLabel1.setEditable(true);
			effectiveDateInsuranceInformationLabel1.setEditable(true);
			expirationDateInsuranceInformationLabel1.setEditable(true);
			coverAthleteInjuryInsuranceInformationLabel1.setEditable(true);
			precertificationPhoneInsuranceInformationLabel1.setEditable(true);
			policyHolderInsuranceInformationLabel1.setEditable(true);
			policyHolderPhoneInsuranceInformationLabel1.setEditable(true);
			policyHolderAddressInsuranceInformationLabel1.setEditable(true);
			policyIdInsuranceInformationLabel1.setEditable(true);
			limitInsuranceInformationLabel1.setEditable(true);
			deductibleInsuranceInformationLabel1.setEditable(true);
			copayInsuranceInformationLabel1.setEditable(true);
			referralInsuranceInformationLabel1.setEditable(true);
			primaryPhysicianInsuranceInformationLabel1.setEditable(true);
			physicianPhoneInsuranceInformationLabel1.setEditable(true);
			
			//set css class
			athleteFirstNameInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			athleteMiddleInitialInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			athleteLastNameInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			dobInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			ssnInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			genderInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			sportsInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			ecInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			ecInsuranceInformationLabel21.getStyleClass().add("displayInsuranceEdit");
			ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsuranceEdit");
			insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsuranceEdit");
			insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyHolderAddressInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			policyIdInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			limitInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			copayInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			referralInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsuranceEdit");
			
			//reveal cancel button
			insuranceInformationCancelButton.setVisible(true);
			
		}
		
		else
		{
			//TODO
			Athlete updatedAthlete = new Athlete(currentAthlete.getFirstName(), currentAthlete.getMiddleInitial(), 
					currentAthlete.getLastName(), currentAthlete.getDateOfBirth(), currentAthlete.getCellNumber(), 
					currentAthlete.getStudentID(), currentAthlete.getGender(), currentAthlete.getYearAtUniversity(), 
					currentAthlete.getEligibility(), currentAthlete.isActive(), currentAthlete.getAllergies(), 
					currentAthlete.getMedications(), currentAthlete.getSports(), currentAthlete.getInjuryList(), 
					currentAthlete.getContacts(), currentAthlete.getInsuranceInfo());
			
			updatedAthlete.setFirstName(athleteFirstNameInsuranceInformationLabel1.getText());
			updatedAthlete.setMiddleInitial(athleteMiddleInitialInsuranceInformationLabel1.getCharacters().charAt(0));
			updatedAthlete.setLastName(athleteLastNameInsuranceInformationLabel1.getText());
			updatedAthlete.setDateOfBirth(java.sql.Date.valueOf(dobInsuranceInformationLabel1.getText()));
			updatedAthlete.setCellNumber(athleteCellInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setStudentSSN(ssnInsuranceInformationLabel1.getText());
			updatedAthlete.setGender(genderInsuranceInformationLabel1.getCharacters().charAt(0));
			updatedAthlete.setSports(sportsInsuranceInformationLabel1.getText());
			updatedAthlete.setAllergies(allergiesInsuranceInformationLabel1.getText());
			updatedAthlete.setMedications(medicationsInsuranceInformationLabel1.getText());
			updatedAthlete.getContacts().setContact1Name(ecInsuranceInformationLabel11.getText());
			updatedAthlete.getContacts().setContact1Phone(ecPhoneInsuranceInformationLabel11.getText());
			updatedAthlete.getContacts().setContact2Name(ecInsuranceInformationLabel21.getText());
			updatedAthlete.getContacts().setContact2Phone(ecPhoneInsuranceInformationLabel21.getText());
			updatedAthlete.getInsuranceInfo().setCompanyName(insuranceNameInsuranceInformationLabel11.getText());
			updatedAthlete.getInsuranceInfo().setAddress(insuranceAddressInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setInsurancePhone(insurancePhoneInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setGroupNummber(groupNumberInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPolicyEffective(java.sql.Date.valueOf(effectiveDateInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setPolicyExpiration(java.sql.Date.valueOf(expirationDateInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setCoverAthleticInjury(Boolean.valueOf(coverAthleteInjuryInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setPreCertPhone(precertificationPhoneInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPolicyHolder(policyHolderInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPolicyHolderPhone(policyHolderPhoneInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPolicyHolderAddress(policyHolderAddressInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPolicyID(policyIdInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setLimit(Integer.parseInt(limitInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setDeductible(Integer.parseInt(deductibleInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setCoPay(Integer.parseInt(copayInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setReferral(Boolean.valueOf(referralInsuranceInformationLabel1.getText()));
			updatedAthlete.getInsuranceInfo().setPrimaryPhysician(primaryPhysicianInsuranceInformationLabel1.getText());
			updatedAthlete.getInsuranceInfo().setPhysicianPhone(physicianPhoneInsuranceInformationLabel1.getText());
			
			atdb.editAthlete(currentAthlete, updatedAthlete);
			atdb.editInsurance(currentAthlete, updatedAthlete.getInsuranceInfo());
						
			insuranceInformationEditButton.setText("Edit");
			
			athleteFirstNameInsuranceInformationLabel1.setEditable(false);
			athleteMiddleInitialInsuranceInformationLabel1.setEditable(false);
			athleteLastNameInsuranceInformationLabel1.setEditable(false);
			dobInsuranceInformationLabel1.setEditable(false);
			athleteCellInsuranceInformationLabel1.setEditable(false);
			ssnInsuranceInformationLabel1.setEditable(false);
			genderInsuranceInformationLabel1.setEditable(false);
			sportsInsuranceInformationLabel1.setEditable(false);
			allergiesInsuranceInformationLabel1.setEditable(false);
			medicationsInsuranceInformationLabel1.setEditable(false);
			ecInsuranceInformationLabel11.setEditable(false);
			ecPhoneInsuranceInformationLabel11.setEditable(false);
			ecInsuranceInformationLabel21.setEditable(false);
			ecPhoneInsuranceInformationLabel21.setEditable(false);
			insuranceNameInsuranceInformationLabel11.setEditable(false);
			insuranceAddressInsuranceInformationLabel1.setEditable(false);
			insurancePhoneInsuranceInformationLabel1.setEditable(false);
			groupNumberInsuranceInformationLabel1.setEditable(false);
			effectiveDateInsuranceInformationLabel1.setEditable(false);
			expirationDateInsuranceInformationLabel1.setEditable(false);
			coverAthleteInjuryInsuranceInformationLabel1.setEditable(false);
			precertificationPhoneInsuranceInformationLabel1.setEditable(false);
			policyHolderInsuranceInformationLabel1.setEditable(false);
			policyHolderPhoneInsuranceInformationLabel1.setEditable(false);
			policyHolderAddressInsuranceInformationLabel1.setEditable(false);
			policyIdInsuranceInformationLabel1.setEditable(false);
			limitInsuranceInformationLabel1.setEditable(false);
			deductibleInsuranceInformationLabel1.setEditable(false);
			copayInsuranceInformationLabel1.setEditable(false);
			referralInsuranceInformationLabel1.setEditable(false);
			primaryPhysicianInsuranceInformationLabel1.setEditable(false);
			physicianPhoneInsuranceInformationLabel1.setEditable(false);
			
			athleteFirstNameInsuranceInformationLabel1.getStyleClass().clear();
			athleteMiddleInitialInsuranceInformationLabel1.getStyleClass().clear();
			athleteLastNameInsuranceInformationLabel1.getStyleClass().clear();
			dobInsuranceInformationLabel1.getStyleClass().clear();
			athleteCellInsuranceInformationLabel1.getStyleClass().clear();
			ssnInsuranceInformationLabel1.getStyleClass().clear();
			genderInsuranceInformationLabel1.getStyleClass().clear();
			sportsInsuranceInformationLabel1.getStyleClass().clear();
			allergiesInsuranceInformationLabel1.getStyleClass().clear();
			medicationsInsuranceInformationLabel1.getStyleClass().clear();
			ecInsuranceInformationLabel11.getStyleClass().clear();
			ecPhoneInsuranceInformationLabel11.getStyleClass().clear();
			ecInsuranceInformationLabel21.getStyleClass().clear();
			ecPhoneInsuranceInformationLabel21.getStyleClass().clear();
			insuranceNameInsuranceInformationLabel11.getStyleClass().clear();
			insuranceAddressInsuranceInformationLabel1.getStyleClass().clear();
			insurancePhoneInsuranceInformationLabel1.getStyleClass().clear();
			groupNumberInsuranceInformationLabel1.getStyleClass().clear();
			effectiveDateInsuranceInformationLabel1.getStyleClass().clear();
			expirationDateInsuranceInformationLabel1.getStyleClass().clear();
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().clear();
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().clear();
			policyHolderInsuranceInformationLabel1.getStyleClass().clear();
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().clear();
			policyHolderAddressInsuranceInformationLabel1.getStyleClass().clear();
			policyIdInsuranceInformationLabel1.getStyleClass().clear();
			limitInsuranceInformationLabel1.getStyleClass().clear();
			deductibleInsuranceInformationLabel1.getStyleClass().clear();
			copayInsuranceInformationLabel1.getStyleClass().clear();
			referralInsuranceInformationLabel1.getStyleClass().clear();
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().clear();
			physicianPhoneInsuranceInformationLabel1.getStyleClass().clear();
			
			//set css class
			athleteFirstNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			athleteMiddleInitialInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			athleteLastNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			dobInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			ssnInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			genderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			sportsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			ecInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			ecInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
			ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
			insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
			insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyHolderAddressInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			policyIdInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			limitInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			copayInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			referralInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
			
			//hide cancel button
			insuranceInformationCancelButton.setVisible(false);
			
			}
		}

	/**
	 * cancels all changes made.
	 * @param ae action event
	 */
	public void insuranceInformationCancelButtonAction(ActionEvent ae)
	{
		ae.consume();
		
		//hide cancel button
		insuranceInformationCancelButton.setVisible(false);
		
		insuranceInformationEditButton.setText("Edit");
		
		athleteFirstNameInsuranceInformationLabel1.setText(currentAthlete.getFirstName());
		athleteMiddleInitialInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getMiddleInitial()));
		athleteLastNameInsuranceInformationLabel1.setText(currentAthlete.getLastName());
		dobInsuranceInformationLabel1.setText(currentAthlete.getDateOfBirth().toString());
		athleteCellInsuranceInformationLabel1.setText(currentAthlete.getCellNumber());
		ssnInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getStudentSSN());
		genderInsuranceInformationLabel1.setText(String.valueOf(currentAthlete.getGender()));
		sportsInsuranceInformationLabel1.setText(currentAthlete.getSports());
		allergiesInsuranceInformationLabel1.setText(currentAthlete.getAllergies());
		medicationsInsuranceInformationLabel1.setText(currentAthlete.getMedications());
		ecInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Name());
		ecPhoneInsuranceInformationLabel11.setText(currentAthlete.getContacts().getContact1Phone());
		ecInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Name());
		ecPhoneInsuranceInformationLabel21.setText(currentAthlete.getContacts().getContact2Phone());
		insuranceNameInsuranceInformationLabel11.setText(currentAthlete.getInsuranceInfo().getCompanyName());
		insuranceAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getAddress());
		insurancePhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getInsurancePhone());
		groupNumberInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getGroupNummber());
		effectiveDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyEffective().toString());
		expirationDateInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyExpiration().toString());
		coverAthleteInjuryInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getCoverAthleticInjury().toString());
		precertificationPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPreCertPhone());
		policyHolderInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolder());
		policyHolderPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderPhone());
		policyHolderAddressInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyHolderAddress());
		policyIdInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPolicyID());
		limitInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getLimit());
		deductibleInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getDeductible());
		copayInsuranceInformationLabel1.setText(""+currentAthlete.getInsuranceInfo().getCoPay());
		referralInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getReferral().toString());
		primaryPhysicianInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPrimaryPhysician());
		physicianPhoneInsuranceInformationLabel1.setText(currentAthlete.getInsuranceInfo().getPhysicianPhone());
		
		athleteFirstNameInsuranceInformationLabel1.setEditable(false);
		athleteMiddleInitialInsuranceInformationLabel1.setEditable(false);
		athleteLastNameInsuranceInformationLabel1.setEditable(false);
		dobInsuranceInformationLabel1.setEditable(false);
		athleteCellInsuranceInformationLabel1.setEditable(false);
		ssnInsuranceInformationLabel1.setEditable(false);
		genderInsuranceInformationLabel1.setEditable(false);
		sportsInsuranceInformationLabel1.setEditable(false);
		allergiesInsuranceInformationLabel1.setEditable(false);
		medicationsInsuranceInformationLabel1.setEditable(false);
		ecInsuranceInformationLabel11.setEditable(false);
		ecPhoneInsuranceInformationLabel11.setEditable(false);
		ecInsuranceInformationLabel21.setEditable(false);
		ecPhoneInsuranceInformationLabel21.setEditable(false);
		insuranceNameInsuranceInformationLabel11.setEditable(false);
		insuranceAddressInsuranceInformationLabel1.setEditable(false);
		insurancePhoneInsuranceInformationLabel1.setEditable(false);
		groupNumberInsuranceInformationLabel1.setEditable(false);
		effectiveDateInsuranceInformationLabel1.setEditable(false);
		expirationDateInsuranceInformationLabel1.setEditable(false);
		coverAthleteInjuryInsuranceInformationLabel1.setEditable(false);
		precertificationPhoneInsuranceInformationLabel1.setEditable(false);
		policyHolderInsuranceInformationLabel1.setEditable(false);
		policyHolderPhoneInsuranceInformationLabel1.setEditable(false);
		limitInsuranceInformationLabel1.setEditable(false);
		deductibleInsuranceInformationLabel1.setEditable(false);
		copayInsuranceInformationLabel1.setEditable(false);
		referralInsuranceInformationLabel1.setEditable(false);
		primaryPhysicianInsuranceInformationLabel1.setEditable(false);
		physicianPhoneInsuranceInformationLabel1.setEditable(false);
		
		//clear css class
		athleteFirstNameInsuranceInformationLabel1.getStyleClass().clear();
		athleteMiddleInitialInsuranceInformationLabel1.getStyleClass().clear();
		athleteLastNameInsuranceInformationLabel1.getStyleClass().clear();
		dobInsuranceInformationLabel1.getStyleClass().clear();
		athleteCellInsuranceInformationLabel1.getStyleClass().clear();
		ssnInsuranceInformationLabel1.getStyleClass().clear();
		genderInsuranceInformationLabel1.getStyleClass().clear();
		sportsInsuranceInformationLabel1.getStyleClass().clear();
		allergiesInsuranceInformationLabel1.getStyleClass().clear();
		medicationsInsuranceInformationLabel1.getStyleClass().clear();
		ecInsuranceInformationLabel11.getStyleClass().clear();
		ecPhoneInsuranceInformationLabel11.getStyleClass().clear();
		ecInsuranceInformationLabel21.getStyleClass().clear();
		ecPhoneInsuranceInformationLabel21.getStyleClass().clear();
		insuranceNameInsuranceInformationLabel11.getStyleClass().clear();
		insuranceAddressInsuranceInformationLabel1.getStyleClass().clear();
		insurancePhoneInsuranceInformationLabel1.getStyleClass().clear();
		groupNumberInsuranceInformationLabel1.getStyleClass().clear();
		effectiveDateInsuranceInformationLabel1.getStyleClass().clear();
		expirationDateInsuranceInformationLabel1.getStyleClass().clear();
		coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().clear();
		precertificationPhoneInsuranceInformationLabel1.getStyleClass().clear();
		policyHolderInsuranceInformationLabel1.getStyleClass().clear();
		policyHolderPhoneInsuranceInformationLabel1.getStyleClass().clear();
		limitInsuranceInformationLabel1.getStyleClass().clear();
		deductibleInsuranceInformationLabel1.getStyleClass().clear();
		copayInsuranceInformationLabel1.getStyleClass().clear();
		referralInsuranceInformationLabel1.getStyleClass().clear();
		primaryPhysicianInsuranceInformationLabel1.getStyleClass().clear();
		physicianPhoneInsuranceInformationLabel1.getStyleClass().clear();
		
		//set css class
		athleteFirstNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		athleteMiddleInitialInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		athleteLastNameInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		dobInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		athleteCellInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		ssnInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		genderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		sportsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		allergiesInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		medicationsInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		ecInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		ecPhoneInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		ecInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
		ecPhoneInsuranceInformationLabel21.getStyleClass().add("displayInsurance");
		insuranceNameInsuranceInformationLabel11.getStyleClass().add("displayInsurance");
		insuranceAddressInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		insurancePhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		groupNumberInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		effectiveDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		expirationDateInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		coverAthleteInjuryInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		precertificationPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		policyHolderInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		policyHolderPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		limitInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		deductibleInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		copayInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		referralInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		primaryPhysicianInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
		physicianPhoneInsuranceInformationLabel1.getStyleClass().add("displayInsurance");
	}
}
