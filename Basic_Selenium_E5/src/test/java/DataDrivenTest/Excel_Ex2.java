package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Ex2 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream f=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\TestDataNOP.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("Sheet1");
		String url = sheet.getRow(1).getCell(0).getStringCellValue();
		String var = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(url+"\n"+var);
		
		sheet.createRow(2).createCell(0).setCellValue("THIS IS UPDAYED");
		wb.getSheet("Sheet1").createRow(4).createCell(0).setCellValue("22-jan-1986");
		wb.getSheet("Sheet1").createRow(5).createCell(0).setCellValue(var);
		wb.getSheet("Sheet1").createRow(6).createCell(0).setCellValue("title");
		FileOutputStream fil=new FileOutputStream(".\\src\\test\\resources\\TestDataNOP.xlsx");
		wb.write(fil);
		f.close();
		fil.close();
		
		FileInputStream f1=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\TestDataNOP.xlsx");
		wb = WorkbookFactory.create(f1);
		wb.getSheet("Sheet2").createRow(0).createCell(0).setCellValue("Enter values");
		wb.getSheet("Sheet2").createRow(1).createCell(0).setCellValue("Vale1");
		FileOutputStream sheet2=new FileOutputStream(".\\src\\test\\resources\\TestDataNOP.xlsx");
		wb.write(sheet2);


	}

}
