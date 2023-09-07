package TestNg_Sequential;

import org.testng.annotations.Test;

public class Seq1 
{
	@Test(priority=2,invocationCount=3)
	public void run()
	{
		System.out.println("Sequestial 1");
	}
	
	@Test(priority=1,invocationCount=2)
	public void run2()
	{
		System.out.println("Sequestial 2");
	}

}
