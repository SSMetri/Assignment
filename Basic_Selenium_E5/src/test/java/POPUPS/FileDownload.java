package POPUPS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[text()='Excel.xlsx']")).click();
		Thread.sleep(2000);
//		Alert ele = driver.switchTo().alert();
//		ele.accept();
		driver.close();
		
	}

}
