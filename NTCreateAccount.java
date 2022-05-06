package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAccount {

	public static void main(String[] args) {
		// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		// * 2. Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// * 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// * 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// * 5. Click on Accounts Button
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		// * 6. Click on Create Account
		driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();

		// * 7. Select preferred currency as Indian Rupee using SelectByValue
		Select select = new Select(driver.findElement(By.xpath("//select[@id='currencyUomId']")));
		select.selectByValue("INR");
		// * 8. Enter the Description text as "NRI Account"
		driver.findElement(By.xpath("//table/tbody/tr/td/textarea[@name='description']")).sendKeys("NRI Account");

		// * 9. Enter LocalName Field Using Xpath Locator
		driver.findElement(By.xpath("//table/tbody/tr/td/input[@id='groupNameLocal']")).sendKeys("localname");
		// * 10. Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//table/tbody/tr/td/input[@id='annualRevenue']")).sendKeys("sitename");
		// * 11. Enter value for AnnualRevenue Field using Xpath Locator but class as
		// Attribute
		driver.findElement(By.xpath("//input[@id='annualRevenue']")).sendKeys("20000$");

		// * 17. Click on Create Account using Xpath Locator
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// * 18. Get the Text of Error Message Displayed (hint: Red Texts)
		String text = driver.findElement(By.xpath("//div/ul/li[@class='errorMessage']")).getText();
		System.out.println("The error message is " + text);
		// * close the browser
		driver.close();

	}

}
