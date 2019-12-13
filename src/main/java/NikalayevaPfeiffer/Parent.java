package NikalayevaPfeiffer;

public class Parent {
	
	private String firstName,lastName,phoneNum,address;
	
	public Parent(String fName,String lName,String phoneNum,String address) throws Exception {
		setFirstName(fName);
		setLastName(lName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	public Parent(String fName,String lName) {
		setFirstName(fName);
		setLastName(lName);
	}
	
	//setters
	public void setFirstName(String fName) {
		this.firstName=fName;
	}
	public void setLastName(String lName) {
		this.lastName=lName;
	}
	public void setPhoneNum(String num) throws Exception {
		if(validatePhoneNum(num)) {
			this.phoneNum=num;
		}
		else {
			throw new Exception("Invalid phone number");
		}
	}
	public void setAddress(String address) {
		this.address=address;
	}
	
	//getters
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
		StringBuilder sb = new StringBuilder();
		sb.append("\t Name: " + firstName + lastName);
		sb.append("\t Phone Number: "+ phoneNum);
		sb.append("\t Address: "+address);
		return sb.toString();
	}
	//based on fname+lname
	public boolean equals(Parent p) {
		if(this.firstName.equals(p.firstName)&&this.lastName.equals(p.lastName)) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean validatePhoneNum(String num) {
		//validate that its 10 digits
		if(num.matches("[0-9]+")&&num.length()==10) {
			return true;
		}
		return false;
	}

}
