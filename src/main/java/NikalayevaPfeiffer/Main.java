package NikalayevaPfeiffer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Playgroup playgroup = new Playgroup("Playgroup");

		GUI gui =new GUI();
		int userOption = -1;
		while (userOption != 5) {
			userOption = menu(keyboard);
			menuForMenus(userOption, keyboard, playgroup);
		}
	}

	public static int menu(Scanner keyboard) {
		System.out.println("Welcome, please choose an option from the menu:");
		System.out.println("1. Parent actions");
		System.out.println("2. Child actions");
		System.out.println("3. List information");
		System.out.println("4. Search");
		System.out.println("5. Exit");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void menuForMenus(int userOption, Scanner keyboard, Playgroup playgroup) {
		switch (userOption) {
		case 1:
			parentSwitch(keyboard, playgroup);
			break;
		case 2:
			ChildSwitch(keyboard, playgroup);
			break;
		case 3:
			listSwitch(keyboard, playgroup);
			break;
		case 4:
			search(keyboard, playgroup);
			break;
		case 5:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static void parentSwitch(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = parentSubMenu(keyboard);
		switch (userOption) {
		case 1:
			addParentInformation(keyboard, playgroup);
			break;
		case 2:
			editInfo(keyboard, playgroup);
			break;
		case 3:
			removeParent(keyboard, playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}

	}

	public static int parentSubMenu(Scanner keyboard) {
		System.out.println("1. Add a parent");
		System.out.println("2. Edit a parent");
		System.out.println("3. Remove a parent");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void addParentInformation(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the parent's first name");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the parent's last name");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the parent's contact information (phone number): ");
		String number = keyboard.nextLine();
		System.out.println("Please enter the parent's address: ");
		String address = keyboard.nextLine();
		// pass the information to the parent object/parent list
		// add the parent info to the parent object/parent list
		playgroup.addParent(fName, lName, number, address);

	}

	public static void editInfo(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = editInformationSubMenuWithDetails(keyboard, playgroup);
		switch (userOption) {
		case 1:
			editParentFirstName(keyboard, playgroup);
			break;
		case 2:
			editParentLastName(keyboard, playgroup);
			break;
		case 3:
			editParentAddress(keyboard, playgroup);
			break;
		case 4:
			editParentNumber(keyboard, playgroup);
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static int editInformationSubMenuWithDetails(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please select what information you would like to edit");
		System.out.println("1. edit parent's first name");
		System.out.println("2. edit parent's last name");
		System.out.println("3. edit parent's phone number");
		System.out.println("4. edit parent's address");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void editParentFirstName(Scanner keyboard, Playgroup playgroup) {
		// what information am i checking against? how am i verifying?
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited first name of the parent: ");
		String newFirstName = keyboard.nextLine();
		playgroup.editParentFirstName(fName, lName, newFirstName);

	}

	public static void editParentLastName(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited last name of the parent: ");
		String newLastName = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newLastName);

	}

	public static void editParentAddress(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited address of the parent: ");
		String newAddress = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newAddress);

	}

	public static void editParentNumber(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited phone number of the parent: ");
		String newPhoneNumber = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newPhoneNumber);

	}

	public static void removeParent(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		try {
			playgroup.removeParent(fName, lName);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void ChildSwitch(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = childSubMenu(keyboard);
		switch (userOption) {
		case 1:
			addChildInformation(keyboard, playgroup);
			break;
		case 2:
			editChildInformation(keyboard, playgroup);
			break;
		case 3:
			removeChild(keyboard, playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static int childSubMenu(Scanner keyboard) {
		System.out.println("1. Add a child");
		System.out.println("2. Edit a child");
		System.out.println("3. Remove a child");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void addChildInformation(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name");
		String lName = keyboard.nextLine();
		Time time = null;
		boolean done = false;
		while (!done) {
			System.out.println("Is the child in playgroup for half the day or the full day?"
					+ "\t Please enter H for half or F for full");
			String temp = keyboard.nextLine();
			if (temp.equalsIgnoreCase("H")) {
				time = Time.PART_TIME;
				done = true;
			} else if (temp.equalsIgnoreCase("F")) {
				time = Time.FULL_TIME;
				done = true;
			}
		}
		System.out.println("Please enter any allergies the child has: ");
		String allergies = keyboard.nextLine();
		LocalDate DOB = getDOBfromUser(keyboard);
		System.out.println("Please enter the parent's first name: ");
		String PFName = keyboard.nextLine();
		System.out.println("Please enter the parent's last name: ");
		String PLName = keyboard.nextLine();
		ArrayList<Parent> p = playgroup.getParentList();
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
		EmergencyContact eContact = getEmergencyContactFromUser(keyboard);

		// put all of that information into a child object
		playgroup.addChild(fName, lName, time, allergies, DOB, parent, eContact);
	}

	public static void editChildInformation(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = editChildInformationSubMenu(keyboard, playgroup);
		switch (userOption) {
		case 1:
			editChildFirstName(keyboard, playgroup);
			break;
		case 2:
			editChildLastName(keyboard, playgroup);
			break;
		case 3:
			editTime(keyboard, playgroup);
			break;
		case 4:
			editTransportation(keyboard, playgroup);
			break;
		case 5:
			editChildAllergyInfo(keyboard, playgroup);
			break;
		case 6:
			editChildBirthday(keyboard, playgroup);
			break;
		case 7:
			editEmergencyContact(keyboard, playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static int editChildInformationSubMenu(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please select what information you would like to edit");
		System.out.println("1. edit child's first name");
		System.out.println("2. edit child's last name");
		System.out.println("3. edit child's time in school");
		System.out.println("4. edit child's transportation");
		System.out.println("5. edit child's allergy information");
		System.out.println("6. edit child's birthday");
		System.out.println("7. edit child's emergency contact");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void editChildFirstName(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's first name: ");
		String newFirstName = keyboard.nextLine();
		playgroup.editChildFirstName(fName, lName, birthday, newFirstName);
	}

	public static void editChildLastName(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's first name: ");
		String newLastName = keyboard.nextLine();
		playgroup.editChildLastName(fName, lName, birthday, newLastName);
	}

	public static void editTime(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's time in playgroup: ");
		Time newTime = null;
		boolean done = false;
		while (!done) {
			System.out.println("Is the child in playgroup for half the day or the full day?"
					+ "\t Please enter H for half or F for full");
			String tempTime = keyboard.nextLine();
			if (tempTime.equalsIgnoreCase("H")) {
				newTime = Time.PART_TIME;
				done = true;
			} else if (tempTime.equalsIgnoreCase("F")) {
				newTime = Time.FULL_TIME;
				done = true;
			}
		}
		playgroup.editTime(fName, lName, birthday, newTime);
	}

	public static void editTransportation(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter transportion information.");
		System.out.println("Y for yes,N for no");
		String temp = keyboard.next();
		boolean transportation;
		if (temp.equalsIgnoreCase("Y")) {
			transportation = true;
		} else {
			transportation = false;
		}
		playgroup.editTransportation(fName, lName, birthday, transportation);
	}

	public static void editChildAllergyInfo(Scanner keyboard, Playgroup playgroup) {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's allergy information: ");
		String allergy = keyboard.nextLine();
		playgroup.editAllergies(fName, lName, birthday, allergy);
	}

	public static void editChildBirthday(Scanner keyboard, Playgroup playgroup) {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		LocalDate newbirthday = getDOBfromUser(keyboard);
		// send the information to the editDOB method
		playgroup.editDOB(fName, lName, birthday, newbirthday);
	}

	public static void editEmergencyContact(Scanner keyboard, Playgroup playgroup) {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		EmergencyContact eContact = getEmergencyContactFromUser(keyboard);
		playgroup.editEmergencyContact(fName, lName, birthday, eContact);
	}

	public static void removeChild(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		try {
			playgroup.removeChild(fName, lName, birthday);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void listSwitch(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = listInformationSubMenu(keyboard);
		switch (userOption) {
		case 1:
			listParentInfo(playgroup);
			break;
		case 2:
			listChildrenInfo(playgroup);
			break;
		case 3:
			System.out.println("Parents:");
			listParentInfo(playgroup);
			System.out.println("Children:");
			listChildrenInfo(playgroup);
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static int listInformationSubMenu(Scanner keyboard) {
		System.out.println("Please select what information you would like to view");
		System.out.println("1. list all parent information");
		System.out.println("2. list all child information");
		System.out.println("3. list all information");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}

	public static void listParentInfo(Playgroup playgroup) {
		// Print the parent List
		ArrayList<Parent> toPrint = playgroup.getParentList();
		for (Parent p : toPrint) {
			System.out.println(p.toString());
		}
	}

	public static void listChildrenInfo(Playgroup playgroup) {
		// Print the child List
		ArrayList<Child> toPrint = playgroup.getChildrenList();
		for (Child c : toPrint) {
			System.out.println(c.toString());
		}
	}

	public static void listAllChildrenForAParent(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter the Paren'ts frist name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name: ");
		String lName = keyboard.nextLine();
		playgroup.listAllChildrenForAParent(fName, lName);
	}

	public static void search(Scanner keyboard, Playgroup playgroup) {
		System.out.println("Please enter what you are looking for ");
		String target = keyboard.nextLine();
		ArrayList<Person> matchingRecords = new ArrayList<>();
		try {
			matchingRecords = playgroup.search(target);
		} catch (RecordNotFoundException e) {
			System.out.println("No records found");
		}
		for (Person p : matchingRecords) {
			System.out.println(p.toString());
		}
	}

	private static LocalDate getDOBfromUser(Scanner keyboard) {
		System.out.println("Please enter the child's birthday: ");
		System.out.println("Year:");
		String year = keyboard.nextLine();
		System.out.println("Month:");
		String month = keyboard.nextLine();
		System.out.println("Day:");
		String day = keyboard.nextLine();
		String date = year + month + day;
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
		LocalDate birthday = LocalDate.parse(date, df);
		return birthday;
	}

	private static EmergencyContact getEmergencyContactFromUser(Scanner keyboard) {
		System.out.println("Enter emergency contact information:");
		System.out.println("First name: ");
		String fname = keyboard.next();
		System.out.println("Last name: ");
		String lname = keyboard.next();
		System.out.println("Relation to the child: ");
		String relation = keyboard.next();
		System.out.println("Phone number: ");
		String num = keyboard.next();
		return (new EmergencyContact(fname, lname, relation, num));
	}
}
