package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDDT 
{
	public static void main(String[] args) throws Throwable {
		//Create an object of physical class
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,5);
		driver.get(url);
		
		String title = driver.getTitle();
		wb.getSheet("Sheet1").createRow(5).createCell(0).setCellValue(title+"serdtfyghujikl,mknjbvcf");
		FileOutputStream fil=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fil);
		
		driver.close();
		
		

	}

}
