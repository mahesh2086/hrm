package automation.hrm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JunitDemo {
	/*
	 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
	 */

	@Before
	public void test_before() {
		System.out.println("test_before");
	}

	@After
	public void test_after() {
		System.out.println("test_after");
	}
	
	@BeforeClass
	public static void test_before_class() {
		System.out.println("test_before_class");
	}
	
	@AfterClass
	public static void test_after_class() {
		System.out.println("test_after_class");
	}

	@Test
	public void test_01() {
		System.out.println("Test_01");
		assertEquals(1,11);
	}

	@Test
	public void test_02() {
		//WebDriver d; 
		System.out.println("Test_02");
		assertTrue(false);
		// assertTrue(d.findElement(By.xpath("")).isDisplayed());
		
		
		//boolen values true /false
	}

	@Test
	public void test_03() {
		System.out.println("Test_03");
		String s = "a";
		assertNotNull(s);
		s = null;
		assertNotNull(s);
	}

	@Test
	public void test_04() {
		System.out.println("Test_04");
		assertFalse(false);
	}

}
