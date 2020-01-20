package nikalayeva_pfeiffer;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import nikalayeva_pfeiffer.data.Child;
import nikalayeva_pfeiffer.data.EmergencyContact;
import nikalayeva_pfeiffer.data.Parent;
import nikalayeva_pfeiffer.data.Person;
import nikalayeva_pfeiffer.io.Prompter;

public class Program {
	
	private final Prompter prompter;
	private final Playgroup playgroup;
	
	public Program(Prompter prompter) {
		this.prompter = prompter;
		this.playgroup = new Playgroup();
	}

	public void run() {
		int userOption;
		while ((userOption = promptForMainMenuOption()) != 5) {
			executeMainMenuOption(userOption);
		}
		prompter.display("Exiting...");
	}

	public int promptForMainMenuOption() {
		prompter.display("Welcome, please choose an option from the menu:");
		prompter.display("1. Parent actions");
		prompter.display("2. Child actions");
		prompter.display("3. List information");
		prompter.display("4. Search");
		prompter.display("5. Exit");
		return prompter.promptForInt("Enter choice from main menu");
	}

	public void executeMainMenuOption(int userOption) {
		switch (userOption) {
		case 1:
			int parentSubMenuOption = promptForParentSubMenuOption();
			executeParentSubMenuOption(parentSubMenuOption);
			break;
		case 2:
			childSwitch();
			break;
		case 3:
			listSwitch();
			break;
		case 4:
			search();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
			break;
		}
	}

	public int promptForParentSubMenuOption() {
		prompter.display("1. Add a parent");
		prompter.display("2. Edit a parent");
		prompter.display("3. Remove a parent");
		return prompter.promptForInt("Choice from parent menu");
	}

	public void executeParentSubMenuOption(int option) {
		switch (option) {
		case 1:
			addParentInformation();
			break;
		case 2:
			int subOption = promptForEditParentInformationSubMenuOption();
			executeEditParentInformationSubMenuOption(subOption);
			break;
		case 3:
			removeParent();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
		}

	}

	public void addParentInformation() {
		String fName = prompter.prompt("Please enter the parent's first name");
		String lName = prompter.prompt("Please enter the parent's last name");
		String number = prompter.prompt("Please enter the parent's contact information (phone number): ");
		String address = prompter.prompt("Please enter the parent's address: ");
		playgroup.addParent(fName, lName, number, address);
	}

	public int promptForEditParentInformationSubMenuOption() {
		prompter.display("Please select what information you would like to edit");
		prompter.display("1. edit parent's first name");
		prompter.display("2. edit parent's last name");
		prompter.display("3. edit parent's phone number");
		prompter.display("4. edit parent's address");
		return prompter.promptForInt("choice from edit parent menu");
	}

	public void executeEditParentInformationSubMenuOption(int option) {
		switch (option) {
		case 1:
			editParentFirstName();
			break;
		case 2:
			editParentLastName();
			break;
		case 3:
			editParentAddress();
			break;
		case 4:
			editParentNumber();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
			break;
		}
	}

	public void editParentFirstName() {
		// what information am i checking against? how am i verifying?
		Parent parent = promptToLocateParent();
		if (parent != null) {
			String newValue = prompter.prompt("Please enter the edited first name of the parent: ");
			parent.setFirstName(newValue);
		}

	}

	public void editParentLastName() {
		Parent parent = promptToLocateParent();
		if (parent != null) {
			String newValue = prompter.prompt("Please enter the edited last name of the parent: ");
			parent.setLastName(newValue);
		}
	}

	public void editParentAddress() {
		Parent parent = promptToLocateParent();
		if (parent != null) {
			String newValue = prompter.prompt("Please enter the edited address of the parent: ");
			parent.setAddress(newValue);
		}
	}

	public void editParentNumber() {
		Parent parent = promptToLocateParent();
		if (parent != null) {
			String newValue = prompter.prompt("Please enter the edited phone number of the parent: ");
			if (validatePhoneNum(newValue)) {
				parent.setPhoneNum(newValue);	
			} else {
				prompter.display("Invalid phone number. Must be 10 digit");
			}
		}
	}

	public void removeParent() {
		Parent parent = promptToLocateParent();
		if (parent != null) {
			playgroup.removeParent(parent);
		}
	}

	public void childSwitch() {
		int userOption = prompter.promptForInt("Choice from child menu");
		switch (userOption) {
		case 1:
			addChildInformation();
			break;
		case 2:
			editChildInformation();
			break;
		case 3:
			removeChild();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
		}
	}

	public int childSubMenu() {
		prompter.display("1. Add a child");
		prompter.display("2. Edit a child");
		prompter.display("3. Remove a child");
		return prompter.promptForInt("choose from the child menu");
	}

	public void addChildInformation() {
		String fName = prompter.prompt("Please enter the child's first name");
		String lName = prompter.prompt("Please enter the child's last name");
		TimeInPlaygroup time = getTimeInPlaygroupFromUser();
		String allergies = prompter.prompt("Please enter any allergies the child has: ");
		LocalDate dob = getDOBfromUser();
		
		Parent parent = promptToLocateParent();
		if (parent == null) {
			prompter.display("Parent is not in the system. Please enter parent information before adding the child.");
			return;
		}
		
		EmergencyContact eContact = getEmergencyContactFromUser();

		playgroup.addChild(fName, lName, time, allergies, dob, parent, eContact);
	}

	public void editChildInformation() {
		int userOption = editChildInformationSubMenu();
		switch (userOption) {
		case 1:
			editChildFirstName();
			break;
		case 2:
			editChildLastName();
			break;
		case 3:
			editTime();
			break;
		case 4:
			editTransportation();
			break;
		case 5:
			editChildAllergyInfo();
			break;
		case 6:
			editChildBirthday();
			break;
		case 7:
			editEmergencyContact();
			break;
		case 8:
			editChildParent();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
		}
	}

	public int editChildInformationSubMenu() {
		prompter.display("Please select what information you would like to edit");
		prompter.display("1. edit child's first name");
		prompter.display("2. edit child's last name");
		prompter.display("3. edit child's time in school");
		prompter.display("4. edit child's transportation");
		prompter.display("5. edit child's allergy information");
		prompter.display("6. edit child's birthday");
		prompter.display("7. edit child's emergency contact");
		prompter.display("8. edit child's parent");
		return prompter.promptForInt("choose from the edit child menu");
	}

	public void editChildFirstName() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		String newFirstName = prompter.prompt("Please enter the edited child's first name: ");
		child.setFirstName(newFirstName);
	}

	public void editChildLastName() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		String newLastName = prompter.prompt("Please enter the edited child's last name: ");
		child.setLastName(newLastName);
	}

	public void editTime() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		prompter.display("Please enter the edited child's time in playgroup: ");
		TimeInPlaygroup newTime = getTimeInPlaygroupFromUser();
		child.setTimeInPlaygroup(newTime);
	}

	public void editTransportation() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		String temp = prompter.prompt("Please enter transportion information. Y for yes,N for no");
		boolean transportation = temp.equalsIgnoreCase("Y");
		child.setTransportation(transportation);
	}

	public void editChildAllergyInfo() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		String allergy = prompter.prompt("Please enter the edited child's allergy information: ");
		child.setAllergies(allergy);
	}

	public void editChildBirthday() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		LocalDate newbirthday = getDOBfromUser();
		child.setDOB(newbirthday);
	}

	public void editEmergencyContact() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		EmergencyContact eContact = getEmergencyContactFromUser();
		child.setEmergencyContact(eContact);
	}
	
	public void editChildParent() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		Parent parent = promptToLocateParent();
		if (parent == null) {
			prompter.display("Parent is not in the system. Please enter parent information before adding the child.");
			return;
		}
		
		child.setParent(parent);
	}

	public void removeChild() {
		Child child = promptToLocateChild();
		if (child == null) {
			return;
		}
		
		playgroup.removeChild(child);
	}

	public void listSwitch() {
		int userOption = listInformationSubMenu();
		switch (userOption) {
		case 1:
			listParentInfo();
			break;
		case 2:
			listChildrenInfo();
			break;
		case 3:
			prompter.display("Parents:");
			listParentInfo();
			prompter.display("Children:");
			listChildrenInfo();
			break;
		default:
			prompter.display("Please choose a valid option from the list");
		}
	}

	public  int listInformationSubMenu() {
		prompter.display("Please select what information you would like to view");
		prompter.display("1. list all parent information");
		prompter.display("2. list all child information");
		prompter.display("3. list all information");
		return prompter.promptForInt("Choose from the listing information menu");
	}

	public void listParentInfo() {
		// Print the parent List
		List<Parent> toPrint = playgroup.getParentList();
		for (Parent p : toPrint) {
			prompter.display(p.toString());
		}
	}

	public void listChildrenInfo() {
		List<Child> children = playgroup.getChildrenList();
		printPersons(children);
	}

	public void listAllChildrenForAParent() {
		Parent parent = promptToLocateParent();
		if (parent == null) {
			return;
			
		}

		List<Child> foundChildren= playgroup.listAllChildrenForAParent(parent);
		
		if (foundChildren.isEmpty()) {
			prompter.display("Nothing found");
			return;
		}
		
		printPersons(foundChildren);
	}

	public void search() {
		String target = prompter.prompt("Please enter what you are looking for ");
		List<Person> matchingRecords = playgroup.search(target);
		printPersons(matchingRecords);
	}
	
	private LocalDate getDOBfromUser() {
		prompter.display("Please enter the child's birthday: ");
		String year = prompter.prompt("Year:");
		String month = prompter.prompt("Month:");
		String day = prompter.prompt("Day:");
		String date = year + month + day;
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
		return LocalDate.parse(date, df);
	}

	private EmergencyContact getEmergencyContactFromUser() {
		prompter.display("Enter emergency contact information:");
		String fname = prompter.prompt("First name: ");
		String lname = prompter.prompt("Last name: ");
		String relation = prompter.prompt("Relation to the child: ");
		String num = prompter.prompt("Phone number: ");
		return new EmergencyContact(fname, lname, relation, num);
	}
	
	private TimeInPlaygroup getTimeInPlaygroupFromUser() {
		TimeInPlaygroup time=null;
		while (time == null) {
			String tempTime = prompter.prompt("Is the child in playgroup for half the day or the full day? Please enter H for half or F for full");
			if (tempTime.equalsIgnoreCase("H")) {
				time = TimeInPlaygroup.PART_TIME;
			} else if (tempTime.equalsIgnoreCase("F")) {
				time = TimeInPlaygroup.FULL_TIME;
			}
		}
		return time;
	}
	
	private Parent promptToLocateParent() {
		if (!playgroup.anyParents()) {
			prompter.display("No parents in the system.");
			return null;
		}

		String fName = prompter.prompt("Please enter the Parent's first name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		Parent parent = playgroup.findParent(fName, lName);
		
		if (parent == null) {
			prompter.display("No matching parent found on file.");
		}
		
		return parent;
	}

	private Child promptToLocateChild() {
		if (!playgroup.anyChildren()) {
			prompter.display("No children in the system.");
			return null;
		}
		
		String fName = prompter.prompt("Please enter the child's first name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the child's last name of which you wish to change: ");
		LocalDate dob = getDOBfromUser();
		Child child = playgroup.findChild(fName, lName, dob);
		
		if (child == null) {
			prompter.display("No matching child found on file.");
		}
		
		return child;
	}
	
	private void printPersons(List<? extends Person> persons) {
		for (Person p : persons) {
			prompter.display(p.toString());
		}
	}

	private boolean validatePhoneNum(String num) {
		return num.matches("[0-9]{10}");
	}

}

