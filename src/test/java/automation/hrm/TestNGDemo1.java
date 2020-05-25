package automation.hrm;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGDemo1 {

	@Test
	public void test_01() {
		System.out.println("test_01");

		// Hard
		/*
		 * String actual = "A"; String expected = "A"; boolean condition = true;
		 * Assert.assertEquals(actual, expected); Assert.assertNotEquals(actual,
		 * expected); Assert.assertFalse(condition); Assert.assertTrue(condition);
		 * Assert.assertNotNull(actual); Assert.assertNull(actual); Assert.fail();
		 * Assert.assertSame(actual, expected); Assert.assertNotSame(actual, expected);
		 */

		/*
		 * String actual = "A"; String expected = "AA"; boolean condition = true;
		 * Assert.assertEquals(actual, expected); System.out.println("test_Assert_01");
		 * Assert.assertFalse(condition); System.out.println("test_Assert_02");
		 */
		// Soft
		
		SoftAssert sa = new SoftAssert();
		String actual = "A";
		String expected = "AA";
		boolean condition = true;
		sa.assertEquals(actual, expected);
		System.out.println("test_Assert_01");
		sa.assertFalse(condition);
		System.out.println("test_Assert_02");
		sa.assertAll();
	}

}
