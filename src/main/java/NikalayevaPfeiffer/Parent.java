package NikalayevaPfeiffer;

public class Parent extends Person {

	private String phoneNum, address;

	public Parent(String fName, String lName, String phoneNum, String address) {
		super(fName, lName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}

	public Parent(String fName, String lName) {
		super(fName, lName);
	}

	public void setFirstName(String fName) {
		super.setFirstName(fName);
	}

	public void setLastName(String lName) {
		super.setLastName(lName);
	}

	public void setPhoneNum(String num) {
		if (validatePhoneNum(num)) {
			this.phoneNum = num;
		} else {
			System.out.println("Invalid phone number. Must be 10 digit");
			return;
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return super.getFirstName();
	}

	public String getLastName() {
		return super.getLastName();
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return super.toString() + " Phone Number: " + phoneNum + " Address: " + address;
	}

	public boolean isSameParent(Parent p) {
		if (p == null) {
			return false;
		}
		return (this.getFirstName().equalsIgnoreCase(p.getFirstName())
				&& this.getLastName().equalsIgnoreCase(p.getLastName()));

	}

	public boolean isSameParent(String fname, String lname) {
		return (this.getFirstName().equalsIgnoreCase(fname) && this.getLastName().equalsIgnoreCase(lname));
	}

	private boolean validatePhoneNum(String num) {
		// validate that its 10 digits
		if (num.matches("[0-9]+") && num.length() == 10) {
			return true;
		}
		return false;
	}

}
