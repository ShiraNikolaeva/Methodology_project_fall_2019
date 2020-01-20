package nikalayeva_pfeiffer.data;

public class Parent extends Person {

	private String phoneNum;
	private String address;

	public Parent(String fName, String lName, String phoneNum, String address) {
		super(fName, lName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}

	public Parent(String fName, String lName) {
		super(fName, lName);
	}

	public void setPhoneNum(String num) {
		this.phoneNum = num;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
