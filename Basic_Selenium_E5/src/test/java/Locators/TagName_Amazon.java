package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagName_Amazon 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
//		@SuppressWarnings("unchecked")
//		List<WebElement> element = (List<WebElement>) driver.findElement(By.tagName("input"));
//		for(WebElement el:element)
//		{
//		System.out.println(el.getText());
//		}
		driver.findElement(By.xpath("//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][normalize-space()='Sign in']")).click();
		Thread.sleep(1000);
		boolean x=driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']")).isDisplayed();
		driver.findElement(By.id("ap_email")).sendKeys("95959595");
		boolean y=driver.findElement(By.id("ap_email")).isEnabled();
		System.out.println(y);
		System.out.println(x);
		driver.close();
	}

}
