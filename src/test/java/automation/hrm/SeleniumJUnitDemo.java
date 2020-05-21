package automation.hrm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumJUnitDemo extends Base {
	static private WebDriver d;

	@BeforeClass
	public static void setup() {
		d = getBrowser("chrome");
	}

	@AfterClass
	public static void tearDown() {
		d.close();
	}

	@Test
	@DisplayName("Application load in to browser")
	public void loadApp() {
		d.get("http://hrm.automationlabs.in/business/symfony/web/index.php/auth/login");
		System.out.println(d.getTitle());
		// OrangeHRM
		assertEquals("OrangeHRM", d.getTitle()); // E , A
	}

	@Ignore
	@Test
	public void loadApp2() {
		d.get("https://github.com/mahesh2086/hrm");
		assertEquals("GitHub - mahesh2086/hrm:hrm application automaton testing", d.getTitle()); // ? p / f
		System.out.println(d.getTitle());
		assertTrue(d.findElement(By.xpath("//a[@title=\"pom.xml\"]")).isDisplayed()); // ? p / f

		//

	}

}
