package NikalayevaPfeiffer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		Playgroup playgroup = new Playgroup("Playgroup");
		int userOption;
			// switch statement
			userOption = menu(keyboard);
			menuSwitch(userOption,keyboard,playgroup);
	}

	public static int menu(Scanner keyboard) {
		System.out.println("Welcome. Please choose an option from the menu");
		System.out.println("1. Add Information");
		System.out.println("2. Edit Information");
		System.out.println("3. Remove");
		System.out.println("4. List all information");
		System.out.println("Exit.");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}
	public static void menuSwitch(int userOption, Scanner keyboard, Playgroup playgroup) {
		try {
			switch (userOption) {
			case 1:
				addInformation(keyboard , playgroup);
				break;
			case 2:
				editInformation(keyboard, playgroup);
				break;
			case 3:
				removeInformation(keyboard,playgroup);
				break;
			case 4:
				listInformation(keyboard, playgroup);
				break;
			default:
				System.out.println("Please enter a valid choice from the list");
				
			}
		}catch(Exception e) {
			e.getMessage();
			}
	}

	public static void addInformation(Scanner keyboard, Playgroup playgroup) throws Exception {
		int userOption;
		userOption = addInformationSubMenu(keyboard);
		switch (userOption) {
		case 1: addParentInformation(keyboard, playgroup);
			break;
		case 2: addChildInformation(keyboard, playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}

	public static int addInformationSubMenu(Scanner keyboard) {
		System.out.println("Please select what information you would like to add");
		System.out.println("1. Add parent");
		System.out.println("2. Add child");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}
	public static void addParentInformation(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the parent's first name");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the parent's last name");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the parent's contact information: ");
		String number = keyboard.nextLine();
		System.out.println("Please enter the parent's address: ");
		String address = keyboard.nextLine();
		//pass the information to the parent object/parent list
		//add the parent info to the parent object/parent list
		playgroup.addParent(fName, lName, number, address);
		
	}
	public static void addChildInformation(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the child's first name");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name");
		String lName = keyboard.nextLine();
		System.out.println("Is the child in playgroup for half the day or the full day?"
				+ "\t Please enter H for half or F for full");
		//use the enum class
		String temp = keyboard.nextLine();
		Time time;
		if(temp.equalsIgnoreCase("H")) {
			time=Time.PART_TIME;
		}
		else if(temp.equalsIgnoreCase("F")) {
			time=Time.FULL_TIME;
		}
		else {
			throw new Exception("Invalid time.");
		}
		System.out.println("Please enter any allergies the child has: ");
		String allergies = keyboard.nextLine();
		LocalDate DOB = getDOBfromUser(keyboard);
		//how to ask it
		System.out.println("Please enter the parent's first name: ");
		String PFName = keyboard.nextLine();
		System.out.println("Please enter the parent's last name: ");
		String PLName = keyboard.nextLine();
		ArrayList<Parent>p=playgroup.listParents();
		Parent tempPar=new Parent(PFName,PLName);
		Parent parent=null;
		//pull up parent;
		for(int i=0;i<p.size();i++) {
			if(p.get(i).equals(tempPar)) {
				parent=tempPar;
			}
		}
		if(parent==null) {
			throw new Exception("There's no such parent.");
		}
		System.out.println("Please enter an emergency contact: ");
		String number = keyboard.nextLine();
		
		//put all of that information into a child object
		playgroup.addChild(fName,lName,time,allergies,DOB, parent, number);
	}

	public static void editInformation(Scanner keyboard, Playgroup playgroup) throws Exception {
		int userOption;
		userOption = editInformationSubMenu(keyboard);
		switch (userOption) {
		case 1: editInfo(keyboard, playgroup);
			break;
		case 2: editChildInformation(keyboard, playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}
	
	public static int editInformationSubMenu(Scanner keyboard) {
		System.out.println("Please select what information you would like to edit");
		System.out.println("1. edit parent information");
		System.out.println("2. edit child information");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}
	
	public static void editInfo(Scanner keyboard, Playgroup playgroup) throws Exception {
		int userOption;
		userOption = editInformationSubMenuWithDetails(keyboard, playgroup);
		switch (userOption) {
		case 1: editParentFirstName(keyboard, playgroup);
			break;
		case 2: editParentLastName(keyboard, playgroup);
			break;
		case 3:editParentAddress(keyboard, playgroup);
			break;
		case 4:editParentNumber(keyboard,playgroup);
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
	public static void editParentFirstName(Scanner keyboard, Playgroup playgroup) throws Exception {
		//what information am i checking against? how am i verifying?
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited first name of the parent: ");
		String newFirstName = keyboard.nextLine();
		playgroup.editParentFirstName(fName, lName, newFirstName);
		
	}
	public static void editParentLastName(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited last name of the parent: ");
		String newLastName = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newLastName);
		
	}
	
	public static void editParentAddress(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited address of the parent: ");
		String newAddress = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newAddress);
		
	}
	
	public static void editParentNumber(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the Paren'ts frist name of which you wish to change: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the Parent's last name of which you wish to change: ");
		String lName = keyboard.nextLine();
		System.out.println("Please enter the edited phone number of the parent: ");
		String newPhoneNumber = keyboard.nextLine();
		playgroup.editParentLastName(fName, lName, newPhoneNumber);
		
	}
	
	public static void editChildInformation(Scanner keyboard, Playgroup playgroup) throws Exception {
		int userOption;
		userOption = editChildInformationSubMenu(keyboard, playgroup);
		switch (userOption) {
		case 1: editChildFirstName(keyboard, playgroup);
			break;
		case 2: editChildLastName(keyboard, playgroup);
			break;
		case 3:editTime(keyboard, playgroup);
			break;
		case 4:editTransportation(keyboard,playgroup);
			break;
		case 5:editChildAllergyInfo(keyboard, playgroup);
			break;
		case 6:editChildBirthday(keyboard, playgroup);
			break;
		case 7:editEmergencyContact(keyboard, playgroup);
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
	
	public static void editChildFirstName(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's first name: ");
		String newFirstName = keyboard.nextLine();
		playgroup.editChildFirstName(fName, lName, birthday, newFirstName);
	}
	
	public static void editChildLastName(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's first name: ");
		String newLastName = keyboard.nextLine();
		playgroup.editChildLastName(fName, lName, birthday, newLastName);
	}
	public static void editTime(Scanner keyboard, Playgroup playgroup) throws Exception {
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's time in playgroup: ");
		String temp = keyboard.nextLine();
		Time newTime;
		if(temp.equalsIgnoreCase("H")) {
			newTime=Time.PART_TIME;
		}
		else if(temp.equalsIgnoreCase("F")) {
			newTime=Time.FULL_TIME;
		}
		else {
			throw new Exception("Invalid time.");
		}
		playgroup.editTime(fName, lName, birthday, newTime);
	}
	public static void editTransportation(Scanner keyboard, Playgroup playgroup) throws Exception{
		System.out.println("Please enter the child's first name: ");
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter transportion information.");
		System.out.println("Y for yes,N for no");
		String temp = keyboard.next();
		boolean transportation;
		if(temp.equalsIgnoreCase("Y")) {
			transportation=true;
		}
		else {transportation=false;}
		playgroup.editTransportation(fName, lName, birthday, transportation);
	}
	public static void editChildAllergyInfo(Scanner keyboard, Playgroup playgroup) throws Exception {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited child's allergy information: ");
		String allergy = keyboard.nextLine();
		playgroup.editEmergencyContact(fName, lName, birthday, allergy);
	}
	public static void editChildBirthday(Scanner keyboard, Playgroup playgroup) throws Exception {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		LocalDate newbirthday = getDOBfromUser(keyboard);
		//send the information to the editDOB method
		playgroup.editDOB(fName, lName, birthday , newbirthday);
	}
	public static void editEmergencyContact(Scanner keyboard, Playgroup playgroup) throws Exception {
		String fName = keyboard.nextLine();
		System.out.println("Please enter the child's last name: ");
		String lName = keyboard.nextLine();
		LocalDate birthday = getDOBfromUser(keyboard);
		System.out.println("Please enter the edited emergency contact");
		String number = keyboard.nextLine();
		playgroup.editEmergencyContact(fName, lName, birthday, number);
	}
	public static void listInformation(Scanner keyboard, Playgroup playgroup) {
		int userOption;
		userOption = listInformationSubMenu (keyboard);
		switch (userOption) {
		case 1: listParentInfo(playgroup);
			break;
		case 2: listChildrenInfo(playgroup);
			break;
		default: 
			System.out.println("Please choose a valid option from the list");
		}
	}
	public static int listInformationSubMenu(Scanner keyboard) {
			System.out.println("Please select what information you would like to view");
			System.out.println("1. list all parent information");
			System.out.println("2. list all child information");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			return choice;
	}
	public static void removeInformation(Scanner keyboard,Playgroup playgroup)throws Exception{
		int userOption;
		userOption=removeInformationSubMenu(keyboard);
		switch(userOption) {
		case 1: removeChild(keyboard,playgroup);
			break;
		case 2: removeParent(keyboard,playgroup);
			break;
		default:
			System.out.println("Please choose a valid option from the list");
		}
	}
	public static int removeInformationSubMenu(Scanner keyboard) {
		System.out.println("Please select what information you would like to remove");
		System.out.println("1. Remove a child from the playgroup");
		System.out.println("2. Remove parent information");
		int choice=keyboard.nextInt();
		keyboard.nextLine();
		return choice;
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
	public static void removeParent(Scanner keyboard,Playgroup playgroup) {
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
	public static void listParentInfo(Playgroup playgroup) {
		//Print the parent List
		playgroup.listParents();
	}
	public static void listChildrenInfo(Playgroup playgroup) {
		//Print the child List
		playgroup.listChildren();
	}
	
	private static LocalDate getDOBfromUser(Scanner keyboard) {
		System.out.println("Please enter the child's birthday: ");
		System.out.println("Year:");
		String year = keyboard.nextLine();
		System.out.println("Month:");
		String month  = keyboard.nextLine();
		System.out.println("Day:");
		String day = keyboard.nextLine();
		LocalDate birthday = LocalDate.parse("year-month-day");
		return birthday;
	}
}