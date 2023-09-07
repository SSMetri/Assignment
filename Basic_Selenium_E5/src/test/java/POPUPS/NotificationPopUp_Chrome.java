package POPUPS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopUp_Chrome 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--dissable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.quikr.com/");
		
	}

}
