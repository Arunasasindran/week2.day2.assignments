package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle {
	public static void main(String[] args) {
		
		//setup Chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Launch target url
		driver.get("https://acme-test.uipath.com/login");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//Enter email id
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		
		//Enter password
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		//click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//getTitle of the page
		String title = driver.getTitle();
		
		//print the title of the page
		System.out.println("The title of the page is "+title);
		
		//logout of the application
		//driver.findElement(By.xpath("//button[@type='button']/span[contains(text(),'Toggle navigation')]")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		System.out.println("Successfully Logged Out");
		
		//close the browser
		driver.close();
		
	}

}
