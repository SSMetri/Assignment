package DropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelect_Example 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.amazon.in/");
		String str = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getText();
		System.out.println(str);
		driver.findElement(By.xpath("//a[normalize-space()='Mobiles']")).click();
		Thread.sleep(1000);
		WebElement drop = driver.findElement(By.xpath("(//select[@id='searchDropdownBox'])[1]"));
		drop.click();
		System.out.println(str);
		
		Select s=new Select(drop);
		
		s.selectByIndex(1);
		Thread.sleep(1000);
		s.selectByValue("search-alias=nowstore");
		Thread.sleep(1000);
		s.selectByVisibleText("Books");
		Thread.sleep(1000);
		//Getting all the values from dropdown
		List<WebElement> values = s.getOptions();
		List<WebElement> values2 = s.getAllSelectedOptions();

		for(WebElement we:values)
		{
			System.out.println(we.getText());
		}
		System.out.println("********");
		for(WebElement we:values2)
		{
			System.out.println(we.getText());
		}
		driver.close();
	}

}
