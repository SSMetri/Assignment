package PracticeWebApplication;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart 
{
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		WebElement visible = driver.findElement(By.xpath("//span[@class='redLogo']"));
		if(visible.isDisplayed())
		{
			System.out.println("Web Application is opend");
		}
		else {
			System.out.println("OpenCart application did not open");
		}
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Br");
		List<WebElement> elemenets=driver.findElements(By.xpath("//div[@class='product']"));
		for(WebElement we:elemenets)
		{
			System.out.println(we.getText());
		}
		
		driver.findElement(By.xpath("(//div/button[text()='ADD TO CART'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div/button[text()='ADD TO CART'])[2]")).click();
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		
		String prod1 = driver.findElement(By.xpath("(//p[contains(.,'120')])[1]")).getText();
		String prod2 = driver.findElement(By.xpath("(//p[text()='35'])[1]")).getText();
		System.out.println(prod1+" "+prod2);
		double cost1=Double.parseDouble(prod1);
		double cost2=Double.parseDouble(prod2);
		double sum=cost1+cost2;
		System.out.println("Total amount without coupon is : "+sum);
		
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@class='promoInfo']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		Thread.sleep(1000);
		double expected_disAmount=sum-((sum*10)/100);
		System.out.println("Expected "+expected_disAmount);
		String amt = driver.findElement(By.xpath("//span[@class='discountAmt']")).getText();
		double actual_disAmount=Double.parseDouble(amt);
		System.out.println("Actual "+actual_disAmount);
		Thread.sleep(1000);
		if(expected_disAmount==actual_disAmount)
		{
			System.out.println("Validation successful");
		}
		else
		{
			System.out.println("Validation fail");
		}
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//select[@style='width: 200px;']")).sendKeys("i");
		driver.findElement(By.xpath("//select[@style='width: 200px;']")).sendKeys("i");
		List<WebElement> countries = driver.findElements(By.xpath("//select/option"));
		for(WebElement we:countries)
		{
			if(we.getText()=="India")
			{
				we.click();
				System.out.println(we.getText());
			}	
		}
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='Proceed'])[1]")).click();
		String result = driver.findElement(By.xpath("//div[@class=\"wrapperTwo\"]")).getText();
		if(result.contains("successfully"))
		{
			System.out.println(result);
		}
		driver.close();
	}

}
