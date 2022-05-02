package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {

		// browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// select languages that u know
		WebElement chkbxJava = driver.findElement(By.xpath("(//label[@for='java']/following-sibling::input)[1]"));
		chkbxJava.click();
		// System.out.println(chkbxJava.getText() +" is selected");
		WebElement chkbxSQL = driver.findElement(By.xpath("(//label[@for='java']/following-sibling::input)[3]"));
		chkbxSQL.click();
		// System.out.println(chkbxSQL.getText() +" is selected");

		// Confirm Selenium is checked
		WebElement selenium = driver.findElement(By.xpath("(//label[@for='java']/following-sibling::input)[6]"));
		if (selenium.isSelected())

			System.out.println("Selenium is selected");

		else
			System.out.println("Selenium is not selected");

		// DeSelect only checked
		WebElement deSelect = driver.findElement(By.xpath("(//label[@for='java']/following-sibling::input)[8]"));
		if (deSelect.isSelected()) {
			deSelect.click();
			System.out.println("It is deselected");
		} else
			System.out.println("It is selected");

		// Select all below checkboxes
		List<WebElement> checkBox = driver.findElements(By.tagName("input"));
		int count = checkBox.size();
		System.out.println(count);
		for (int i = 8; i <= count - 1; i++) {
			checkBox.get(i).click();
		}

		Thread.sleep(2000);
		driver.close();

	}

}
