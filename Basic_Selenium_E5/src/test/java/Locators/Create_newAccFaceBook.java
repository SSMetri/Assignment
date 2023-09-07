package Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_newAccFaceBook 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//opening chrome browser
		WebDriver driver=new ChromeDriver();
		//maximizing the browser
		driver.manage().window().maximize();
		//implicit wait statement
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//explicit wait statement
		WebDriverWait wait=new WebDriverWait(driver,5);
		//Entering url
		driver.get("https://www.facebook.com/");
		System.out.println("***");
		driver.findElement(By.xpath("//a[@id='u_0_0_1D']")).click();
		WebElement radio = driver.findElement(By.xpath("//input[@id='u_5_4_dh']"));
		radio.click();
		if(radio.isSelected())
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Didn't pass");
		}
		driver.close();
	}

}
