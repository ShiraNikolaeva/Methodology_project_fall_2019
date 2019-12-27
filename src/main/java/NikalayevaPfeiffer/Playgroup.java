package NikalayevaPfeiffer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Playgroup {
	private String playgroupName;
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Child> childrenList = new ArrayList<Child>();

	public Playgroup(String name) {
		this.playgroupName = name;
	}

	// not adding transportation because it should be asked separately from the rest
	// of the questions. it'll be updated later
	public void addChild(String fname, String lname, Time time, String allergies, LocalDate DOB, Parent parent,
			EmergencyContact eContact) {
		boolean found = false;
		Child ch = new Child(fname, lname, time, allergies, DOB, parent, eContact);
		if (!childrenList.isEmpty()) {
			for (int i = 0; i < childrenList.size(); i++) {
				if (childrenList.get(i).isSameChild(ch)) {
					found = true;
					return;
				}
			}
		}
		if (!found) {
			childrenList.add(ch);
		}
	}

	public void addParent(String fname, String lname, String num, String address) {
		Parent p = new Parent(fname, lname, num, address);
		boolean found = false;
		if (!parentList.isEmpty()) {
			for (int i = 0; i < parentList.size(); i++) {
				if (parentList.get(i).isSameParent(p)) {
					found = true;
				}
			}
		}
		if (!found) {
			parentList.add(p);
		}
	}

	public void editChildFirstName(String fname, String lname, LocalDate DOB, String newName) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setFirstName(newName);
			}
		}
	}

	public void editChildLastName(String fname, String lname, LocalDate DOB, String newName) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setLastName(newName);
			}
		}
	}

	public void editTime(String fname, String lname, LocalDate DOB, Time newTime) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setTimeInPlaygroup(newTime);
			}
		}
	}

	public void editTransportation(String fname, String lname, LocalDate DOB, boolean tr) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setTransportation(tr);
			}
		}
	}

	public void editAllergies(String fname, String lname, LocalDate DOB, String al) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setAllergies(al);
			}
		}
	}

	public void editDOB(String fname, String lname, LocalDate DOB, LocalDate newDOB) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setDOB(newDOB);
			}
		}
	}

	public void editEmergencyContact(String fname, String lname, LocalDate DOB, EmergencyContact eContact) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				childrenList.get(i).setEmergencyContact(eContact);
			}
		}
	}

	// PRECONDITION: parent must be on the system
	public void editChildParent(String fname, String lname, LocalDate DOB, Parent newParent) {
		if (childrenList.isEmpty()) {
			System.out.println("No children in the system.");
			return;
		}
		for (int i = 0; i < childrenList.size(); i++) {
			if (childrenList.get(i).isSameChild(fname, lname, DOB)) {
				// look for parent in parentList
				for (int j = 0; j < parentList.size(); j++) {
					if (parentList.get(j).isSameParent(newParent)) {
						childrenList.get(i).setParent(newParent);
					}
				}
			}
		}
	}

	public void editParentFirstName(String fname, String lname, String newName) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parentList.get(i).setFirstName(newName);
			}
		}
	}

	public void editParentLastName(String fname, String lname, String newName) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parentList.get(i).setLastName(newName);
			}
		}
	}

	public void editParentPhoneNum(String fname, String lname, String newNum) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parentList.get(i).setPhoneNum(newNum);
			}
		}
	}

	public void editParentAddress(String fname, String lname, String newAddress) {
		if (parentList.isEmpty()) {
			System.out.println("No parents in the system.");
			return;
		}
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parentList.get(i).setAddress(newAddress);
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
		Parent parentToRemove = null;
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parentToRemove = parentList.get(i);
			}
		}
		if (parentToRemove != null) {
			parentList.remove(parentToRemove);
		}
	}

	public ArrayList<Child> listAllChildrenForAParent(String fname, String lname) {
		Parent parent = null;
		boolean found = false;
		if (parentList.isEmpty()) {
			System.out.println("There are no parents in the system.");
			return null;
		}
		if (childrenList.isEmpty()) {
			System.out.println("There are no children in the system.");
			return null;
		}
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).isSameParent(fname, lname)) {
				parent = parentList.get(i);
				found = true;
			}
		}
		if (!found) {
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

	public ArrayList<Parent> getParentList() {
		if (parentList.isEmpty()) {
			return null;
		}
		ArrayList<Parent> copy = new ArrayList<>();
		for (Parent p : parentList) {
			copy.add(p);
		}
		return copy;
	}

	public ArrayList<Child> getChildrenList() {
		if (childrenList.isEmpty()) {
			return null;
		}
		ArrayList<Child> copy = new ArrayList<>();
		for (Child c : childrenList) {
			copy.add(c);
		}
		return copy;
	}

	public ArrayList<Person> search(String target) {
		ArrayList<Person> mixedList = new ArrayList<>();
		ArrayList<Person> listToReturn = new ArrayList<>();
		if (parentList.isEmpty() && childrenList.isEmpty()) {
			return listToReturn;
		}

		if (!parentList.isEmpty()) {
			mixedList.addAll(parentList);
		}
		if (!childrenList.isEmpty()) {
			mixedList.addAll(childrenList);
		}
		for (Person p : mixedList) {
			if (p.toString().toLowerCase().contains(target.toLowerCase())) {
				listToReturn.add(p);
			}
		}
		return listToReturn;
	}

}
