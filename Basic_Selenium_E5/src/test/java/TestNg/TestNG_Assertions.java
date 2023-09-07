package TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Assertions 
{
	@Test
	public void assertipns()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();
		//HardAssert
//		Assert.assertEquals(title,"sdfgfasdv");
		
		//SoftAssert
		SoftAssert s=new SoftAssert();
		s.assertEquals(title, "sdfgfasdv");
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
	
	@Test
	public void demo()
	{
		System.out.println("Hello");
	}

}
