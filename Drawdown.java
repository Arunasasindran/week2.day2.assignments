package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drawdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();

		driver.findElement(By.name("firstname")).sendKeys("Aruna");

		driver.findElement(By.name("lastname")).sendKeys("Sasindran");

		WebElement element = driver.findElement(By.name("country_id"));
		element.sendKeys("India");
		

		driver.close();

	}

}
