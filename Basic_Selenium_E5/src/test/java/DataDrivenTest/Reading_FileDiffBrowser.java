package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reading_FileDiffBrowser 
{
	public static void main(String[] args) throws Throwable 
	{

		//Creating obj of properties file
		Properties p=new Properties();
		//Creating an obj for the physical file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.properties");
		p.load(fis);
		String appURL = p.getProperty("url");
		String user = p.getProperty("username");
		String pass = p.getProperty("password");
		String browser = p.getProperty("browser");
		
		//Opening in diff browser
		WebDriver driver;
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get(appURL);
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.close();
		
	}

}
