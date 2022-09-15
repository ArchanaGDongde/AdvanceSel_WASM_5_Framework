package vtiger.GenricUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class ListenerImplementation implements ITestListener {

	ExtentReporter report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName =  result.getMethod().getMethodName();
		//test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName =  result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 WebDriverUtility wUtil= new WebDriverUtility();
		 JavaUtility jUtil= new JavaUtility();
		 // htis will capture the current test method name
		 String methodName = result.getMethod().getMethodName();
		 
		 //this will append method name with date for screenshot
		 String screenShotName= methodName+"_"+jUtil.getSystemDateInFormat();
		 
		 //this will report and console
		 test.log(Status.FAIL, methodName+"---> Failed");
		 test.log(Status.FAIL,result.getThrowable());
		  try {
			String path=wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
