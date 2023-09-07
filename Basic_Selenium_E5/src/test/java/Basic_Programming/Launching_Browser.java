package Basic_Programming;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Launching_Browser {
	public static void main(String[] args) throws Throwable 
	{
		//chrome driver
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//Entering url
		driver.get("https://www.facebook.com/login/");
		//maximizing the browser
		driver.manage().window().maximize();
		//using getTitle method
		System.out.println(driver.getTitle());
		//using current url, getCurrentUrl
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(3000);
		// getPageSource
//		String pageSource=driver.getPageSource(); 
//		System.out.println(pageSource);
		//closing the program or browser
		
		driver.findElement(By.id("email"));
		driver.close();
	
}
}
