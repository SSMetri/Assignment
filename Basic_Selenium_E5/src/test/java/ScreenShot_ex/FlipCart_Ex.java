package ScreenShot_ex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GENERIC.WebDriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipCart_Ex 
{
	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.flipkart.com/");
		
		WebElement element = driver.findElement(By.xpath("(//div[@class='_1wE2Px'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(element);
		driver.close();
		
		
	}

}
