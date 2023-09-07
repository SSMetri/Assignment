package PracticeWebApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import GENERIC.WebDriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeWebPage 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver_Utilities utilities=new WebDriver_Utilities();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("India");
		WebElement ele = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		utilities.dropDowns(ele,"Option2");
		Select s=new Select(ele);
		s.selectByIndex(0);
		s.selectByValue("option1");
//		s.selectByVisibleText("Option2");
		driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).click();
		
		//Scroll to elemet
		WebElement mHover = driver.findElement(By.xpath("//button[@id='mousehover']"));
		utilities.scrollBar(driver, mHover);
		
		//Mouse Hover
		utilities.mouseHover(driver, mHover);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Reload']")).click();
		
		//Pop Up
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("ALert Text");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		utilities.alertPopUpOK(driver);
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		utilities.alertPopUpDismiss(driver);
		
		
		WebElement textBox = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		if(textBox.isDisplayed())
		{
			System.out.println("Send text");
			textBox.sendKeys("Text Box is Empty");
			Thread.sleep(2000);
		}
		else 
		{
			System.out.println("Click on show");
			driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
			if(textBox.isDisplayed())
			{
				textBox.sendKeys("Text Box is Empty");
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		Thread.sleep(1000);
		
		//Frames
		driver.switchTo().frame("courses-iframe");
		//Screenshot
//		utilities.scrollBar(driver,mHover);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest2=new File("./ScreenShot/ppFrame1.png");
		FileUtils.copyFile(src, dest2);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[normalize-space()='Broken Link']")).click();
		String error = driver.findElement(By.xpath("//div[@class='flex items-center pt-8 sm:justify-start sm:pt-0']")).getText();
		if(error.contains("404"))
		{
			System.out.print(error);			
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Google+']")).click();
		System.out.println(driver.getTitle());
		
		
		
		driver.close();
	
		
	}

}
