package NikalayevaPfeiffer;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ChildTest {

	@Test
	public void testEquals() {
		try {
			Parent p;
			p = new Parent("Mommy","Katz","1234567899","3 Cookie St");
			LocalDate dob=LocalDate.parse("2017-02-02");
			Child c1=new Child("Feigy","Brown",Time.PART_TIME,"none",dob,p,"Zaidy 1234569877");
			Child c2=new Child("Malky","Brown",Time.PART_TIME,"none",dob,p,"Zaidy 1234569877");
			assertEquals(false,c1.equals(c2));
			Child c3=new Child("Feigy","Brown",Time.PART_TIME,"none",dob,p,"Zaidy 1234569877");
			assertEquals(true,c1.equals(c3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
