package vitiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class Test1 {
	
	@Test
	public void test1Config() {
		System.out.println("hello test");
	}
	@BeforeMethod
	public void bmcofig() {
		System.out.println("before method");
	}

	@BeforeSuite
	public void bscofig() {
		System.out.println("before suite");
	}
	@AfterMethod
	public void amCofig() {
		System.out.println("after method");
	}
	
	@BeforeClass
	public void bccofig() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void accofig() {
		System.out.println("after class");
	}
	
	@Test
	public void testcofig() {
		System.out.println("test1");
	}
	
	@BeforeMethod
	public void bmcofig1() {
		System.out.println("before method");
	}
}
