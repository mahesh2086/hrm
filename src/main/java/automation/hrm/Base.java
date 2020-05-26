package automation.hrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencsv.CSVReader;

public class Base {

	public static String getRandamUserName(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static WebDriver getBrowser(String browserName) {
		WebDriver d = null;

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			d = new ChromeDriver();
			d.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			d = new FirefoxDriver();
			d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			d.manage().window().maximize();
		}

		return d;
	}

	public static Properties readPropFile(String propFileName) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFileName);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static CSVReader readCSVFile(String csvFileName) {
		CSVReader reader = null;
		FileReader fr;
		try {
			fr = new FileReader(csvFileName);
			reader = new CSVReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return reader;

	}

}
