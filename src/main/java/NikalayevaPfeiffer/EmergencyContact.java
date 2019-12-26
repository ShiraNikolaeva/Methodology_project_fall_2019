package NikalayevaPfeiffer;

public class EmergencyContact extends Person {

	String relation;
	String phoneNumber;

	// constructor
	public EmergencyContact(String firstName, String lastName, String relation, String phoneNumber) {
		super(firstName, lastName);
		// add validation
		this.relation = relation;
		this.phoneNumber = phoneNumber;
	}

	// getters and setters
	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRelation() {
		return relation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return super.toString() + "relation " + relation + " Phone Number: " + phoneNumber;
	}

}
