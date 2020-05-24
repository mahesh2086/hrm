package automation.hrm;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	
	@Parameters({ "name", "age" })
	@Test
	public void test_01(String name, String age) {

		System.out.println("Name is: " + name);
		System.out.println("Age is: " + age);

	}

}
