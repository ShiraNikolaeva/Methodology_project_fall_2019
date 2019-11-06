package NikalayevaPfeiffer;


import java.time.LocalDate;

public class Child {
	private String firstName;
	private String lastName;
	private Time timeInPlaygroup;
	private boolean transportation;
	private String allergies;
	private LocalDate DOB;
	private Parent parent;
	private String emergencyContact;

public Child(String firstName, String lastName, Time timeInPlaygroup, String allergies, LocalDate DOB, Parent parent, String emergencyContact) {
	//if no transportation entered assuming kid doesn't get it
	this.transportation=false;
	this.firstName = firstName;
	this.lastName = lastName;
	this.timeInPlaygroup = timeInPlaygroup;
	this.allergies = allergies;
	this.DOB = DOB;
	this.parent = parent;
	this.emergencyContact = emergencyContact;
}
public Child(String firstName, String lastName, Time timeInPlaygroup, boolean transportation, String allergies, LocalDate DOB, Parent parent, String emergencyContact) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.timeInPlaygroup = timeInPlaygroup;
	this.transportation = transportation;
	this.allergies = allergies;
	this.DOB = DOB;
	this.parent = parent;
	this.emergencyContact = emergencyContact;
	
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setTimeInPlaygroup (Time timeInPlaygroup) {
	this.timeInPlaygroup = timeInPlaygroup;
}
public void setTransportation(boolean transportation) {
	this.transportation = transportation;
}
public void setAllergies(String allergies) {
	this.allergies = allergies;
}
public void setDOB(LocalDate DOB) {
	this.DOB = DOB;
}
public void setParent (Parent parent) {
	this.parent = parent;
}
public void setEmergencyContact(String emergencyContact) {
	this.emergencyContact = emergencyContact;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
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
public String getEmergencyContact() {
	return emergencyContact;
}
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("\t Name: " + firstName + lastName);
	sb.append("\t Time In Playgroup: " + timeInPlaygroup);
	sb.append("\t Transportation: " + transportation);
	sb.append("\t Allergy Information: " + allergies);
	sb.append("\t Date of Birth: " + DOB);
	sb.append("\t Parent Information: " + parent.toString());
	sb.append("\t Emergency Contact: " + emergencyContact);
	return sb.toString();
}

//compares based on fname+lname+DOB
public boolean equals(Child c) {
	if(this.firstName.equals(c.firstName)&&this.lastName.equals(c.lastName)&&this.DOB.equals(c.DOB)) {
		return true;
	}
	else {
		return false;
	}
}
}

