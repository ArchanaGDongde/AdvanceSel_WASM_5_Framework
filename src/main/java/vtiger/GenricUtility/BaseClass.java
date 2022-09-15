package vtiger.GenricUtility;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenricUtility.DatabaseUtility;
import vtiger.GenricUtility.ExcelFileUtility;
import vtiger.GenricUtility.JavaUtility;
import vtiger.GenricUtility.PropertyFileUtility;
import vtiger.GenricUtility.WebDriverUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotation for common functionalies like 
 * connection to database, launch the browser ets.
 * @author archana
 */
public class BaseClass {
	public DatabaseUtility dUtil= new DatabaseUtility();
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver =null;
	public static WebDriver sdriver= null;

	@BeforeSuite
	public void bsConfig() throws SQLException {
		//dUtil.connectToDB();
		Reporter.log("--Database connection successful--", true);
	}
	
	@BeforeClass
	public void bcCofig() throws IOException {
		String BROWSER = pUtil.readDataFormatPropertyFile("browser");
		String URL = pUtil.readDataFormatPropertyFile("url");

		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+ "launched successfully--");
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+ "launched successfully--");
		}
		else
		{
			System.out.println("invalid browser");
		}
		sdriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFormatPropertyFile("username");
		String PASSWORD = pUtil.readDataFormatPropertyFile("password");
		LoginPage lp =  new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("--Login sucessfull--", true);
	}
	
	@AfterMethod
	public void amCofig() {
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("--Signout successful", true);
	}
	
	@AfterClass
	public void acconfig() {
		driver.close();
		Reporter.log("==Browser closed successfully", true);
	}
	
	@AfterSuite
	public void asConfig() {
		//dUtil.closeDB();
		Reporter.log("--Database closed", true);
	}
}
