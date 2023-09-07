package POPUPS;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Notificaton_popUp 
{
	public static void main(String[] args) throws Throwable 
	{
		/*
		HashMap<String, Integer> contentString=new HashMap<String, Integer>();
		HashMap<String, Object> profiles=new HashMap<String, Object>();
		HashMap<String, Object> prefs=new HashMap<String, Object>();

		contentString.put("Notification",1);
		profiles.put("managed_default_content_settings",contentString);
		prefs.put("Profile", profiles);
		
		//Handling Notification pop up in edge browser
		EdgeOptions options=new EdgeOptions();
		options.setCapability("preferences", prefs);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.quikr.com/");
		*/
		
		HashMap<String, Integer> contentString=new HashMap<String, Integer>();
		HashMap<String, Object> profiles=new HashMap<String, Object>();
		HashMap<String, Object> prefs=new HashMap<String, Object>();

		contentString.put("Notification",2);
		profiles.put("managed_default_content_settings",contentString);
		prefs.put("Profile", profiles);
		
		//Handling Notification pop up in edge browser firefox browser
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("preferences", prefs);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.quikr.com/");
		Thread.sleep(3000);
		
	
	}

}
