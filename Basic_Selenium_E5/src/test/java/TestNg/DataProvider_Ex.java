package TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_Ex 
{
	@DataProvider
	public Object[][] getData()
	{
		Object[][] a=new Object[3][2];
		a[0][0]="aaaa";
		a[0][1]="1235";
		a[1][0]="bbbb";
		a[1][1]="94514";
		a[2][0]="cccc";
		a[2][1]="965412";
		
		return a;
	}
	@Test(dataProvider="getData")
	public void demo(String username,String pwd)
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
		driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
		driver.close();
	}
}
