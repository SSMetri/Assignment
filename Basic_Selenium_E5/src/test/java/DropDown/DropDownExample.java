package DropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor; // Import this class
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownExample 
{
	public static void main(String[] args) throws Throwable 
	{
		//FAIL
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.amazon.in/");
		
		// Address of dropdown
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		
		// Scroll the element into view using JavaScript Executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropDown);
		
		Select s=new Select(dropDown);
		s.selectByIndex(5);
		Thread.sleep(2000);
		
		// Scroll the element into view before interacting
		WebElement optionElement = driver.findElement(By.cssSelector("option[value='search-alias=collectibles']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
		
		s.selectByValue("search-alias=collectibles");
		Thread.sleep(2000);
		s.selectByVisibleText("Toys & Games");
		Thread.sleep(2000);
		
		//Get all values from dropdown
		List<WebElement> values = s.getOptions();
		System.out.println(values.size());
		for(WebElement we:values)
		{
			System.out.println(we.getText());
		}
		driver.quit(); // Use quit() instead of close() to ensure the browser is properly closed
	}
}
