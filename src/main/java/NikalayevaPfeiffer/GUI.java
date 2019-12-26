package NikalayevaPfeiffer;

import java.awt.BorderLayout;

import javax.swing.*;

public class GUI extends JFrame{

	public GUI() {
		initGui();
	}

	private void initGui() {
		JFrame frame = new JFrame("Playgroup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1250, 650);

		JMenuBar menuBar = new JMenuBar();
		JMenu parentActions = new JMenu("Parent");
		JMenu childActions = new JMenu("Child");
		JMenu listActions = new JMenu("List contents");
		JMenu search = new JMenu("Search");
		menuBar.add(parentActions);
		menuBar.add(childActions);
		menuBar.add(listActions);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(search);

		JMenuItem addParent = new JMenuItem("Add");
		JMenu editParent = new JMenu("Edit");
		JMenuItem editParentFirstName = new JMenuItem("First name");
		JMenuItem editParentLastName = new JMenuItem("Last name");
		JMenuItem editParentPhoneNumber = new JMenuItem("Phone number");
		JMenuItem editParentAddress = new JMenuItem("Address");
		editParent.add(editParentFirstName);
		editParent.add(editParentLastName);
		editParent.add(editParentPhoneNumber);
		editParent.add(editParentAddress);
		JMenuItem listAllChildrenForAParent = new JMenuItem("View related children records");
		JMenuItem removeParent = new JMenuItem("Remove");
		parentActions.add(addParent);
		parentActions.add(editParent);
		parentActions.add(listAllChildrenForAParent);
		parentActions.add(removeParent);

		JMenuItem addChild = new JMenuItem("Add");
		JMenu editChild = new JMenu("Edit");
		JMenuItem editChildFirstName = new JMenuItem("First name");
		JMenuItem editChildLastName = new JMenuItem("Last name");
		JMenuItem editChildTimeInPlaygroup = new JMenuItem("Time in playgroup");
		JMenuItem editChildTransportation = new JMenuItem("Transportation");
		JMenuItem editChildAllergies = new JMenuItem("Allergy information");
		JMenuItem editChildDOB = new JMenuItem("DOB");
		JMenuItem editEmergencyContact = new JMenuItem("Emergency contact");
		JMenuItem editChildParent = new JMenuItem("Parent");
		editChild.add(editChildFirstName);
		editChild.add(editChildLastName);
		editChild.add(editChildTimeInPlaygroup);
		editChild.add(editChildTransportation);
		editChild.add(editChildAllergies);
		editChild.add(editChildDOB);
		editChild.add(editEmergencyContact);
		editChild.add(editChildParent);
		JMenuItem removeChild = new JMenuItem("Remove");
		childActions.add(addChild);
		childActions.add(editChild);
		childActions.add(removeChild);

		JMenuItem listAllParents = new JMenuItem("Parents");
		JMenuItem listAllChildren = new JMenuItem("Children");
		JMenuItem listAll = new JMenuItem("All Records");
		listActions.add(listAllParents);
		listActions.add(listAllChildren);
		listActions.add(listAll);

		frame.getContentPane().add(BorderLayout.NORTH, menuBar);

		frame.setVisible(true);

	}
}
