package NikalayevaPfeiffer;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ChildTest {

	@Test
	public void testEquals() {
		try {
			Parent p= new Parent("Mommy","Katz","1234567899","3 Cookie St");
			EmergencyContact ec=new EmergencyContact("Zaidy","Katz","Zaidy","9876543211");
			LocalDate dob=LocalDate.parse("2017-02-02");
			Child c1=new Child("Feigy","Brown",TimeInPlaygroup.PART_TIME,"none",dob,p,ec);
			Child c2=new Child("Malky","Brown",TimeInPlaygroup.PART_TIME,"none",dob,p,ec);
			assertEquals(false,c1.isSameChild(c2));
			Child c3=new Child("Feigy","Brown",TimeInPlaygroup.PART_TIME,"none",dob,p,ec);
			assertEquals(true,c1.isSameChild(c3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
