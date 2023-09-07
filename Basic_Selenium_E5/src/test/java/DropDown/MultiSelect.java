package DropDown;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor; // Import this class

import io.github.bonigarcia.wdm.WebDriverManager;
public class MultiSelect 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://demoapp.skillrary.com/");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='cars']"));
		
		Select s=new Select(dropdown);
		s.selectByIndex(0);
		Thread.sleep(3000);
		s.selectByValue("199");
		Thread.sleep(3000);
//		s.selectByVisibleText("More Than INR 500 ( 55 ) ");
		
		s.deselectByIndex(0);
		Thread.sleep(3000);
		s.deselectByValue("199");
		Thread.sleep(3000);
		
//		s.deselectByVisibleText("More Than INR 500 ( 55 ) ");
		System.out.println(s.isMultiple());
		List<WebElement> list = s.getAllSelectedOptions();
		for(WebElement w:list)
		{
			System.out.println(w.getText());
		}
		System.out.println("******************");
		List<WebElement> list2 = s.getOptions();
		for(WebElement w:list2)
		{
			System.out.println(w.getText());
		}
		driver.close();
		
	}

}
