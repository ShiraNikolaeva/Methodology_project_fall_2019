package NikalayevaPfeiffer;

public class Parent {
	
	private String firstName,lastName,phoneNum,address;
	
	public Parent(String fName,String lName,String phoneNum,String address){
		setFirstName(fName);
		setLastName(lName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	public Parent(String fName,String lName) {
		setFirstName(fName);
		setLastName(lName);
	}
	
	public void setFirstName(String fName) {
		this.firstName=fName;
	}
	public void setLastName(String lName) {
		this.lastName=lName;
	}
	public void setPhoneNum(String num) {
		if(validatePhoneNum(num)) {
			this.phoneNum=num;
		}
		else {
			System.out.println("Invalid phone number. Must be 10 digit");
			return;
		}
	}
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPhoneNum() {
		return this.phoneNum;
	}
	public String getAddress() {
		return this.address;
	}
	
	@Override
	public String toString() {
		return "Name: " + firstName +" "+ lastName+" Phone Number: "+ phoneNum+" Address: "+address;
	}
	public boolean isSameParent(Parent p) {
		if(p==null) {
			return false;
		}
		return (this.firstName.equalsIgnoreCase(p.firstName) && this.lastName.equalsIgnoreCase(p.lastName));
	}
	public boolean isSameParent(String fname,String lname) {
		return (this.firstName.equalsIgnoreCase(fname) && this.lastName.equalsIgnoreCase(lname) );
	}
	private boolean validatePhoneNum(String num) {
		//validate that its 10 digits
		if(num.matches("[0-9]+")&&num.length()==10) {
			return true;
		}
		return false;
	}

}
