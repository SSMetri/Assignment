package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail_Login 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/createaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("xyz"); // first name
		driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("last name"); // last name
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);
		String s="Basic information";
		String str=driver.findElement(By.xpath
				("//span[contains(.,'Basic information')]")).getText();
		Boolean res=s.contains(str);
		System.out.println(res);
		
		driver.findElement(By.xpath("//select[@aria-labelledby='month-label']")).sendKeys("January");
		driver.findElement(By.xpath("//input[@aria-label='Day']")).sendKeys("20");
		driver.findElement(By.xpath("//input[@aria-label='Year']")).sendKeys("2005");
		driver.findElement(By.xpath("(//select[@id='gender'])[1]")).sendKeys("Custom");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label=\"What's your gender?\"]")).sendKeys("xyz");
		driver.findElement(By.xpath("(//select[@id='genderpronoun'])[1]")).sendKeys("others");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']")).click();  // Next
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='t5nRo Id5V1'])[2]")).click(); //gamil type
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@jsname=\"LgbsSe\"])[1]")).click();
//		driver.findElement(By.xpath("(//div[@class=\"aCsJod oJeWuf\"])[1]")).sendKeys("sqwde52@dfgfg");
//		driver.findElement(By.xpath("div[id='confirm-passwd'] div[class='AxOyFc snByac']")).sendKeys("89897jhygtfrg#");
		driver.close();
		
		
	}

}
