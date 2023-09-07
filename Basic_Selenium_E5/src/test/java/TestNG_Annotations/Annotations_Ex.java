package TestNG_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_Ex 
{
	@BeforeSuite
	public void bsuite()
	{
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	public void asuit()
	{
		System.out.println("AfterSuite");
	}
	
	@BeforeTest
	public void btest()
	{
		System.out.println("BeforeTest");
	}
	@AfterTest
	public void atest()
	{
		System.out.println("AfterTest");
	}
	
	@BeforeClass
	public void bclass()
	{
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void aclass()
	{
		System.out.println("AfterClass");
	}
	
	@BeforeMethod
	public void bMethod()
	{
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void aMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@Test
	public void test1()
	{
		System.out.println("TEST1");
	}
	@Test
	public void test2()
	{
		System.out.println("Test2");
	}

}
