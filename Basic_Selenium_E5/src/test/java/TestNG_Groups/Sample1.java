package TestNG_Groups;

import org.testng.annotations.Test;

public class Sample1 
{
	@Test
	public void sample1_1()
	{
		System.out.println("This is sample 1_1");
	}
	@Test(groups="smoke")
	public void sample1_2()
	{
		System.out.println("This is sample 1_2");
	}

}
