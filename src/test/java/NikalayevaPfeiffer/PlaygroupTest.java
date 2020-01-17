package NikalayevaPfeiffer;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlaygroupTest {
	Playgroup underTest;
	ArrayList<Child> myChildArray = new ArrayList<Child>();
	ArrayList<Parent> myParentsArray = new ArrayList<Parent>();

	@Before
	public void init() {
		underTest = new Playgroup();
		Parent p = new Parent("Mommy", "Katz", "1234567899", "3 Cookie St");
		EmergencyContact ec = new EmergencyContact("Zaidy", "Brown", "Zaidy", "1234569877");
		underTest.addParent("Mommy", "Katz", "1234567899", "3 Cookie St");
		underTest.addChild("Feigy", "Brown", TimeInPlaygroup.PART_TIME, "none", LocalDate.parse("2017-02-02"), p, ec);
		myParentsArray.add(p);
		myChildArray.add(new Child("Feigy", "Brown", TimeInPlaygroup.PART_TIME, "none", LocalDate.parse("2017-02-02"), p, ec));
	}

	@After
	public void finalize() {
		myParentsArray.clear();
		myChildArray.clear();
	}

	/*
	 * @Test public void testAddParent() { underTest.addParent("Mommy", "Katz",
	 * "1234567899", "3 Cookie St"); assertEquals(myParentsArray,
	 * underTest.getParentList()); }
	 * 
	 * @Test public void testAddChild() {
	 * 
	 * Parent p = new Parent("Mommy", "Katz", "1234567899", "3 Cookie St");
	 * EmergencyContact ec = new EmergencyContact("Zaidy", "Brown", "Zaidy",
	 * "1234569877"); underTest.addChild("Feigy", "Brown", Time.PART_TIME, "none",
	 * LocalDate.parse("2017-02-02"), p, ec); assertEquals(myChildArray,
	 * underTest.getChildrenList());
	 * 
	 * }
	 */

	@Test
	public void testEditChildFirstName() {

		underTest.editChildFirstName("Feigy", "Brown", LocalDate.parse("2017-02-02"), "Feiga");
		myChildArray.get(0).setFirstName("Feiga");
		String expected = myChildArray.get(0).getFirstName();
		String actual = underTest.getChildrenList().get(0).getFirstName();
		assertEquals(expected, actual);

	}

	@Test
	public void testEditChildLastName() {

		underTest.editChildLastName("Feigy", "Brown", LocalDate.parse("2017-02-02"), "Katz");
		myChildArray.get(0).setLastName("Katz");
		assertEquals(myChildArray.get(0).getLastName(), underTest.getChildrenList().get(0).getLastName());

	}

	@Test
	public void testEditTime() {
		underTest.editTime("Feigy", "Brown", LocalDate.parse("2017-02-02"), TimeInPlaygroup.FULL_TIME);
		myChildArray.get(0).setTimeInPlaygroup(TimeInPlaygroup.FULL_TIME);
		assertEquals(myChildArray.get(0).getTimeInPlaygroup(), underTest.getChildrenList().get(0).getTimeInPlaygroup());

	}

	@Test
	public void testEditAllergies() {

		underTest.editAllergies("Feigy", "Brown", LocalDate.parse("2017-02-02"), "oranges");
		myChildArray.get(0).setAllergies("oranges");
		assertEquals(myChildArray.get(0).getAllergies(), underTest.getChildrenList().get(0).getAllergies());

	}

	@Test
	public void testEditDOB() {

		underTest.editDOB("Feigy", "Brown", LocalDate.parse("2017-02-02"), LocalDate.parse("2017-12-02"));
		myChildArray.get(0).setDOB(LocalDate.parse("2017-12-02"));
		assertEquals(myChildArray.get(0).getDOB(), underTest.getChildrenList().get(0).getDOB());

	}

	@Test
	public void testEditEmergencyContact() {

		EmergencyContact ec = new EmergencyContact("Bobby", "Brown", "Bobby", "3216549872");
		underTest.editEmergencyContact("Feigy", "Brown", LocalDate.parse("2017-02-02"), ec);
		myChildArray.get(0).setEmergencyContact(ec);
		assertEquals(myChildArray.get(0).getEmergencyContact(),
				underTest.getChildrenList().get(0).getEmergencyContact());

	}

	@Test
	public void testEditChildParent() {

		Parent p2 = new Parent("Totty", "Katz", "9876543212", "3 Cookie St");
		underTest.editChildParent("Feigy", "Brown", LocalDate.parse("2017-02-02"), p2);
		myChildArray.get(0).setParent(p2);
		assertEquals(myChildArray.get(0).getParent(), underTest.getChildrenList().get(0).getParent());

	}

	@Test
	public void testEditParentFirstName() {

		underTest.editParentFirstName("Mommy", "Katz", "Esti");
		myParentsArray.get(0).setFirstName("Esti");
		assertEquals(myParentsArray.get(0).getFirstName(), underTest.getParentList().get(0).getFirstName());

	}

	@Test
	public void testEditParentLastName() {

		underTest.editParentLastName("Mommy", "Katz", "Gold");
		myParentsArray.get(0).setLastName("Gold");
		assertEquals(myParentsArray.get(0).getLastName(), underTest.getParentList().get(0).getLastName());

	}

	@Test
	public void testEditParentPhoneNum() {

		underTest.editParentPhoneNum("Mommy", "Katz", "1234567893");
		myParentsArray.get(0).setPhoneNum("1234567893");
		assertEquals(myParentsArray.get(0).getPhoneNum(), underTest.getParentList().get(0).getPhoneNum());

	}

	@Test
	public void testEditParentAddress() {

		underTest.editParentAddress("Mommy", "Katz", "14-65 Oak St");
		myParentsArray.get(0).setAddress("14-65 Oak St");
		assertEquals(myParentsArray.get(0).getAddress(), underTest.getParentList().get(0).getAddress());

	}

	@Test
	public void testRemoveChild() {
		underTest.removeChild("Feigy", "Brown", LocalDate.parse("2017-02-02"));
		myChildArray.remove(0);
		assertEquals(null, underTest.getChildrenList());
	}

	@Test
	public void testRemoveParent() {
		underTest.removeParent("Mommy", "Katz");
		assertEquals(null, underTest.getParentList());
	}

	@Test
	public void testSearch() {
		ArrayList<Person> myPersonArray = new ArrayList<>();
		//only Mommy Katz contains "Katz"
		myPersonArray.addAll(myParentsArray);
		myPersonArray.addAll(myChildArray);
		ArrayList<Person> searchResult = new ArrayList<>();
		searchResult = (ArrayList<Person>) underTest.search("Katz");
		assertEquals(myPersonArray, searchResult);
	}
}
