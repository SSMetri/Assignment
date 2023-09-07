package Verification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class One {
	public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
        
        // Add Chrome options to disable unnecessary logging
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-logging");
        
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        System.out.println("***");
		driver.findElement(By.xpath("//a[@rel='async']")).click();
		
		WebElement radio = 
				driver.findElement(By.xpath("//input[@value='1']"));
		radio.click();
		Thread.sleep(1000);
		
		if(radio.isSelected() && radio.isEnabled())
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Didn't pass");
		}
		driver.close();
	}     

}
