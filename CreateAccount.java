package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) {

		// Browser Setup and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		// Enter Username and Password using ID locators DemoSalesManager and crmsfa

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Click on Accounts Button
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		// Click on Create Account

		driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();

		// Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account");
		// Enter DEscriptiion as "Selenium Automation Tester"

		driver.findElement(By.xpath("//table/tbody/tr/td/textarea[@name='description']"))
				.sendKeys("Selenium Automation Tester");

		// Enter LocalName Field Using Xpath Locator
		driver.findElement(By.xpath("//table/tbody/tr/td/input[@id='groupNameLocal']")).sendKeys("localname");
		// Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//table/tbody/tr/td/input[@id='annualRevenue']")).sendKeys("sitename");
		// Enter value for AnnualRevenue Field using Xpath Locator but class as
		// Attribute
		driver.findElement(By.xpath("//input[@id='annualRevenue']")).sendKeys("20000$");

		// Click on Create Account using Xpath Locator
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Close the Browser
		driver.close();
	}

}
