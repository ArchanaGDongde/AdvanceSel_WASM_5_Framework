package vitiger.Practice;

import org.testng.annotations.Test;


public class TestNGPractise {

	@Test(priority = 2)
	public void createCustomer1()
	{
		System.out.println(" customer created");
	}
	
	@Test(enabled =  false)
	public void modifyCustomer1()
	{
		System.out.println("Modify Customer1");
	}
	
	@Test(priority = 1)
	public void deleteCustomer1()
	{
		System.out.println("Delete Customer1");
	}
}
