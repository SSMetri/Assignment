package Action_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Prog1 
{
	public static void main(String[] args) throws Throwable {
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
		ele.sendKeys("User name");
		Thread.sleep(1000);
		ele.clear();
		Thread.sleep(1000);
		driver.close();
		
	}

}
