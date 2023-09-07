package TestNg_Sequential;

import org.testng.annotations.Test;

public class Seq2 
{
	@Test(priority=3,invocationCount=3)
	public void test1()
	{
		System.out.println("Seq test1");
	}
	
	@Test(priority=2,invocationCount=2)
	public void test2()
	{
		System.out.println("Seq test2");
	}

}
