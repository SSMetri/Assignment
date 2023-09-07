package TestNG_Groups;

import org.testng.annotations.Test;

public class Sample2 
{
	@Test(groups="smoke")
	public void sample2_1()
	{
		System.out.println("This is sample 2_1");
	}
	@Test
	public void sample2_2()
	{
		System.out.println("This is sample 2_2");
	}

}
