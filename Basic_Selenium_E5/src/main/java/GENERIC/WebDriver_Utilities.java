package GENERIC;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utilities 
{
	// 1.mouseHover
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	//2.doubleClick
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	//3.contextClick
	public void contextClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	//4.dragAndDrop
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(ele1, ele2).perform();
	}
	//5.implicitWait
	public void implicitWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	//6.exmplicitWait for visibility of elemt
	public void exmplicitWait(WebDriver driver,int time,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//7.exmplicitWait for element to be clickble
	public void elementVisibility(WebDriver driver,int time,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}
	//Handling window
	//8.Parent window
	public void parentWindow(WebDriver driver)
	{
		String parent=driver.getWindowHandle();
		driver.switchTo().window(parent);
	}
	//9.Child window
	public void childWindow(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		for(String s:child)
		{
			driver.switchTo().window(s);
		}
	}
	
	//10.Frames-switchTO Frame
	public void frames(WebDriver driver,String value)
	{
		driver.switchTo().frame(value);
	}
	//11.Switch to Default content
	public void frames(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	//12.Clicking on Ok popup
	public void alertPopUpOK(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	//13.Cicking on Cancle
	public void alertPopUpDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	//14.handling Dropdown-VivibilityOfText()
	public void dropDowns(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	//JAVASCRIPTEXECUTOR
	public void scrollBar(WebDriver driver,WebElement ele)
	{
		Point loc = ele.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(" +x+ ","+y+")");
	}
	//TakeScreenshot
	public File takeScreenshot(WebDriver driver)
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		return src;
		
	}
	

}
