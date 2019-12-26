package NikalayevaPfeiffer;

import java.time.LocalDate;

public class Child  extends Person{
	
	private Time timeInPlaygroup;
	private boolean transportation;
	private String allergies;
	private LocalDate DOB;
	private Parent parent;
	private EmergencyContact emergencyContact;

	public Child(String firstName, String lastName, Time timeInPlaygroup, String allergies, LocalDate DOB,
			Parent parent, EmergencyContact emergencyContact) {
		super(firstName,lastName);
		// if no transportation entered assuming kid doesn't get it
		if (validateDOB(DOB)) {
			this.DOB = DOB;
		} else {
			System.out.println("Only kids between the ages 1-5 are allowed to the playgroup.");
			return;
		}
		this.transportation = false;
		this.timeInPlaygroup = timeInPlaygroup;
		this.allergies = allergies;
		this.parent = parent;
		this.emergencyContact = emergencyContact;
	}
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	public void setTimeInPlaygroup(Time timeInPlaygroup) {
		this.timeInPlaygroup = timeInPlaygroup;
	}

	public void setTransportation(boolean transportation) {
		this.transportation = transportation;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public void setDOB(LocalDate DOB) {
		if (validateDOB(DOB)) {
			this.DOB = DOB;
		} else {
			System.out.println("Only kids between the ages 1-5 are allowed to the playgroup.");
			return;
		}
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getFirstName() {
		return super.getFirstName();
	}

	public String getLastName() {
		return super.getLastName();
	}

	public Time getTimeInPlaygroup() {
		return timeInPlaygroup;
	}

	public boolean getTransportation() {
		return transportation;
	}

	public String getAllergies() {
		return allergies;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public Parent getParent() {
		return parent;
	}

	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}

	@Override
	public String toString() {
		return super.toString()+" Time In Playgroup: "+ timeInPlaygroup+" Transportation: "+transportation+" Allergy Information: " 
				+allergies+" Date of Birth: "+DOB+" Parent Information: " + parent.toString() + " Emergency Contact: "+emergencyContact;
	}

	public boolean isSameChild(Child c) {
		if(c==null) {
			return false;
		}
		return (this.getFirstName().equals(c.getFirstName()) && this.getLastName().equals(c.getLastName()) && this.DOB.equals(c.DOB));
	}
	public boolean isSameChild(String firstName, String lastName,  LocalDate DOB) {
		return (this.getFirstName().equals(firstName) && this.getLastName().equals(lastName) && this.DOB.equals(DOB));
	}

	private boolean validateDOB(LocalDate DOB) {
		// ages 1-5 are allowed to be in the playgroup. using days to ensure correct age
		LocalDate today = LocalDate.now();
		LocalDate from = today.minusDays(1825);
		LocalDate to = today.minusDays(365);
		if (!DOB.isBefore(from) && !DOB.isAfter(to)) {
			return true;
		}
		return false;
	}
}
