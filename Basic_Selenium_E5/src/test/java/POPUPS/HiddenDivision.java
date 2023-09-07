package POPUPS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenDivision 
{
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//span[text()='Date']")).click();
		//XPATH Traversing- clicking dynamically changing element
		driver.findElement(By.xpath("//div[text()='Aug']/../../..//span[text()='29']")).click();
		driver.close();
		//Dynamically enable window occlusion 1
	}

}
