package NikalayevaPfeiffer;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	private final Prompter prompter;
	private final Playgroup playgroup;
	
	public Program(Prompter p) {
		this.prompter=p;
		this.playgroup = new Playgroup();
	}

	public static void main(String[] args) {
		Prompter prompter=new PrompterImpl();
		Program program=new Program(prompter);
	}
	
	public void run() {
		int userOption = -1;
		while (userOption != 5) {
			userOption = menu();
			menuForMenus(userOption);
		}
	}

	public int menu() {
		System.out.println("Welcome, please choose an option from the menu:");
		System.out.println("1. Parent actions");
		System.out.println("2. Child actions");
		System.out.println("3. List information");
		System.out.println("4. Search");
		System.out.println("5. Exit");
		int choice = prompter.promptForInt("Enter choice from main menu");
		return choice;
	}

	public  void menuForMenus(int userOption) {
		switch (userOption) {
		case 1:
			parentSwitch();
			break;
		case 2:
			ChildSwitch();
			break;
		case 3:
			listSwitch();
			break;
		case 4:
			search();
			break;
		case 5:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public void parentSwitch() {
		int userOption= parentSubMenu();
		switch (userOption) {
		case 1:
			addParentInformation();
			break;
		case 2:
			editInfo();
			break;
		case 3:
			removeParent();
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}

	}

	public int parentSubMenu() {
		System.out.println("1. Add a parent");
		System.out.println("2. Edit a parent");
		System.out.println("3. Remove a parent");
		int choice = prompter.promptForInt("Choice from parent menu");
		return choice;
	}

	public void addParentInformation() {
		String fName = prompter.prompt("Please enter the parent's first name");
		String lName = prompter.prompt("Please enter the parent's last name");
		String number = prompter.prompt("Please enter the parent's contact information (phone number): ");
		String address = prompter.prompt("Please enter the parent's address: ");
		// pass the information to the parent object/parent list
		// add the parent info to the parent object/parent list
		playgroup.addParent(fName, lName, number, address);

	}

	public void editInfo() {
		int userOption;
		userOption = editInformationSubMenuWithDetails();
		switch (userOption) {
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
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public int editInformationSubMenuWithDetails() {
		System.out.println("Please select what information you would like to edit");
		System.out.println("1. edit parent's first name");
		System.out.println("2. edit parent's last name");
		System.out.println("3. edit parent's phone number");
		System.out.println("4. edit parent's address");
		int choice = prompter.promptForInt("choice from edit parent menu");
		return choice;
	}

	public void editParentFirstName() {
		// what information am i checking against? how am i verifying?
		String fName = prompter.prompt("Please enter the Paren'ts frist name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		String newFirstName = prompter.prompt("Please enter the edited first name of the parent: ");
		playgroup.editParentFirstName(fName, lName, newFirstName);

	}

	public void editParentLastName() {
		String fName = prompter.prompt("Please enter the Paren'ts frist name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		String newLastName = prompter.prompt("Please enter the edited last name of the parent: ");
		playgroup.editParentLastName(fName, lName, newLastName);

	}

	public void editParentAddress() {
		String fName = prompter.prompt("Please enter the Paren'ts frist name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		String newAddress = prompter.prompt("Please enter the edited address of the parent: ");
		playgroup.editParentLastName(fName, lName, newAddress);

	}

	public void editParentNumber() {
		String fName = prompter.prompt("Please enter the Paren'ts frist name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		String newPhoneNumber = prompter.prompt("Please enter the edited phone number of the parent: ");
		playgroup.editParentLastName(fName, lName, newPhoneNumber);

	}

	public void removeParent() {
		String fName = prompter.prompt("Please enter the Paren'ts frist name of which you wish to change: ");
		String lName = prompter.prompt("Please enter the Parent's last name of which you wish to change: ");
		playgroup.removeParent(fName, lName);
	}

	public void ChildSwitch() {
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
			System.out.println("Please choose a valid option from the list");
		}
	}

	public int childSubMenu() {
		System.out.println("1. Add a child");
		System.out.println("2. Edit a child");
		System.out.println("3. Remove a child");
		int choice = prompter.promptForInt("choose from the child menu");
		return choice;
	}

	public void addChildInformation() {
		String fName = prompter.prompt("Please enter the child's first name");
		String lName = prompter.prompt("Please enter the child's last name");
		TimeInPlaygroup time = getTimeInPlaygroupFromUser();
		String allergies = prompter.prompt("Please enter any allergies the child has: ");
		LocalDate DOB = getDOBfromUser();
		String PFName = prompter.prompt("Please enter the parent's first name: ");
		String PLName = prompter.prompt("Please enter the parent's last name: ");
		ArrayList<Parent> p = (ArrayList<Parent>) playgroup.getParentList();
		Parent tempPar = new Parent(PFName, PLName);
		Parent parent = null;
		// pull up parent;
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).isSameParent(tempPar)) {
				parent = tempPar;
			}
		}
		if (parent == null) {
			System.out.println("Parent is not in the system. Please enter parent information before adding the child.");
			return;
		}
		EmergencyContact eContact = getEmergencyContactFromUser();

		// put all of that information into a child object
		playgroup.addChild(fName, lName, time, allergies, DOB, parent, eContact);
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
			System.out.println("Please choose a valid option from the list");
		}
	}

	public int editChildInformationSubMenu() {
		System.out.println("Please select what information you would like to edit");
		System.out.println("1. edit child's first name");
		System.out.println("2. edit child's last name");
		System.out.println("3. edit child's time in school");
		System.out.println("4. edit child's transportation");
		System.out.println("5. edit child's allergy information");
		System.out.println("6. edit child's birthday");
		System.out.println("7. edit child's emergency contact");
		System.out.println("8. edit child's parent");
		int choice = prompter.promptForInt("choose from the edit child menu");
		return choice;
	}

	public void editChildFirstName() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		String newFirstName = prompter.prompt("Please enter the edited child's first name: ");
		playgroup.editChildFirstName(fName, lName, birthday, newFirstName);
	}

	public void editChildLastName() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		String newLastName = prompter.prompt("Please enter the edited child's first name: ");
		playgroup.editChildLastName(fName, lName, birthday, newLastName);
	}

	public void editTime() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		System.out.println("Please enter the edited child's time in playgroup: ");
		TimeInPlaygroup newTime = getTimeInPlaygroupFromUser();
		playgroup.editTime(fName, lName, birthday, newTime);
	}

	public void editTransportation() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		String temp = prompter.prompt("Please enter transportion information. Y for yes,N for no");
		boolean transportation;
		if (temp.equalsIgnoreCase("Y")) {
			transportation = true;
		} else {
			transportation = false;
		}
		playgroup.editTransportation(fName, lName, birthday, transportation);
	}

	public void editChildAllergyInfo() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		String allergy = prompter.prompt("Please enter the edited child's allergy information: ");
		playgroup.editAllergies(fName, lName, birthday, allergy);
	}

	public void editChildBirthday() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		LocalDate newbirthday = getDOBfromUser();
		// send the information to the editDOB method
		playgroup.editDOB(fName, lName, birthday, newbirthday);
	}

	public void editEmergencyContact() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		EmergencyContact eContact = getEmergencyContactFromUser();
		playgroup.editEmergencyContact(fName, lName, birthday, eContact);
	}
	public void editChildParent() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate DOB = getDOBfromUser();
		String PFName = prompter.prompt("Please enter the parent's first name: ");
		String PLName = prompter.prompt("Please enter the parent's last name: ");
		ArrayList<Parent> p = (ArrayList<Parent>) playgroup.getParentList();
		Parent tempPar = new Parent(PFName, PLName);
		Parent newParent = null;
		// pull up parent;
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).isSameParent(tempPar)) {
				newParent = tempPar;
			}
		}
		if (newParent == null) {
			System.out.println("Parent is not in the system. Please enter parent information before adding the child.");
			return;
		}
		playgroup.editChildParent(fName, lName, DOB, newParent);
	}

	public void removeChild() {
		String fName = prompter.prompt("Please enter the child's first name: ");
		String lName = prompter.prompt("Please enter the child's last name: ");
		LocalDate birthday = getDOBfromUser();
		playgroup.removeChild(fName, lName, birthday);
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
			System.out.println("Parents:");
			listParentInfo();
			System.out.println("Children:");
			listChildrenInfo();
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public  int listInformationSubMenu() {
		System.out.println("Please select what information you would like to view");
		System.out.println("1. list all parent information");
		System.out.println("2. list all child information");
		System.out.println("3. list all information");
		int choice = prompter.promptForInt("Choose from the listing information menu");
		return choice;
	}

	public void listParentInfo() {
		// Print the parent List
		ArrayList<Parent> toPrint = (ArrayList<Parent>) playgroup.getParentList();
		for (Parent p : toPrint) {
			System.out.println(p.toString());
		}
	}

	public void listChildrenInfo() {
		// Print the child List
		ArrayList<Child> toPrint = (ArrayList<Child>) playgroup.getChildrenList();
		for (Child c : toPrint) {
			System.out.println(c.toString());
		}
	}

	public void listAllChildrenForAParent() {
		String fName = prompter.prompt("Please enter the Paren'ts frist name: ");
		String lName = prompter.prompt("Please enter the Parent's last name: ");
		ArrayList<Child>foundChildren=(ArrayList<Child>) playgroup.listAllChildrenForAParent(fName, lName);
		if(foundChildren==null) {
			System.out.println("Nothing found");
			return;
		}
		for(Child c:foundChildren) {
			System.out.println(c.toString());
		}
	}

	public void search() {
		String target = prompter.prompt("Please enter what you are looking for ");
		ArrayList<Person> matchingRecords = new ArrayList<>();

			matchingRecords = (ArrayList<Person>) playgroup.search(target);

		for (Person p : matchingRecords) {
			System.out.println(p.toString());
		}
	}

	private LocalDate getDOBfromUser() {
		System.out.println("Please enter the child's birthday: ");
		String year = prompter.prompt("Year:");
		String month = prompter.prompt("Month:");
		String day = prompter.prompt("Day:");
		String date = year + month + day;
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
		LocalDate birthday = LocalDate.parse(date, df);
		return birthday;
	}

	private EmergencyContact getEmergencyContactFromUser() {
		System.out.println("Enter emergency contact information:");
		String fname = prompter.prompt("First name: ");
		String lname = prompter.prompt("Last name: ");
		String relation = prompter.prompt("Relation to the child: ");
		String num = prompter.prompt("Phone number: ");
		return new EmergencyContact(fname, lname, relation, num);
	}
	private TimeInPlaygroup getTimeInPlaygroupFromUser() {
		TimeInPlaygroup time=null;
		boolean done = false;
		while (!done) {
			String tempTime = prompter.prompt("Is the child in playgroup for half the day or the full day? Please enter H for half or F for full");
			if (tempTime.equalsIgnoreCase("H")) {
				time = TimeInPlaygroup.PART_TIME;
				done = true;
			} else if (tempTime.equalsIgnoreCase("F")) {
				time = TimeInPlaygroup.FULL_TIME;
				done = true;
			}
		}
		return time;
	}
}

