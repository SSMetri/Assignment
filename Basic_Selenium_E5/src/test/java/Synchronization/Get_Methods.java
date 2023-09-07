package Synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Get_Methods 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//maximizing the browser
		driver.manage().window().maximize();
		//implicit wait statement
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//explicit wait statement
		WebDriverWait wait=new WebDriverWait(driver,5);
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//address of email field
		WebElement ele = driver.findElement(By.id("email"));
		//Condition
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("User name");
		Point coordinates=ele.getLocation();
		System.out.println(coordinates.getX());
		System.out.println(coordinates.getY());
		System.out.println(ele.getSize());
		Dimension siz = ele.getSize();
		System.out.println("Height "+siz.getHeight());
		System.out.println("Width "+siz.getWidth());
		driver.close();
		
	}

}
