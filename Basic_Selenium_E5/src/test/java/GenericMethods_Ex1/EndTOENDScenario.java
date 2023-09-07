package GenericMethods_Ex1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import GENERIC.WebDriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EndTOENDScenario 
{
	public static void main(String[] args) 
	{
		WebDriver_Utilities utilities=new WebDriver_Utilities();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		utilities.implicitWait(driver,10);
		driver.get("https://skillrary.com/");
		driver.findElement(By.xpath("//a[contains(text(),'GEARS')]")).click();
		driver.findElement(By.xpath("(//a[text()=' SkillRary Demo APP'])[2]")).click();
		utilities.childWindow(driver);
		WebElement course = driver.findElement(By.id("course"));
		utilities.mouseHover(driver, course);
		driver.findElement(By.xpath("(//a[text()='Selenium Training'])[1]")).click();
		WebElement doubleClick = driver.findElement(By.xpath("//button[@id='add']"));
		utilities.doubleClick(driver, doubleClick);
		driver.findElement(By.xpath("//button[text()=' Add to Cart']")).click();
		utilities.alertPopUpDismiss(driver);
		driver.quit();
		
	}

}
