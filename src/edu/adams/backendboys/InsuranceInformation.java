package edu.adams.backendboys;

import java.sql.Date;

public class InsuranceInformation {
	private String studentSSN, companyName, insurancePhone, policyID, groupNummber, address, preCertPhone, 
	policyHolder, policyHolderPhone, policyHolderAddress, primaryPhysician, physicianPhone, insuranceCardFrontPath, insuranceCardBackPath;
	private Date policyEffective, policyExpiration;
	private Boolean coverAthleticInjury, referral;
	private int limit, deductible, coPay;
	
	@SuppressWarnings("unused")
	private InsuranceInformation(){
		
	}
	
	public InsuranceInformation(String studentSSN, String companyName, String insurancePhone, String policyID, 
			String groupNumber, String address, Date policyEffective, Date policyExpiration, 
			Boolean coverAthleticInjury, String preCertPhone, String policyHolder, String policyHolderPhone, 
			String policyHolderAddress, int limit, int deductible, int coPay, Boolean referral, 
			String primaryPhysician, String physicianPhone, String insuranceCardFrontPath, String insuranceCardBackPath){
		this.studentSSN=studentSSN;
		this.companyName=companyName;
		this.insurancePhone=insurancePhone;
		this.policyID=policyID;
		this.groupNummber=groupNumber;
		this.address=address;
		this.policyEffective=policyEffective;
		this.policyExpiration=policyExpiration;
		this.coverAthleticInjury=coverAthleticInjury;
		this.preCertPhone=preCertPhone;
		this.policyHolder=policyHolder;
		this.policyHolderPhone=policyHolderPhone;
		this.policyHolderAddress=policyHolderAddress;
		this.limit=limit;
		this.deductible=deductible;
		this.coPay=coPay;
		this.referral=referral;
		this.primaryPhysician=primaryPhysician;
		this.physicianPhone=physicianPhone;	
		this.insuranceCardFrontPath=insuranceCardFrontPath;
		this.insuranceCardBackPath=insuranceCardBackPath;
	}
	
	@Override
	public String toString() {
		return "InsuranceInformation [getStudentSSN()=" + getStudentSSN()
				+ ", getCompanyName()=" + getCompanyName()
				+ ", getInsurancePhone()=" + getInsurancePhone()
				+ ", getPolicyID()=" + getPolicyID() + ", getGroupNummber()="
				+ getGroupNummber() + ", getAddress()=" + getAddress()
				+ ", getPreCertPhone()=" + getPreCertPhone()
				+ ", getPolicyHolder()=" + getPolicyHolder()
				+ ", getPolicyHolderPhone()=" + getPolicyHolderPhone()
				+ ", getPolicyHolderAddress()=" + getPolicyHolderAddress()
				+ ", getPrimaryPhysician()=" + getPrimaryPhysician()
				+ ", getPhysicianPhone()=" + getPhysicianPhone()
				+ ", getPolicyEffective()=" + getPolicyEffective()
				+ ", getPolicyExpiration()=" + getPolicyExpiration()
				+ ", getCoverAthleticInjury()=" + getCoverAthleticInjury()
				+ ", getReferral()=" + getReferral() + ", getLimit()="
				+ getLimit() + ", getDeductible()=" + getDeductible()
				+ ", getCoPay()=" + getCoPay() + "]";
	}
	public String getStudentSSN() {
		return studentSSN;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getInsurancePhone() {
		return insurancePhone;
	}
	public String getPolicyID() {
		return policyID;
	}
	public String getGroupNummber() {
		return groupNummber;
	}
	public String getAddress() {
		return address;
	}
	public String getPreCertPhone() {
		return preCertPhone;
	}
	public String getPolicyHolder() {
		return policyHolder;
	}
	public String getPolicyHolderPhone() {
		return policyHolderPhone;
	}
	public String getPolicyHolderAddress() {
		return policyHolderAddress;
	}
	public String getPrimaryPhysician() {
		return primaryPhysician;
	}
	public String getPhysicianPhone() {
		return physicianPhone;
	}
	public Date getPolicyEffective() {
		return policyEffective;
	}
	public Date getPolicyExpiration() {
		return policyExpiration;
	}
	public Boolean getCoverAthleticInjury() {
		return coverAthleticInjury;
	}
	public Boolean getReferral() {
		return referral;
	}
	public int getLimit() {
		return limit;
	}
	public int getDeductible() {
		return deductible;
	}
	public int getCoPay() {
		return coPay;
	}
	public String getInsuranceCardFrontPath(){
		return insuranceCardFrontPath;
	}
	public String getInsuranceCardBackPath(){
		return insuranceCardBackPath;
	}
	public void setInsuranceCardFrontPath(String insuranceCardFrontPath){
		this.insuranceCardFrontPath = insuranceCardFrontPath;
	}
	public void setInsuranceCardBackPath(String insuranceCardBackPath){
		this.insuranceCardBackPath = insuranceCardBackPath;
	}
	public void setStudentSSN(String studentSSN) {
		this.studentSSN = studentSSN;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setInsurancePhone(String insurancePhone) {
		this.insurancePhone = insurancePhone;
	}
	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}
	public void setGroupNummber(String groupNummber) {
		this.groupNummber = groupNummber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPreCertPhone(String preCertPhone) {
		this.preCertPhone = preCertPhone;
	}
	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}
	public void setPolicyHolderPhone(String policyHolderPhone) {
		this.policyHolderPhone = policyHolderPhone;
	}
	public void setPolicyHolderAddress(String policyHolderAddress) {
		this.policyHolderAddress = policyHolderAddress;
	}
	public void setPrimaryPhysician(String primaryPhysician) {
		this.primaryPhysician = primaryPhysician;
	}
	public void setPhysicianPhone(String physicianPhone) {
		this.physicianPhone = physicianPhone;
	}
	public void setPolicyEffective(Date policyEffective) {
		this.policyEffective = policyEffective;
	}
	public void setPolicyExpiration(Date policyExpiration) {
		this.policyExpiration = policyExpiration;
	}
	public void setCoverAthleticInjury(Boolean coverAthleticInjury) {
		this.coverAthleticInjury = coverAthleticInjury;
	}
	public void setReferral(Boolean referral) {
		this.referral = referral;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public void setDeductible(int deductible) {
		this.deductible = deductible;
	}
	public void setCoPay(int coPay) {
		this.coPay = coPay;
	}
	
	
}
