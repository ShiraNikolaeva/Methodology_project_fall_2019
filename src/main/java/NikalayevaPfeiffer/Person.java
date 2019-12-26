package NikalayevaPfeiffer;

public class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
		
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Person other = (Person) obj;
		if(!this.getFirstName().equals(other.getFirstName()) && !this.getLastName().equals(other.getLastName())) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int compareTo(Person p) {
		return this.compareTo(p);
	
	}
	public String toString() {
		return "First name: "+this.firstName+" Last name: "+this.lastName;
	}
}


