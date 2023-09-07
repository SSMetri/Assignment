package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators_Ex 
{
	public static void main(String[] args) throws Throwable {
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//maximizing the browser
		driver.manage().window().maximize();
		//use id
		driver.findElement(By.id("email")).sendKeys("ABC");
		//use name 
		driver.findElement(By.name("pass")).sendKeys("xyz");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@id='u_0_4_xf'])[1]")).click();
		Thread.sleep(2000);
		//use link -linktext method
//		driver.findElement(By.linkText("Forgotten account?")).click();
		//use link- partialLinkText method
		driver.findElement(By.partialLinkText("Forgotten")).click();
//		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgotten account?")).click();
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
