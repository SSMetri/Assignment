package Basic_Programming;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_Amazon 
{
	public static void main(String[] args) throws Throwable {
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//Entering url
		driver.get("https://www.amazon.in/");
		//maximizing the browser
		driver.manage().window().maximize();
		//using getTitle method
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keys");
		Thread.sleep(3000);
		driver.close();
		
	}

}
