package automation.hrm;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo1 {

	@Parameters({ "age" })
	@Test
	public void test_Age(String age) {
		System.out.println("Age is: " + age);
	}

}
