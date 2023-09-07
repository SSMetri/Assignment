package TestNG_Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations 
{
	WebDriver driver;
	@BeforeMethod
	public void opening()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
	}
	@AfterMethod
	public void closing()
	{
		driver.close();
	}
	@Test(priority=1)
	public void fb()
	{
		driver.get("https://facebook.com/");
	}
	@Test(priority=2)
	public void amazon()
	{
		driver.get("https://www.amazon.com/");
	}
	

}
