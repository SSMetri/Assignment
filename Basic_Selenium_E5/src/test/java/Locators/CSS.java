package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSS {

	public static void main(String[] args) throws Throwable 
	{
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//maximizing the browser
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Hi");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Password");
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
