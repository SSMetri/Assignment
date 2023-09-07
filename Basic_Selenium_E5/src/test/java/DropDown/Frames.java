package DropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.snapdeal.com/");
		//signin - mouseHover
		WebElement sign = driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions a=new Actions(driver);
		a.moveToElement(sign).perform();
		//click on register
		driver.findElement(By.xpath("//span[@class='newUserRegister']")).click();
		
		//switch to frame
		driver.switchTo().frame("loginIframe");
		//address of mobile text field
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("1214586");
		Thread.sleep(2000);
		//close by clicking cross icon - X
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-delete-sign fnt-22']")).click();
		//switch to defaultcontent/ shift our control back to web page
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("Toys");
		List<WebElement> listofToys = driver.findElements(By.xpath("//li[@class='suggestionList_menuitem unstructuredList']"));
		System.out.println(listofToys.size());
		for(WebElement we:listofToys)
		{
			System.out.println(we.getText());
		}
		driver.close();
		
	}

}
