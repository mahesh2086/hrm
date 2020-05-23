package automation.hrm;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
//
//	String friendName = "Jam";
//
	@DataProvider(name = "friendName")
	public static Object[][] names() {
		Object[][] names = new Object[15][2];
		for (int i = 0; i < 15; i++) {
			names[i][0] = "Tom_" + i;
			names[i][1] = i + 35;
		}
		return names;
	}

	@DataProvider(name = "friendNameAndAge")
	public static String[] Age() {
		String[] s = new String[10];
		for (int i = 0; i < 10; i++) {
			s[i] = "Tom_" + i;
		}
		return s;
	}

	// (dataProvider = "friendName")
	@Test(dataProvider = "friendName")
	public void test_dp_01(String name, Integer age) {
		System.out.println("Hello " + name + " ! and your age is " + age);
	}
	
	@Test(dataProvider = "friendNameAndAge")
	public void test_dp_02(String age) {
		System.out.println("Age is " + age);
	}

	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(Age()));

	}

}
