package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {

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

		// * 6. Click on Find Accounts
		driver.findElement(By.linkText("Find Accounts")).click();

		// * 7. Enter AccountName as "Credit Limited Account"
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Credit Limited Account");

		// * 8. Click on Find Accounts using xpath Locator
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();

		// * 9. Click on the edit Button
		driver.findElement(By.linkText("Credit Limited Account")).click();
		driver.findElement(By.linkText("Edit")).click();
		// * 10. Get the Text of Account Name and verify
		String text = driver.findElement(By.id("accountName")).getText();

		if (text.contains("Credit")) {
			System.out.println("The Account name is " + text);
		}

		// * 11. Get the Text of Description
		String description = driver.findElement(By.xpath("//table/tbody/tr/td/textarea[@name='description']"))
				.getText();
		if (description.contains("Sales")) {
			System.out.println("The description is " + description);
		}

		// * 12. Get the title of the page and verify it.

		String title = driver.getTitle();
		if (title.contains("Edit"))

			System.out.println("The title is " + title);

		// *13. Close the browser
		driver.close();
	}

}
