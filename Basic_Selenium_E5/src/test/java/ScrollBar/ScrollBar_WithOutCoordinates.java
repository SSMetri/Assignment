package ScrollBar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollBar_WithOutCoordinates 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.amazon.in/");
		//Address of career ;inl from amazon page
		WebElement career = driver.findElement(By.xpath("//a[text()='Careers']"));
		//Downcasting
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", career);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",career);
		Thread.sleep(4000);
		driver.close();
		
		
	}

}
