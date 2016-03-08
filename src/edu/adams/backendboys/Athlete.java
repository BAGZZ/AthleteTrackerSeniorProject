package edu.adams.backendboys;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to created new athletes with every attribute needed.
 * @author ZBagby
 *
 */
public class Athlete {
	private String firstName,lastName,cellNumber,YearAtUniversity,eligibility,sports, allergies, medications;
	private char middleInitial,gender;
	private Date dateOfBirth;
	private int studentID;
	private boolean active;
	private boolean activeInjury=false;
	private ArrayList<Injury> injuryList;
	private Injury currentInjury=null;
	private String injuries="";
	private EmergencyContact contacts;
	private InsuranceInformation insuranceInfo;
	
	@SuppressWarnings("unused")
	public Athlete(){
		
	}
	
	/**
	 * constructor
	 * @param firstName first name	
	 * @param middleInitial middle initial
	 * @param lastName last name
	 * @param dateOfBirth date of birth
	 * @param cellNumber cell number
	 * @param studentID student ID number
	 * @param gender gender
	 * @param yearAtUniversity year at university (1,2...)
	 * @param eligibility eligibility (freshman,sophomore...)
	 * @param active Active? true/false
	 * @param allergies list of allergies
	 * @param medications list of medications
	 * @param sports sports of athlete
	 * @param injuries injuries (past and present)
	 * @param contacts emergency contacts
	 * @param insuranceInfo insurance information
	 */
	public Athlete(String firstName,char middleInitial, String lastName, Date dateOfBirth,
					String cellNumber,int studentID,char gender,String yearAtUniversity,
					String eligibility, boolean active, String allergies,String medications, String sports, ArrayList<Injury> injuries,
					EmergencyContact contacts, InsuranceInformation insuranceInfo){
		
		this.firstName=firstName;
		this.middleInitial=middleInitial;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.cellNumber=cellNumber;
		this.studentID=studentID;
		this.gender=gender;
		this.YearAtUniversity=yearAtUniversity;
		this.eligibility=eligibility;
		this.sports=sports;
		this.active=active;
		this.allergies=allergies;
		this.medications=medications;
		this.injuryList=injuries;
		this.contacts=contacts;
		this.insuranceInfo=insuranceInfo;
		for(int count=0; count<this.injuryList.size()-1;count++){
			this.injuries+=injuryList.get(count).getInjuryType()+", ";
			this.activeInjury= this.activeInjury || injuryList.get(count).getActive();
		}
		if(!this.injuryList.isEmpty()){
			currentInjury=this.injuryList.get(0);
			this.injuries+=injuryList.get(injuryList.size()-1).getInjuryType();
			this.activeInjury= this.activeInjury || injuryList.get(injuryList.size()-1).getActive();
		}
		
	}

	@Override
	public String toString() {
		return "Athlete [getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getCellNumber()=" + getCellNumber()
				+ ", getYearAtUniversity()=" + getYearAtUniversity()
				+ ", getEligibility()=" + getEligibility() + ", getSports()="
				+ getSports() + ", getMiddleInitial()=" + getMiddleInitial()
				+ ", getGender()=" + getGender() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getStudentID()=" + getStudentID()
				+ ", isActive()=" + isActive() + ", getInjuries()="
				+ getInjuries() + ", getContacts()=" + getContacts()
				+ ", getInsuranceInfo()=" + getInsuranceInfo() + "]";
	}

	/**
	 * returns current injury
	 * @return current injury
	 */
	public Injury getCurrentInjury() {
		return currentInjury;
	}

	/**
	 * sets current injury
	 * @param currentInjury current injury
	 */
	public void setCurrentInjury(Injury currentInjury) {
		this.currentInjury = currentInjury;
	}

	/**
	 * returns allergies
	 * @return allergies
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * returns medications
	 * @return medications
	 */
	public String getMedications() {
		return medications;
	}

	/**
	 * returns first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * returns if athlete has an active injury or not
	 * @return active injury true/false
	 */
	public boolean getActiveInjury() {
		return activeInjury;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public void setYearAtUniversity(String yearAtUniversity) {
		YearAtUniversity = yearAtUniversity;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setMedications(String medications) {
		this.medications = medications;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setActiveInjury(boolean activeInjury) {
		this.activeInjury = activeInjury;
	}

	public void setInjuryList(ArrayList<Injury> injuryList) {
		this.injuryList = injuryList;
	}

	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}

	public void setContacts(EmergencyContact contacts) {
		this.contacts = contacts;
	}

	public void setInsuranceInfo(InsuranceInformation insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}

	/**
	 * returns last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * returns cell number
	 * @return cell number
	 */
	public String getCellNumber() {
		return cellNumber;
	}

	/**
	 * returns year at university
	 * @return year at university
	 */
	public String getYearAtUniversity() {
		return YearAtUniversity;
	}

	/**
	 * returns eligibility
	 * @return eligibility
	 */
	public String getEligibility() {
		return eligibility;
	}

	/**
	 * returns sports
	 * @return sports
	 */
	public String getSports() {
		return sports;
	}

	/**
	 * returns middle initial
	 * @return middle initial
	 */
	public char getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * returns gender
	 * @return gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * returns date of birth
	 * @return date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * returns student id
	 * @return student id
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * returns if athlete is an active athlete or not (still playing or not)
	 * @return whether student is active or not
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * returns list of injuries
	 * @return list of injuries
	 */
	public ArrayList<Injury> getInjuryList() {
		return injuryList;
	}
	
	/**
	 * returns injuries not as list
	 * @return injuries
	 */
	public String getInjuries(){
		return injuries;
	}
	
	/**
	 * returns emergency contacts
	 * @return emergency contacts
	 */
	public EmergencyContact getContacts() {
		return contacts;
	}

	/**
	 * returns insurance information
	 * @return insurance information
	 */
	public InsuranceInformation getInsuranceInfo() {
		return insuranceInfo;
	}
}