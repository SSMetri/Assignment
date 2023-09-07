
package Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_ver1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        
        // Add Chrome options to disable unnecessary logging
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-logging");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.facebook.com/login/");
        
        // Wait for the email input field to be present
        WebElement ele = driver.findElement(By.xpath("//input[@id='email']"));
        
        if (ele.isDisplayed() && ele.isEnabled()) {
            ele.sendKeys("User_Name");
            System.out.println("Input field populated successfully.");
        } else {
            System.out.println("Input field is not displayed or enabled.");
        }
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("965256");
        WebElement button=driver.findElement(By.id("loginbutton"));
        if(button.isEnabled())
        {
        	button.click();
        	System.out.println("Pass");
        }
        else
        {
        	System.out.println("Button fail");
        }
        
        // Close the browser
        driver.quit();
    }
}

