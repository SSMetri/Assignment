package Actions_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHovering 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://demoapp.skillrary.com/");
		//address of cousre element
		WebElement course = driver.findElement(By.xpath("//a[@id='course']"));
		
		//Create obj of actions class 
		Actions a=new Actions(driver);
		a.moveToElement(course).perform();
		//address of selenium course
		driver.findElement(By.xpath("(//span[@class='wrappers'])[1]")).click();
		Thread.sleep(2000);
		//Double clicking
		WebElement dclick = driver.findElement(By.xpath("//button[@id='add']"));
		a.doubleClick(dclick).perform();
		Thread.sleep(2000);
		System.out.println("Success");
		driver.close();
	}

}
