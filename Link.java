package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		// setup Chrome browser
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Launch target url
		driver.get("http://leafground.com/pages/Link.html");

		// maximize the browser
		driver.manage().window().maximize();

		// Go to Home page

		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();

		Thread.sleep(2000);

		driver.navigate().back();

		// Find where the link is navigating to without clicking the link
		String hrefValue = driver.findElement(By.partialLinkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println("I am supposed to navigate to " + hrefValue);

		// verify the link is broken

		driver.findElement(By.xpath("//a[@href='error.html']")).click();
		String broken = driver.getTitle();
		if (broken.contains("404"))
			System.out.println("I am Broken");
		else
			System.out.println("I am not Broken");
		driver.navigate().back();

		// Interact with same link
		String link1 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).getAttribute("href");
		String link2 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href");

		if (link1.equals(link2)) {
			driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
			System.out.println(link1 + " is as same as " + link2);
			driver.navigate().back();
		} else {
			System.out.println("No Same link is present");
		}

		// find number of links present in the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links present in the page is " +links.size());

		// close the browser
		driver.close();

	}

}
