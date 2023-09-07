package POPUPS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopUpFirefox 
{
	public static void main(String[] args) 
	{
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--dissable-notifications");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
//		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.quikr.com/");
		
	}

}
