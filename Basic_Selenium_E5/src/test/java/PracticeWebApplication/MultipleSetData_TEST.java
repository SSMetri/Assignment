package PracticeWebApplication;

import org.testng.annotations.Test;

public class MultipleSetData_TEST 
{
	private TestDataLoader testDataLoader=new TestDataLoader();
	
	@Test
	public void testWithData1()
	{
		String data=testDataLoader("name1");
		System.out.println(testDataLoader("name1"));
	}

	private String testDataLoader(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
