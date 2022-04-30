package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		// setup Chrome browser
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Launch target url
		driver.get("http://leafground.com/pages/Button.html");

		// maximize the browser
		driver.manage().window().maximize();

		// Click button to travel home page
		driver.findElement(By.id("home")).click();

		// wait for 2 secs
		Thread.sleep(2000);

		// navigate back to page
		driver.navigate().back();

		// Find position of button (x,y)
		WebElement element = driver.findElement(By.id("position"));
		Point point = element.getLocation();
		int x = point.getX();
		int y = point.getY();
		System.out.println("The position of button is " + x + " and " + y);

		// Find button color
		String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("The color of the element is " + color);

		// Find the height and width
		WebElement size = driver.findElement(By.id("size"));
		System.out.println("The Size of the element is " + size.getSize());

		// close the browser
		driver.close();

	}

}
