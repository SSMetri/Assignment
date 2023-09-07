package POM_ClassPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.Fb_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook 
{
	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://facebook.com/");
		
		Fb_LoginPage fbLogin=new Fb_LoginPage(driver);
//		fbLogin.emailTextField("giveEmail");
//		fbLogin.passTextField("givePassword");
//		fbLogin.loginButton();
		fbLogin.allMethods("MyNameIs","NoPassword");
//		
	}

}
