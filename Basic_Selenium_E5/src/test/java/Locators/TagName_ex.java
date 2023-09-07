package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagName_ex 
{
	public static void main(String[] args) {
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//maximizing the browser
		driver.manage().window().maximize();
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		for(WebElement ob:allLinks)
		{
			System.out.println(ob.getText());
		}
		driver.close();
	}

}
