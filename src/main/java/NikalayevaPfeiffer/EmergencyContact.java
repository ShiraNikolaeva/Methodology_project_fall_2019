package NikalayevaPfeiffer;

public class EmergencyContact extends Person {

	private String relation;
	private String phoneNumber;


	public EmergencyContact(String firstName, String lastName, String relation, String phoneNumber) {
		super(firstName, lastName);
		if(validatePhoneNum(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}
		// add validation
		this.relation = relation;
		
	}

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
	private boolean validatePhoneNum(String num) {
		// validate that its 10 digits
		if (num.matches("[0-9]+") && num.length() == 10) {
			return true;
		}
		return false;
	}

}
