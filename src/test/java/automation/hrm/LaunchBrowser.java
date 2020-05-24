package automation.hrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaunchBrowser {

	private static WebDriver d;

	@Parameters({ "browserName" })
	@Test
	public void open(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			d = new ChromeDriver();
			d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			d.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			d = new FirefoxDriver();
			d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			d.manage().window().maximize();

		} else {
			System.out.println("????");
			System.exit(0);
		}

	}

	@Parameters({ "appUrl" })
	@Test(dependsOnMethods= "open")
	public void Test_Title(String appUrl) {
		d.get(appUrl);
		System.out.println("Web App Title:"+ d.getTitle());

	}
	
	@Test(dependsOnMethods= "Test_Title")
	public void closeApp() {
		d.close();
	}
}
