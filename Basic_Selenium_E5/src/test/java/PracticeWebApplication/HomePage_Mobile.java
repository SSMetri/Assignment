package PracticeWebApplication;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage_Mobile 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Name");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Email@email.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password");
		WebElement box = driver.findElement(By.id("exampleCheck1"));
		box.click();
		if(box.isSelected())
		{
			System.out.println("Check box selected.");
		}
		else
		{
			System.out.println("Check box not selected");
		}
		//Select from dropdown, make a list of all elements in drop down
		List<WebElement> drop = driver.findElements(By.xpath("//div/select/option"));
		for(WebElement we:drop)
		{
			if(we.getText()=="Male")
			{
				we.click();
			}
		}
		driver.findElement(By.id("inlineRadio2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("30011998");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
//		WebElement msg = driver.findElement(By.xpath("//strong[normalize-space()='Success!']"));
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		if(msg.getText().contains("Success!"))
		{
			System.out.println(msg.getText());
		}
		else
		{
			System.out.println("Success message not visible");
		}
		driver.close();
	}

}
