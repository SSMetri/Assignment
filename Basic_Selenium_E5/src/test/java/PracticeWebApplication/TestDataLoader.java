package PracticeWebApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;

public class TestDataLoader
{
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\MultipleData.properties");
		Properties p=new Properties();
		p.load(fis);
		String n1 = p.getProperty("name1");
		String n2 = p.getProperty("name2");
		String n3 = p.getProperty("name3");
		System.out.println(n1+","+n2+","+n3);
		
	}
	

}
