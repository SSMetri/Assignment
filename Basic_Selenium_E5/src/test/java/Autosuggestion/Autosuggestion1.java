package Autosuggestion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion1 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.firefoxdriver().setup();
        
        // Add Chrome options to disable unnecessary logging
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-logging");
        
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("mobile");
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='eIPGRd']"));
        Thread.sleep(1000);
        System.out.println(elements.size());
        for(WebElement ob:elements)
        {
        	System.out.println(ob.getText());
        	
        }
        Thread.sleep(1000);
        driver.close();
}

}
