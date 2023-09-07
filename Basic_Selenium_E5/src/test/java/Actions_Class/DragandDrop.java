package Actions_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
		//address of 1st block
		WebElement block1 = driver.findElement(By.xpath("(//h1[@class='draghandle'])[1]"));
		//address of 2nd block
		WebElement block2 = driver.findElement(By.xpath("(//h1[@class='draghandle'])[4]"));
		Actions a=new Actions(driver);
		a.dragAndDrop(block1, block2).perform();
		
		
	}

}
