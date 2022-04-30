package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) throws InterruptedException {
		//setup Chrome browser
				WebDriverManager.chromedriver().setup();
				
				//Launch Chrome Browser
				ChromeDriver driver = new ChromeDriver();
				
				//Launch target url
				driver.get("http://leafground.com/pages/Edit.html");
				
				//maximize the browser
				driver.manage().window().maximize();
				
				//enter email id
				driver.findElement(By.id("email")).sendKeys("aruna.eee2006@gmail.com");
				
				
				
				//append the text and perform keyboard tab action
				driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Aruna" + Keys.TAB);
				
				
				//get default value
				
				WebElement getDefaultText = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
				System.out.println("The Default Value Entered is "+getDefaultText.getAttribute("value"));
				
				
				//clear the text
				driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
				
				
				//verify the textbox is disabled or not
				boolean enable = driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled();
				
				if(enable == false)
				{
					System.out.println("The textbox is disabled");
				}
				
				Thread.sleep(3000);
				
				//close the browser
				driver.close();
				
							
				
	}

}
