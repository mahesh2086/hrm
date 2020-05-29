package automation.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DDDemo extends Base {

	public static void main(String[] args) throws Throwable {
		WebDriver d = getBrowser("chrome");
		d.get("http://demo.automationtesting.in/Static.html");
		WebElement src = d.findElement(By.xpath("//img[@id='angular']"));
		WebElement tar = d.findElement(By.xpath("//div[@id='droparea']"));//
		//
		System.out.println("1");
		Thread.sleep(5000);
		((JavascriptExecutor) d).executeScript("arguments[0].style.border='1px solid red'", src);
		((JavascriptExecutor) d).executeScript("arguments[0].style.border='1px solid red'", tar);
		System.out.println("2");
		Actions act = new Actions(d);

	
		System.out.println("3");
	}

}
