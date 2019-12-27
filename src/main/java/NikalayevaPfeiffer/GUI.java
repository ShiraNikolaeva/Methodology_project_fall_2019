package NikalayevaPfeiffer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

	Playgroup playgroup;

	public GUI(Playgroup playgroup) {
		this.playgroup = playgroup;
		initGui();
	}

	private void initGui() {
		JFrame frame = new JFrame("Playgroup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		JMenuBar menuBar = new JMenuBar();
		JMenu parentActions = new JMenu("Parent");
		JMenu childActions = new JMenu("Child");
		JMenu listActions = new JMenu("List contents");
		JMenuItem search = new JMenu("Search");
		search.addActionListener(this);
		search.setActionCommand("Search");
		menuBar.add(parentActions);
		menuBar.add(childActions);
		menuBar.add(listActions);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(search);

		JMenuItem addParent = new JMenuItem("Add");
		addParent.addActionListener(this);
		addParent.setActionCommand("Add parent");
		JMenu editParent = new JMenu("Edit");
		JMenuItem editParentFirstName = new JMenuItem("First name");
		editParentFirstName.addActionListener(this);
		editParentFirstName.setActionCommand("Edit parent first name");
		JMenuItem editParentLastName = new JMenuItem("Last name");
		editParentLastName.addActionListener(this);
		editParentLastName.setActionCommand("Edit parent last name");
		JMenuItem editParentPhoneNumber = new JMenuItem("Phone number");
		editParentPhoneNumber.addActionListener(this);
		editParentPhoneNumber.setActionCommand("Edit parent phone number");
		JMenuItem editParentAddress = new JMenuItem("Address");
		editParentAddress.addActionListener(this);
		editParentAddress.setActionCommand("Edit parent address");

		editParent.add(editParentFirstName);
		editParent.add(editParentLastName);
		editParent.add(editParentPhoneNumber);
		editParent.add(editParentAddress);

		JMenuItem listAllChildrenForAParent = new JMenuItem("View related children records");
		listAllChildrenForAParent.addActionListener(this);
		listAllChildrenForAParent.setActionCommand("List all children for a parent");
		JMenuItem removeParent = new JMenuItem("Remove");
		removeParent.addActionListener(this);
		removeParent.setActionCommand("Remove parent");

		parentActions.add(addParent);
		parentActions.add(editParent);
		parentActions.add(listAllChildrenForAParent);
		parentActions.add(removeParent);

		JMenuItem addChild = new JMenuItem("Add");
		addChild.addActionListener(this);
		addChild.setActionCommand("Add child");
		JMenu editChild = new JMenu("Edit");
		JMenuItem editChildFirstName = new JMenuItem("First name");
		editChildFirstName.addActionListener(this);
		editChildFirstName.setActionCommand("Edit child first name");
		JMenuItem editChildLastName = new JMenuItem("Last name");
		editChildLastName.addActionListener(this);
		editChildLastName.setActionCommand("Edit child last name");
		JMenuItem editChildTimeInPlaygroup = new JMenuItem("Time in playgroup");
		editChildTimeInPlaygroup.addActionListener(this);
		editChildTimeInPlaygroup.setActionCommand("Edit time in plyagroup");
		JMenuItem editChildTransportation = new JMenuItem("Transportation");
		editChildTransportation.addActionListener(this);
		editChildTransportation.setActionCommand("Edit transportation");
		JMenuItem editChildAllergies = new JMenuItem("Allergy information");
		editChildAllergies.addActionListener(this);
		editChildAllergies.setActionCommand("Edit allergies");
		JMenuItem editChildDOB = new JMenuItem("DOB");
		editChildDOB.addActionListener(this);
		editChildDOB.setActionCommand("Edit DOB");
		JMenuItem editEmergencyContact = new JMenuItem("Emergency contact");
		editEmergencyContact.addActionListener(this);
		editEmergencyContact.setActionCommand("Edit emergency contact");
		JMenuItem editChildParent = new JMenuItem("Parent");
		editChildParent.addActionListener(this);
		editChildParent.setActionCommand("Edit child parent");

		editChild.add(editChildFirstName);
		editChild.add(editChildLastName);
		editChild.add(editChildTimeInPlaygroup);
		editChild.add(editChildTransportation);
		editChild.add(editChildAllergies);
		editChild.add(editChildDOB);
		editChild.add(editEmergencyContact);
		editChild.add(editChildParent);
		JMenuItem removeChild = new JMenuItem("Remove");
		removeChild.addActionListener(this);
		removeChild.setActionCommand("Remove child");
		childActions.add(addChild);
		childActions.add(editChild);
		childActions.add(removeChild);

		JMenuItem listAllParents = new JMenuItem("Parents");
		//listAllParents.addActionListener(this);
		//listAllParents.setActionCommand("List all parents");
		JMenuItem listAllChildren = new JMenuItem("Children");
		//listAllChildren.addActionListener(this);
		//listAllChildren.setActionCommand("List all children");
		JMenuItem listAll = new JMenuItem("All Records");
		//listAll.addActionListener(this);
		//listAll.setActionCommand("List all");
		listActions.add(listAllParents);
		listActions.add(listAllChildren);
		listActions.add(listAll);

		frame.getContentPane().add(BorderLayout.NORTH, menuBar);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Add parent":
			String fname = JOptionPane.showInputDialog("Enter first name");
			String lname = JOptionPane.showInputDialog("Enter last name");
			String num = JOptionPane.showInputDialog("Enter phone number");
			String address = JOptionPane.showInputDialog("Enter address");
			playgroup.addParent(fname, lname, num, address);
			break;
		case "Edit parent first name":
			String fname1 = JOptionPane.showInputDialog("Enter first name");
			String lname1 = JOptionPane.showInputDialog("Enter last name");
			String newFName = JOptionPane.showInputDialog("Enter new first name");
			playgroup.editParentFirstName(fname1, lname1, newFName);
			break;
		case "Edit parent last name":
			String fname2 = JOptionPane.showInputDialog("Enter first name");
			String lname2 = JOptionPane.showInputDialog("Enter last name");
			String newLName = JOptionPane.showInputDialog("Enter new last name");
			playgroup.editParentLastName(fname2, lname2, newLName);
			break;
		case "Edit parent phone number":
			String fname3 = JOptionPane.showInputDialog("Enter first name");
			String lname3 = JOptionPane.showInputDialog("Enter last name");
			String newNum = JOptionPane.showInputDialog("Enter new phone number");
			playgroup.editParentPhoneNum(fname3, lname3, newNum);
			break;
		case "Edit parent address":
			String fname4 = JOptionPane.showInputDialog("Enter first name");
			String lname4 = JOptionPane.showInputDialog("Enter last name");
			String newAddress = JOptionPane.showInputDialog("Enter new address");
			playgroup.editParentAddress(fname4, lname4, newAddress);
			break;
		
		case "List all children for a parent":
			String fname5 = JOptionPane.showInputDialog("Enter first name");
			String lname5 = JOptionPane.showInputDialog("Enter last name");
			ArrayList<Child>allChildren=playgroup.listAllChildrenForAParent(fname5, lname5);
			String toPrint = null;
			if(allChildren==null) {
				toPrint= "Nothing found";
			}
			else {
				for(Child c:allChildren) {
					toPrint=toPrint+c.toString()+"\n";
				}
			}
			JOptionPane.showMessageDialog(null, toPrint);
			break;
			
		case "Remove parent":
			String fname6 = JOptionPane.showInputDialog("Enter first name");
			String lname6 = JOptionPane.showInputDialog("Enter last name");
			playgroup.removeParent(fname6, lname6);
			break;
		case "Add child":
			String fname7 = JOptionPane.showInputDialog("Enter first name");
			String lname7 = JOptionPane.showInputDialog("Enter last name");
			Time time=getTimeInPlaygroup();
			String allergies=JOptionPane.showInputDialog("Enter allergies");
			LocalDate DOB=getDOBfromUser();
			String PFName =JOptionPane.showInputDialog("Please enter the parent's first name");
			String PLName = JOptionPane.showInputDialog("Please enter the parent's last name: ");
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
			EmergencyContact eContact=getEmergencyContactFromUser();
			playgroup.addChild(fname7, lname7, time, allergies, DOB, parent, eContact);
			break;
		case "Edit child first name":
			String fname8 = JOptionPane.showInputDialog("Enter first name");
			String lname8 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB1=getDOBfromUser();
			String newfname = JOptionPane.showInputDialog("Enter new name");
			playgroup.editChildFirstName(fname8, lname8, DOB1, newfname);
			break;
		case "Edit child last name":
			String fname9 = JOptionPane.showInputDialog("Enter first name");
			String lname9 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB2=getDOBfromUser();
			String newlname = JOptionPane.showInputDialog("Enter new name");
			playgroup.editChildLastName(fname9, lname9, DOB2, newlname);
			break;
		case "Edit time in playgroup":
			String fname10 = JOptionPane.showInputDialog("Enter first name");
			String lname10 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB3=getDOBfromUser();
			Time newTime=getTimeInPlaygroup();
			playgroup.editTime(fname10, lname10, DOB3, newTime);
			break;
		case "Edit transportation":
			String fname11 = JOptionPane.showInputDialog("Enter first name");
			String lname11 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB4=getDOBfromUser();
			boolean tr = false;
			boolean done=false;
			while (!done) {
				String tempTr=JOptionPane.showInputDialog("Enter Y to include the child into the transportation list, N to exclude");
				if (tempTr.equalsIgnoreCase("y")) {
					tr=true;
					done = true;
				} else if (tempTr.equalsIgnoreCase("n")) {
					tr=false;
					done = true;
				}
			}
			playgroup.editTransportation(fname11, lname11, DOB4, tr);
			break;
		case "Edit allergies":
			String fname12 = JOptionPane.showInputDialog("Enter first name");
			String lname12 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB5=getDOBfromUser();
			String al=JOptionPane.showInputDialog("Enter allergies");
			playgroup.editAllergies(fname12, lname12, DOB5, al);
			break;
		case "Edit DOB":
			String fname13 = JOptionPane.showInputDialog("Enter first name");
			String lname13 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB6=getDOBfromUser();
			LocalDate newDOB=getDOBfromUser();
			playgroup.editDOB(fname13, lname13, DOB6, newDOB);
			break;
		case "Edit emergency contact":
			String fname14 = JOptionPane.showInputDialog("Enter first name");
			String lname14 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB7=getDOBfromUser();
			EmergencyContact eContact1=getEmergencyContactFromUser();
			playgroup.editEmergencyContact(fname14, lname14, DOB7, eContact1);
			break;
		case "Edit child parent":
			String fname15 = JOptionPane.showInputDialog("Enter first name");
			String lname15 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB8=getDOBfromUser();
			String PFName1 =JOptionPane.showInputDialog("Please enter the parent's first name");
			String PLName1 = JOptionPane.showInputDialog("Please enter the parent's last name: ");
			ArrayList<Parent> p1 = playgroup.getParentList();
			Parent tempPar1 = new Parent(PFName1, PLName1);
			Parent newParent = null;
			// pull up parent;
			for (int i = 0; i < p1.size(); i++) {
				if (p1.get(i).isSameParent(tempPar1)) {
					parent = tempPar1;
				}
			}
			if (newParent == null) {
				System.out.println("Parent is not in the system. Please enter parent information before adding the child.");
				break;
			}
			playgroup.editChildParent(fname15, lname15, DOB8, newParent);
			break;
		case "Remove child":
			String fname16 = JOptionPane.showInputDialog("Enter first name");
			String lname16 = JOptionPane.showInputDialog("Enter last name");
			LocalDate DOB9=getDOBfromUser();
			playgroup.removeChild(fname16, lname16, DOB9);
			break;
		case "Search":
			String target=JOptionPane.showInputDialog("What are you searching for?");
			ArrayList<Person>found=playgroup.search(target);
			String toPrint1 = null;
			if(found==null) {
				toPrint1= "Nothing found";
			}
			else {
				for(Person person:found) {
					toPrint1=toPrint1+person.toString()+"\n";
				}
			}
			JOptionPane.showMessageDialog(null, toPrint1);
			break;
		/*
		case "List all parents":
			JOptionPane.showMessageDialog(null, message);
			break;
		case "List all children":
			
			break;
		case "List all":
			
			break;
			*/
		

		}

	}
	private Time getTimeInPlaygroup() {
		Time time = null;
		boolean done=false;
		while (!done) {
			String tempTime=JOptionPane.showInputDialog("Enter Time in playgroup. H for half-day, F for full-day");
			if (tempTime.equalsIgnoreCase("H")) {
				time = Time.PART_TIME;
				done = true;
			} else if (tempTime.equalsIgnoreCase("F")) {
				time = Time.FULL_TIME;
				done = true;
			}
		}
		return time;
	}
	private static LocalDate getDOBfromUser() {
		String year = JOptionPane.showInputDialog("Enter year yyyy");
		String month = JOptionPane.showInputDialog("Enter month mm");
		String day = JOptionPane.showInputDialog("Enter day dd");
		String date = year + month + day;
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
		LocalDate birthday = LocalDate.parse(date, df);
		return birthday;
	}

	private static EmergencyContact getEmergencyContactFromUser() {
		JOptionPane.showMessageDialog(null, "Enter emergency contact information:");
		String fname=JOptionPane.showInputDialog("Enter first name");
		String lname =JOptionPane.showInputDialog("Enter last name");
		String relation =JOptionPane.showInputDialog("Enter relation to the child");
		String num = JOptionPane.showInputDialog("Enter fphone number");
		return (new EmergencyContact(fname, lname, relation, num));
	}
}
