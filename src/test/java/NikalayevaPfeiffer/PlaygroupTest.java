package NikalayevaPfeiffer;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class PlaygroupTest {
	Playgroup underTest=new Playgroup("Sunny Day");
	ArrayList<Child>myChildArray=new ArrayList<Child>();
	ArrayList<Parent>myParentsArray=new ArrayList<Parent>();

	@Test
	public void testAddParent() {
		try {
			underTest.addParent("Mommy","Katz","1234567899","3 Cookie St");
			underTest.addParent("Totty","Katz","9876543212","3 Cookie St");
			myParentsArray.add(new Parent("Mommy","Katz","1234567899","3 Cookie St"));
			myParentsArray.add(new Parent("Totty","Katz","9876543212","3 Cookie St"));
			assertEquals(myParentsArray,underTest.parentList);			
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testAddChild() {
		try {
			Parent p=new Parent("Mommy","Katz","1234567899","3 Cookie St");
			underTest.addChild("Feigy","Brown",Time.PART_TIME,"none",LocalDate.parse("2017-02-02"),p,"Zaidy 1234569877");
			underTest.addChild("Malky","Brown",Time.PART_TIME,"none",LocalDate.parse("2017-02-02"),p,"Zaidy 1234569877");
			myChildArray.add(new Child("Feigy","Brown",Time.PART_TIME,"none",LocalDate.parse("2017-02-02"),p,"Zaidy 1234569877"));
			myChildArray.add(new Child("Malky","Brown",Time.PART_TIME,"none",LocalDate.parse("2017-02-02"),p,"Zaidy 1234569877"));
			assertEquals(myChildArray,underTest.childrenList);			
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditChildFirstName() {
		try {
			underTest.editChildFirstName("Feigy", "Brown", LocalDate.parse("2017-02-02"), "Feiga");
			myChildArray.get(0).setFirstName("Feiga");
			assertEquals(myChildArray.get(0).getFirstName(),underTest.childrenList.get(0).getFirstName());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditChildLastName() {
		try {
			underTest.editChildLastName("Feiga", "Brown",LocalDate.parse("2017-02-02") , "Katz");
			myChildArray.get(0).setLastName("Katz");
			assertEquals(myChildArray.get(0).getLastName(),underTest.childrenList.get(0).getLastName());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditTime() {
		try {
			underTest.editTime("Feiga", "Katz",LocalDate.parse("2017-02-02") , Time.FULL_TIME);
			myChildArray.get(0).setTimeInPlaygroup(Time.FULL_TIME);
			assertEquals(myChildArray.get(0).getTimeInPlaygroup(),underTest.childrenList.get(0).getTimeInPlaygroup());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditAllergies() {
		try {
			underTest.editAllergies("Feiga", "Katz", LocalDate.parse("2017-02-02"), "oranges");
			myChildArray.get(0).setAllergies("oranges");
			assertEquals(myChildArray.get(0).getAllergies(),underTest.childrenList.get(0).getAllergies());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditDOB() {
		try {
			underTest.editDOB("Feiga","Katz",LocalDate.parse("2017-02-02"),LocalDate.parse("2017-12-02"));
			myChildArray.get(0).setDOB(LocalDate.parse("2017-12-02"));
			assertEquals(myChildArray.get(0).getDOB(),underTest.childrenList.get(0).getDOB());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditEmergencyContact() {
		try {
			underTest.editEmergencyContact("Feiga", "Katz", LocalDate.parse("2017-12-02"), "3216549872");
			myChildArray.get(0).setEmergencyContact("3216549872");
			assertEquals(myChildArray.get(0).getEmergencyContact(),underTest.childrenList.get(0).getEmergencyContact());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditChildParent() {
		try {
			Parent p2=new Parent("Totty","Katz","9876543212","3 Cookie St");
			underTest.editChildParent("Feiga", "Katz", LocalDate.parse("2017-12-02"), p2);
			myChildArray.get(0).setParent(p2);
			assertEquals(myChildArray.get(0).getParent(),underTest.childrenList.get(0).getParent());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditParentFirstName() {
		try {
			underTest.editParentFirstName("Mommy","Katz","Esti");
			myParentsArray.get(0).setFirstName("Esti");
			assertEquals(myParentsArray.get(0).getFirstName(),underTest.parentList.get(0).getFirstName());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditParentLastName() {
		try {
			underTest.editParentLastName("Esti", "Katz", "Gold");
			myParentsArray.get(0).setLastName("Gold");
			assertEquals(myParentsArray.get(0).getLastName(),underTest.parentList.get(0).getLastName());
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditParentPhoneNum() {
		try {
			underTest.editParentPhoneNum("Esti", "Gold", "1234567893");
			myParentsArray.get(0).setPhoneNum("1234567893");
			assertEquals(myParentsArray.get(0).getPhoneNum(),underTest.parentList.get(0).getPhoneNum());
			}catch(Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void testEditParentAddress() {
		try {
			underTest.editParentAddress("Esti", "Gold", "14-65 Oak St");
			myParentsArray.get(0).setAddress("14-65 Oak St");
			assertEquals(myParentsArray.get(0).getAddress(),underTest.parentList.get(0).getAddress());
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
