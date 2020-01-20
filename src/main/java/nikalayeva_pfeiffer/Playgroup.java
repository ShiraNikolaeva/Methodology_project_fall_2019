package nikalayeva_pfeiffer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import nikalayeva_pfeiffer.data.Child;
import nikalayeva_pfeiffer.data.EmergencyContact;
import nikalayeva_pfeiffer.data.Parent;
import nikalayeva_pfeiffer.data.Person;

public class Playgroup {
	private List<Parent> parentList = new ArrayList<>();
	private List<Child> childrenList = new ArrayList<>();

	public void addChild(String fname, String lname, TimeInPlaygroup time, String allergies, LocalDate dob,
			Parent parent, EmergencyContact eContact) {
		Child existingChild = findChild(fname, lname, dob);
		if (existingChild == null && validateDOB(dob)) {
			Child ch = new Child(fname, lname, time, allergies, dob, parent, eContact);
			childrenList.add(ch);
		}
	}

	public void addParent(String fname, String lname, String num, String address) {
		Parent existingParent = findParent(fname, lname);
		if (existingParent == null) {
			Parent p = new Parent(fname, lname, num, address);
			parentList.add(p);
		}
	}

	public void removeChild(Child child) {
		childrenList.remove(child);
	}

	public void removeParent(Parent parent) {
		parentList.remove(parent);
	}

	public List<Child> listAllChildrenForAParent(Parent parent) {
		List<Child> foundChildren = new ArrayList<>();
		for (Child c : childrenList) {
			if (c.getParent() == parent) {
				foundChildren.add(c);
			}
		}
		return foundChildren;
	}

	public List<Parent> getParentList() {
		return new ArrayList<>(parentList);
	}

	public List<Child> getChildrenList() {
		return new ArrayList<>(childrenList);
	}

	public List<Person> search(String target) {
		ArrayList<Person> mixedList = new ArrayList<>();
		mixedList.addAll(parentList);
		mixedList.addAll(childrenList);
		
		ArrayList<Person> listToReturn = new ArrayList<>();
		for (Person p : mixedList) {
			if (p.toString().toLowerCase().contains(target.toLowerCase())) {
				listToReturn.add(p);
			}
		}
		return listToReturn;
	}

	public Parent findParent(String fname, String lname) {
		for (Parent parent : parentList) {
			if (parent.getFirstName().equalsIgnoreCase(fname)
					&& parent.getLastName().equalsIgnoreCase(lname)) {
				return parent;
			}
		}
		return null;
	}
	
	public Child findChild(String fname, String lname, LocalDate dob) {
		for (Child child : childrenList) {
			if (child.getFirstName().equalsIgnoreCase(fname)
					&& child.getLastName().equalsIgnoreCase(lname) 
					&& child.getDOB().equals(dob)) {
				return child;
			}
		}
		return null;
	}

	private boolean validateDOB(LocalDate dob) {
		// ages 1-5 are allowed to be in the playgroup. using days to ensure correct age
		LocalDate today = LocalDate.now();
		LocalDate from = today.minusDays(1825);
		LocalDate to = today.minusDays(365);
		return !dob.isBefore(from) && !dob.isAfter(to);
	}
	
	public boolean anyParents() {
		return !parentList.isEmpty();
	}

	public boolean anyChildren() {
		return !childrenList.isEmpty();
	}
	

}
