package TestNg;

import org.testng.annotations.Test;

public class Priority_Invocation_Enabled 
{
	@Test(enabled=true,invocationCount=2)
	public void demo1()
	{
		System.out.println("Hi demo1");
	}
	@Test(priority=-8,invocationCount=2)
	public void demo2()
	{
		System.out.println("Hi demo2");
	}
	@Test(priority=-5,invocationCount=4)
	public void demo3()
	{
		System.out.println("Hi demo3");
	}
	@Test(priority=2,invocationCount=-2)
	public void demo4()
	{
		System.out.println("Hi demo4");
	}

}
