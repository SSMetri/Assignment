package POPUPS;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildPoppu 
{
	public static void main(String[] args) throws Throwable {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://skillrary.com/");
		//Parent window address
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'GEARS')]")).click();
		driver.findElement(By.xpath("(//a[text()=' SkillRary Essay'])[2]")).click();
		//Child window address if reference veariable child
		Set<String> child = driver.getWindowHandles();
		//Shifting control to child browser
		for(String s:child)
		{
			driver.switchTo().window(s);
		}
		driver.findElement(By.id("mytext")).sendKeys("Enter text");
		Thread.sleep(3000);
		//Shifting to parent window
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//a[normalize-space()='CATEGORIES']")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
