package PracticeWebApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import GENERIC.WebDriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nop_eCommerce 
{
	@Test
	public void nop_eComm() throws Throwable
	{
		WebDriver_Utilities utilities=new WebDriver_Utilities();
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\NOP_Ecommerce.properties");
		Properties p=new Properties();
		p.load(file);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		
		//Using EXCEL File
//		FileInputStream file=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\TestDataNOP.xlsx");
//		Workbook wb=WorkbookFactory.create(file);
//		String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
//		String browser=wb.getSheet("Sheet").getRow(1).getCell(1).getStringCellValue();
		
		//Test
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
		utilities.implicitWait(driver,10);
		driver.get(url);
		driver.close(); 
	}

}
