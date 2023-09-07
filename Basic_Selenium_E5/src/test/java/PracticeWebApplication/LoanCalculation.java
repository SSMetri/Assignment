package PracticeWebApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GENERIC.WebDriver_Utilities;
import POM.LoanCalculationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanCalculation 
{	
	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver_Utilities utilities=new WebDriver_Utilities();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data_Loan.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String hPrice = p.getProperty("homeprice");
		String downpayment = p.getProperty("downpayment");
		String h_Insurance = p.getProperty("homeloaninsuranceamount");
		WebDriver driver;
		if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		utilities.implicitWait(driver,10);
		driver.get(url);
		driver.findElement(By.xpath("(//a[contains(text(),'Home Loan EMI Calculator with Prepayments, Taxes &')])[1]")).click();
		String str = driver.getTitle();
		System.out.println(str);
		
		LoanCalculationPage loan_p=new LoanCalculationPage(driver);
		
		
		driver.findElement(By.id("homeprice")).clear();
		loan_p.homeprice(hPrice);
//		driver.findElement(By.id("homeprice")).sendKeys(hPrice);
		
		driver.findElement(By.id("downpayment")).clear();
		loan_p.downpayment(downpayment);
//		driver.findElement(By.id("downpayment")).sendKeys(downpayment);
		
		driver.findElement(By.id("homeloaninsuranceamount")).clear();
		loan_p.homeloaninsuranceamount(h_Insurance);
//		driver.findElement(By.id("homeloaninsuranceamount")).sendKeys(h_Insurance);
		long loanAct=1000000L+50000l-(1000000l*10)/100;
		Thread.sleep(3000);
		
		String loan = driver.findElement(By.xpath("//input[@id='homeloanamount']")).getAttribute("value");		
		System.out.println("Actual "+loan+" & calculated "+loanAct);
		loan_p.monthElement();
//		driver.findElement(By.id("startmonthyear")).click();
		
		loan_p.dateElement();
//		driver.findElement(By.xpath("//span[text()='Sep']")).click();
				
//		WebElement ele = driver.findElement(By.xpath("//td[@id='monthlyprincipalandinterestterm']"));
		WebElement ele = loan_p.getScrollEle();
		utilities.scrollBar(driver,ele);
		String principle = ele.getText();
		
		/*
		String princ_amt = driver.findElement(By.xpath("//td[@id='monthlyprincipalandinterestdef']")).getText();
		String monthly = driver.findElement(By.xpath("//td[@id='extraterm']")).getText();
		String monthly_amt = driver.findElement(By.xpath("//td[@id='extradef']")).getText();
		String property=driver.findElement(By.xpath("//td[@id='monthlypropertytaxesterm']")).getText();
		String prpperty_tax=driver.findElement(By.xpath("//td[@id='monthlypropertytaxesdef']")).getText();
		String home=driver.findElement(By.xpath("//td[@id='monthlyhomeinsuranceterm']")).getText();
		String home_amt=driver.findElement(By.xpath("//td[@id='monthlyhomeinsurancedef']")).getText();
		String mentainance=driver.findElement(By.xpath("//td[@id='monthlymaintenanceexpensesterm']")).getText();	
		String mentainance_amt=driver.findElement(By.xpath("//td[@id='monthlymaintenanceexpensesdef']")).getText();
		String total=driver.findElement(By.xpath("//td[@class='col-8 aggregatelabel lastterm']")).getText();
		String total_amt=driver.findElement(By.xpath("//td[@id='monthlypayment']")).getText();
		*/

		
		String princ_amt = loan_p.getOne();
		String monthly = loan_p.getTwo();
		String monthly_amt = loan_p.getThree();
		String property= loan_p.getFour();
		String prpperty_tax= loan_p.getFive();
		String home= loan_p.getSix();
		String home_amt= loan_p.getSeven();
		String mentainance= loan_p.getEight();	
		String mentainance_amt= loan_p.getNine();
		String total= loan_p.getTen();
		String total_amt= loan_p.getEleven();
	
		System.out.println(principle +" : "+princ_amt + "\n" +monthly+" : "+monthly_amt+"\n"+property+" : "+prpperty_tax
				+"\n"+home+"  : "+home_amt+"\n"+mentainance+" : "+mentainance_amt+"\n"+total+" : "+total_amt);
		
//		String year_total = driver.findElement(By.xpath("//div[@class='col-6 aggregatelabel lastterm']")).getText();
//		String amt = driver.findElement(By.xpath("//div[@id='totalpayment']")).getText();
		String year_total = loan_p.getYearTotal();
		String amt = loan_p.getAmt();
		System.out.println(year_total+" : "+amt);
		
		
//		 * Take screenshot, give diff file name
		WebElement ss = driver.findElement(By.xpath("//span[@id='startmonthyeartext']"));
		utilities.scrollBar(driver, ss);
		File ret = utilities.takeScreenshot(driver);
		File dest=new File("./ScreenShot/graph.png");
		FileUtils.copyFile(ret,dest);
		WebElement ss2 = driver.findElement(By.xpath("//th[@id='yearheader']"));
		utilities.scrollBar(driver, ss2);
		File src2 = utilities.takeScreenshot(driver);
		File dest2=new File("./ScreenShot/LASTRUN.png");
		FileUtils.copyFile(src2, dest2);
		
		driver.navigate().back();
		Thread.sleep(1000);
		
//		WebElement pt1 = driver.findElement(By.xpath("//div[@id='loanamountslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
//		WebElement pt2 = driver.findElement(By.xpath("(//span[@style='left: 50%;'])[1]"));
		WebElement pt1 = loan_p.getPt1();
		WebElement pt2 = loan_p.getPt2();
		utilities.dragAndDrop(driver, pt1, pt2);
		
//		WebElement r_int1=driver.findElement(By.xpath("//div[@id='loaninterestslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
//		WebElement r_int2=driver.findElement(By.xpath("(//span[@style='left: 50%;'])[2]"));
		WebElement r_int1 = loan_p.getR_int1();
		WebElement r_int2 = loan_p.getR_int2();
		utilities.dragAndDrop(driver, r_int1, r_int2);
		
//		WebElement trnure = driver.findElement(By.xpath("//div[@id='loantermslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
//		WebElement trnure1 = driver.findElement(By.xpath("(//span[@style='left: 100%;'])[3]"));
		WebElement trnure = loan_p.getTrnure();
		WebElement trnure1 = loan_p.getTenure_months();
		utilities.dragAndDrop(driver, trnure, trnure1);
		Thread.sleep(5000);
//		driver.findElement(By.xpath("."));
		
		driver.close();

		
		
	}
	

}
