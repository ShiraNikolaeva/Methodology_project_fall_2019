package NikalayevaPfeiffer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Playgroup {
	private List<Parent> parentList = new ArrayList<>();
	private List<Child> childrenList = new ArrayList<>();

	public Playgroup() {
	}

	public void addChild(String fname, String lname, TimeInPlaygroup time, String allergies, LocalDate DOB, Parent parent,
			EmergencyContact eContact) {
		Child ch = new Child(fname, lname, time, allergies, DOB, parent, eContact);
		if (validateDOB(DOB)) {
			Child temp = findChild(ch);
			if (temp == null) {
				childrenList.add(ch);
			}
		}
	}

	public void addParent(String fname, String lname, String num, String address) {
		Parent p = new Parent(fname, lname, num, address);
		if (!parentList.isEmpty()) {
			Parent temp = findParent(p);
			if (temp == null) {
				parentList.add(p);
			}
		}
	}

	public void editChildFirstName(String fname, String lname, LocalDate DOB, String newName) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setFirstName(newName);

		}
	}

	public void editChildLastName(String fname, String lname, LocalDate DOB, String newName) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setLastName(newName);

		}
	}

	public void editTime(String fname, String lname, LocalDate DOB, TimeInPlaygroup newTime) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setTimeInPlaygroup(newTime);

		}
	}

	public void editTransportation(String fname, String lname, LocalDate DOB, boolean tr) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setTransportation(tr);

		}
	}

	public void editAllergies(String fname, String lname, LocalDate DOB, String al) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setAllergies(al);

		}
	}

	public void editDOB(String fname, String lname, LocalDate DOB, LocalDate newDOB) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {
			if (validateDOB(newDOB)) {
				temp.setDOB(newDOB);
			}
		}
	}

	public void editEmergencyContact(String fname, String lname, LocalDate DOB, EmergencyContact eContact) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			temp.setEmergencyContact(eContact);

		}
	}

	// PRECONDITION: parent must be on the system
	public void editChildParent(String fname, String lname, LocalDate DOB, Parent newParent) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child child = new Child(fname, lname, DOB);
		Child temp = findChild(child);
		if (temp != null) {

			Parent found = findParent(newParent);
			if (found != null) {
				temp.setParent(newParent);
			}

		}

	}

	public void editParentFirstName(String fname, String lname, String newName) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		Parent p = new Parent(fname, lname);
		if (!parentList.isEmpty()) {
			Parent temp = findParent(p);
			if (temp != null) {
				temp.setFirstName(newName);
			}
		}
	}

	public void editParentLastName(String fname, String lname, String newName) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		Parent p = new Parent(fname, lname);
		if (!parentList.isEmpty()) {
			Parent temp = findParent(p);
			if (temp != null) {
				temp.setLastName(newName);
			}
		}
	}

	public void editParentPhoneNum(String fname, String lname, String newNum) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		Parent p = new Parent(fname, lname);
		if (!parentList.isEmpty()) {
			Parent temp = findParent(p);
			if (temp != null) {
				temp.setPhoneNum(newNum);
			}
		}
	}

	public void editParentAddress(String fname, String lname, String newAddress) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		Parent p = new Parent(fname, lname);
		if (!parentList.isEmpty()) {
			Parent temp = findParent(p);
			if (temp != null) {
				temp.setAddress(newAddress);
			}
		}
	}

	public void removeChild(String fname, String lname, LocalDate DOB) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		Child childToRemove = null;
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childToRemove = childrenList.get(i);
			}
		}
		if (childToRemove != null) {
			childrenList.remove(childToRemove);
		}
	}

	public void removeParent(String fname, String lname) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		Parent parentToRemove = findParent(new Parent(fname, lname));
		if (parentToRemove != null) {
			parentList.remove(parentToRemove);
		}
	}

	public List<Child> listAllChildrenForAParent(String fname, String lname) {
		Parent parent = null;
		if (parentList.isEmpty()) {
			System.out.println("There are no parents in the system.");
			return null;
		}
		if (childrenList.isEmpty()) {
			System.out.println("There are no children in the system.");
			return null;
		}
		parent = findParent(new Parent(fname, lname));

		if (parent == null) {
			System.out.println("Parent is not found");
			return null;
		}
		ArrayList<Child> foundChildren = new ArrayList<>();
		for (Child c : childrenList) {
			if (c.getParent().isSameParent(parent)) {
				foundChildren.add(c);
			}
		}
		return foundChildren;
	}

	public List<Parent> getParentList() {
		if (parentList.isEmpty()) {
			return null;
		}
		ArrayList<Parent> copy = new ArrayList<>();
		for (Parent p : parentList) {
			copy.add(p);
		}
		return copy;
	}

	public List<Child> getChildrenList() {
		if (childrenList.isEmpty()) {
			return null;
		}
		ArrayList<Child> copy = new ArrayList<>();
		for (Child c : childrenList) {
			copy.add(c);
		}
		return copy;
	}

	public List<Person> search(String target) {
		ArrayList<Person> mixedList = new ArrayList<>();
		ArrayList<Person> listToReturn = new ArrayList<>();
		mixedList.addAll(parentList);
		mixedList.addAll(childrenList);
		for (Person p : mixedList) {
			if (p.toString().toLowerCase().contains(target.toLowerCase())) {
				listToReturn.add(p);
			}
		}
		return listToReturn;
	}

	private Parent findParent(Parent parent) {
		if (!parentList.isEmpty()) {
			for (int i = 0; i < parentList.size(); i++) {
				if (parentList.get(i).isSameParent(parent)) {
					return parentList.get(i);
				}
			}
		}
		return null;
	}

	private Child findChild(Child child) {
			for (int i = 0; i < childrenList.size(); i++) {
				if (childrenList.get(i).isSameChild(child)) {
					return childrenList.get(i);
				}
			}
		return null;
	}

	public boolean validateDOB(LocalDate dob) {
		// ages 1-5 are allowed to be in the playgroup. using days to ensure correct age
		LocalDate today = LocalDate.now();
		LocalDate from = today.minusDays(1825);
		LocalDate to = today.minusDays(365);
		if (!dob.isBefore(from) && !dob.isAfter(to)) {
			return true;
		}
		return false;
	}
}
