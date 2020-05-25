package automation.hrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropDemo {

	public static void main(String[] args) {

		String propFile = "E:\\mavenProj\\hrm\\TestData\\data.properties";

		Properties prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
			System.out.println(prop);
			System.out.println(prop.getProperty("password"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("url"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
