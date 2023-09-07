package Assignment;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Feames 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index?overview-summary.html");
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium.devtools.idealized.target']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[@class='interfaceName']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[text()='Instance Methods']")).click();
		String title = driver.findElement(By.xpath("//li/h4[text()='detachFromTarget']")).getText();
		if(title.contains("detachFromTarget"))
		{
			System.out.println("Title : "+title);
			String str1 = driver.findElement(By.xpath("//pre[contains(text(),'<java.lang.Void> detachFromTarget')]//a[@title='class in org.openqa.selenium.devtools'][normalize-space()='Command']")).getText();
			String str2 = driver.findElement(By.xpath("(//pre/a)[1]")).getText();
			String str3 = driver.findElement(By.xpath("(//pre/a)[2]")).getText();
			String str4 = driver.findElement(By.xpath("(//pre/a)[2]")).getText();
			System.out.println(str2+","+str3+","+str4);
			
			String s1=driver.findElement(By.cssSelector("pre.methodSignature")).getText();
			System.out.println(s1);
		}
		else
		{
			System.out.println("Title not found in webpage");
		}
		
		WebElement index = driver.findElement(By.xpath("//div[@class='bottomNav']//a[normalize-space()='Index']"));
		Point location = index.getLocation();
		int x=location.getX();
		int y=location.getY();

		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy("+ x + "," + y + ")");
		j.executeScript("arguments[0].click();",index);
		
		driver.findElement(By.xpath("//a[text()='above(By)']")).click();
		
		//Titels
		List<WebElement> titles = driver.findElements(By.xpath("//li/ul/li/h4"));
		List<WebElement> contents=driver.findElements(By.xpath("//li/ul/li/pre"));

		for (int i = 0; i < Math.min(titles.size(), contents.size()) ; i++) 
		{
		    WebElement titlee = titles.get(i);
		    WebElement content = contents.get(i);
		    System.out.println(titlee.getText() + " : " + content.getText());
		}
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/assignment1.png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[normalize-space()='Actions']")).click();
		String controctor = driver.findElement(By.xpath("//th[normalize-space()='Constructor']")).getText();
		String actions = driver.findElement(By.xpath("(//a[contains(text(),'Actions')])[1]")).getText();
		String web = driver.findElement(By.xpath("//tbody/tr[@class='altColor']/th[@class='colConstructorName']/code[1]/a[1]")).getText();
		System.out.println(controctor +" : "+ actions +"("+web+",driver)");
		
		File dest1=new File("./ScreenShots/actions.png");
		FileUtils.copyFile(src, dest1);
		
		driver.findElement(By.xpath("(//div/ul/li/a[@href='../../../../help-doc.html'])[1]")).click();
		String textis=driver.findElement(By.xpath("//h1[@class='title']")).getText();
		if(textis.contains("API"))
		{
			System.out.println(textis);
		}
		else
		{
			System.out.println("Help page not opend");
		}
		driver.findElement(By.xpath("(//a[@href='index.html?help-doc.html'][normalize-space()='Frames'])[1]")).click();
		File dest2=new File("./ScreenShots/helpPage.png");
		FileUtils.copyFile(src, dest2);		
		driver.findElement(By.xpath("//div[@class='fixedNav']//div[@class='subNav']//ul[@class='navList']//li/a[@href='help-doc.html']")).click();
		System.out.println("success");
		Thread.sleep(2000);
		driver.close();
		
	}
	

}
