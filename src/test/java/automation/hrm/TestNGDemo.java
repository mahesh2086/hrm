package automation.hrm;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {

	/*
	 * @BeforeSuite public void test_BeforeSuite() {
	 * System.out.println("test_BeforeSuite"); }
	 * 
	 * @AfterSuite public void test_AfterSuite() {
	 * System.out.println("test_AfterSuite"); }
	 */
	@BeforeTest
	public void test_BeforeTest() {
		System.out.println("test_BeforeTest");
	}

	@AfterTest
	public void test_AfterTest() {
		System.out.println("test_AfterTest");
	}

	@BeforeGroups
	public void test_BeforeGroups() {
		System.out.println("test_BeforeGroups");
	}

	@AfterGroups
	public void test_AfterGroups() {
		System.out.println("test_AfterGroups");
	}

	@BeforeClass
	public void test_BeforeClass() {
		System.out.println("test_BeforClass");
	}

	@AfterClass
	public void test_AfterClass() {
		System.out.println("test_AfterClass");
	}

	@BeforeMethod
	public void test_BeforeMethod() {
		System.out.println("test_BeforeMethod");
	}

	@AfterMethod
	public void test_AfterMethod() {
		System.out.println("test_AfterMethod");
	}

	@Test(priority = 1) // enabled = false
	public void a() {
		System.out.println("test_02");
		Assert.fail("Fail");

	}
	
	@Test(priority = 1) // enabled = false
	public void c() {
		System.out.println("test_02_c");
		

	}

	@Test(priority = 1, dependsOnMethods = { "a", "c"})
	public void b() {
		System.out.println("test_01");
	}

}
