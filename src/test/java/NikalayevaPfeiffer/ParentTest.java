package NikalayevaPfeiffer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParentTest {

	@Test
	public void testEquals() {
		try {
			Parent p1=new Parent("Mommy","Katz","1234567899","3 Cookie St");
			Parent p2=new Parent("Totty","Katz","9876543212","3 Cookie St");
			assertEquals(false,p1.isSameParent(p2));
			Parent p3=new Parent("Mommy","Katz");
			assertEquals(true,p1.isSameParent(p3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
