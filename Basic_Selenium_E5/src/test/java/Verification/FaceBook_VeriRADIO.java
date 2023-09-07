package Verification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook_VeriRADIO 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-logging");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//input[@value='1']"));
		ele.click();
		Thread.sleep(1000);
		if(ele.isSelected() && ele.isEnabled())
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		driver.close();
		
	}

}
