package Basic_Programming;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation_Ex {
	public static void main(String[] args) throws Throwable 
	{
			//chrome driver
			WebDriverManager.chromedriver().setup();
			//opening chrome browser
			WebDriver driver=new ChromeDriver();
			//Entering url
			driver.get("https://www.facebook.com/login/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			// Navigate to amazon.com
			driver.navigate().to("https://www.amazon.in/");
			Thread.sleep(3000);
			//Navigate back
			driver.navigate().forward();
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			driver.quit();
			
			}
}
