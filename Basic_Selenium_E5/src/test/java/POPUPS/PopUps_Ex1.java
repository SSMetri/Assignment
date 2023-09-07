package POPUPS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUps_Ex1 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://demoapp.skillrary.com/product.php?product=selenium-training");
		
		driver.findElement(By.xpath("//button[text()=' Add to Cart']")).click();
		//shifting to pop up
		Alert a1 = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a1.getText());
		a1.accept();
		driver.close();
		
	}

}
