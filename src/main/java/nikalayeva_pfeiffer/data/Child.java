package nikalayeva_pfeiffer.data;

import java.time.LocalDate;

import nikalayeva_pfeiffer.TimeInPlaygroup;

public class Child extends Person {

	private TimeInPlaygroup timeInPlaygroup;
	private boolean transportation;
	private String allergies;
	private LocalDate dob;
	private Parent parent;
	private EmergencyContact emergencyContact;

	public Child(String firstName, String lastName, TimeInPlaygroup timeInPlaygroup, String allergies, LocalDate dob,
			Parent parent, EmergencyContact emergencyContact) {
		super(firstName, lastName);
		this.dob = dob;
		this.transportation = false;
		this.timeInPlaygroup = timeInPlaygroup;
		this.allergies = allergies;
		this.parent = parent;
		this.emergencyContact = emergencyContact;
	}
	
	public void setTimeInPlaygroup(TimeInPlaygroup timeInPlaygroup) {
		this.timeInPlaygroup = timeInPlaygroup;
	}

	public void setTransportation(boolean transportation) {
		this.transportation = transportation;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setDOB(LocalDate dob) {
		this.dob = dob;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public TimeInPlaygroup getTimeInPlaygroup() {
		return timeInPlaygroup;
	}

	public boolean getTransportation() {
		return transportation;
	}

	public String getAllergies() {
		return allergies;
	}

	public LocalDate getDOB() {
		return dob;
	}

	public Parent getParent() {
		return parent;
	}

	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}

	@Override
	public String toString() {
		return super.toString() + " Time In Playgroup: " + timeInPlaygroup + " Transportation: " + transportation
				+ " Allergy Information: " + allergies + " Date of Birth: " + dob + " Parent Information: "
				+ parent.toString() + " Emergency Contact: " + emergencyContact;
	}

}
