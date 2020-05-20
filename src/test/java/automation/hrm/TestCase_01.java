package automation.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase_01 extends Base {

	static private WebDriver d;
	// test data
	static String emp_f_name = "Tom";
	static String emp_m_name = "";
	static String emp_l_name = "Mike";
	static String emp_id_new;

	
	public static void loadApp() {
		d = getBrowser("chrome");
		d.get("http://hrm.automationlabs.in/business/symfony/web/index.php/auth/login");
	}

	public static void login() {
		d.findElement(By.id("txtUsername")).sendKeys("");// need to adduser name
		d.findElement(By.id("txtPassword")).sendKeys("");
		d.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(d, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='welcome']")));
	}

	public static void navigateToAddEmp() {
		WebElement pim = d.findElement(By.xpath("//b[text()='PIM']"));
		WebElement addEmpLink = d.findElement(By.xpath("//a[text()='Add Employee']"));
		Actions act_1 = new Actions(d);
		act_1.moveToElement(pim).moveToElement(addEmpLink).click().build().perform();
	}

	public static void addDataToAddEmployee() {
		// name
		d.findElement(By.name("firstName")).sendKeys(emp_f_name);
		d.findElement(By.xpath("//input[@name='middleName']")).sendKeys(emp_m_name);
		d.findElement(By.name("lastName")).sendKeys(emp_l_name);
		// emp id

		WebElement emp_id_input = d.findElement(By.xpath("//input[@name='employeeId']"));
		emp_id_new = emp_id_input.getAttribute("value");
		System.out.println("emp_id_value:" + emp_id_new);
		// add pic
		String test_img = System.getProperty("user.dir") + "//TestData//user-200.png";
		d.findElement(By.xpath("//input[@name='photofile']")).sendKeys(test_img);
		//
		d.findElement(By.id("chkLogin")).click();
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(getRandamUserName(6));
		d.findElement(By.id("user_password")).sendKeys("ABCD_12_abc");
		d.findElement(By.id("re_password")).sendKeys("ABCD_12_abc");
		Select dd = new Select(d.findElement(By.xpath("//select[@name='status']")));
		dd.selectByVisibleText("Disabled");
		d.findElement(By.xpath("//input[@value='Save']")).click();

	}

	public static void validateDataOfEmployee() {
		WebDriverWait wait = new WebDriverWait(d, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Personal Details']"))); // Locater
		//wait.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//h1[text()='Personal Details']")))); // WebElement 
		String f_name = d.findElement(By.xpath("//input[@name='personal[txtEmpFirstName]']")).getAttribute("value");
		String m_name = d.findElement(By.xpath("//input[@name='personal[txtEmpMiddleName]']")).getAttribute("value");
		String l_name = d.findElement(By.xpath("//input[@name='personal[txtEmpLastName]']")).getAttribute("value");
		String emp_id = d.findElement(By.xpath("//input[@name='personal[txtEmployeeId]']")).getAttribute("value");

		if (emp_f_name.equalsIgnoreCase(f_name)) {
			System.out.println("PASS");
		}
		
		if (emp_m_name.equalsIgnoreCase(m_name)) {
			System.out.println("PASS");
		}

		if (emp_l_name.equalsIgnoreCase(l_name)) {
			System.out.println("PASS");
		}

		if (emp_id_new.equalsIgnoreCase(emp_id)) {
			System.out.println("PASS");
		}

	}

	public static void main(String[] args) {
		loadApp();
		login();
		navigateToAddEmp();
		addDataToAddEmployee();
		validateDataOfEmployee();
	}
}
