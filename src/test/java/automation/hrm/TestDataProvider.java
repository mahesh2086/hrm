package automation.hrm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	@DataProvider(name = "test1")
	public Object[][] createData1() { /// Object[2][2]
		
		
		return new Object[][] { 
			
			{ "Cedric", new Integer(36) }, 
			{ "Anne", new Integer(37) },
			{ "Tom", new Integer(46) },
			
		};
	}

	// This test method declares that its data should be supplied by the Data
	// Provider
	// named "test1"
	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}

}
