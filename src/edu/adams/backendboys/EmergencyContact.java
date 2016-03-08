package edu.adams.backendboys;

public class EmergencyContact {
	private String Contact1Name, Contact1Phone, Contact2Name, Contact2Phone;
	
	@SuppressWarnings("unused")
	public EmergencyContact(){
		
	}
	
	public EmergencyContact(String Contact1Name,String Contact1Phone,String Contact2Name,String Contact2Phone){
		this.Contact1Name=Contact1Name;
		this.Contact1Phone=Contact1Phone;
		this.Contact2Name=Contact2Name;
		this.Contact2Phone=Contact2Phone;
	}
	
	@Override
	public String toString() {
		return "EmergencyContact [getContact1Name()=" + getContact1Name()
				+ ", getContact1Phone()=" + getContact1Phone()
				+ ", getContact2Name()=" + getContact2Name()
				+ ", getContact2Phone()=" + getContact2Phone() + "]";
	}

	public String getContact1Name() {
		return Contact1Name;
	}

	public void setContact1Name(String contact1Name) {
		Contact1Name = contact1Name;
	}

	public void setContact1Phone(String contact1Phone) {
		Contact1Phone = contact1Phone;
	}

	public void setContact2Name(String contact2Name) {
		Contact2Name = contact2Name;
	}

	public void setContact2Phone(String contact2Phone) {
		Contact2Phone = contact2Phone;
	}

	public String getContact1Phone() {
		return Contact1Phone;
	}

	public String getContact2Name() {
		return Contact2Name;
	}

	public String getContact2Phone() {
		return Contact2Phone;
	}
	
	
}
