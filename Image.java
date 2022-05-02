package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws InterruptedException {
		// browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		// click image to go to Home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		Thread.sleep(2000);
		System.out.println("I am in Home Page");
		driver.navigate().back();

		// verify the image is broken
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
		String title = driver.getTitle();
		if (title.equals("TestLeaf - Selenium Playground"))
			System.out.println("The image is not broken");

		else
			System.out.println("The image is broken");

		// click the image using keyboard or mouse
		WebElement element = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
		Actions action = new Actions(driver);
		action.click(element).perform();

		String title1 = driver.getTitle();
		if (title1.equals("TestLeaf - Selenium Playground"))
			System.out.println("The image is clicked by using keyboard or mouse");

		else
			System.out.println("The image is not clicked by using keyboard or mouse");
		// close the browser
		driver.navigate().back();
		driver.close();
	}
}
