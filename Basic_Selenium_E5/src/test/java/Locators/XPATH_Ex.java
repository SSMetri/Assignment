package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPATH_Ex 
{
	public static void main(String[] args) throws Throwable {
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
		
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//maximizing the browser
		driver.manage().window().maximize();
		//Username - Xpath using xpath attribute
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("UserName");
		//Passwprd - Xpath using contains attribute
		driver.findElement(By.xpath("//input[contains(@autocomplete,'current-password')]")).sendKeys("Password");
		//Forgotten account? - Xpath using text
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Forgotten account?']")).click();
		Thread.sleep(2000);
		String res=driver.findElement(By.xpath("(//div[@class='_9nq2 marginBottom16px'])[1]")).getText();
		boolean re=res.contains("Please enter");
		System.out.println(re);
		
		driver.close();

}

}
