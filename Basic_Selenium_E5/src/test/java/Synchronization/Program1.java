package Synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 
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
		//Address of link
		WebElement cli=driver.findElement(By.linkText("Forgotten account?"));
		//condition
		wait.until(ExpectedConditions.elementToBeClickable(cli));
		cli.click();
		System.out.println(cli);
		driver.close();
		
		
	}

}
