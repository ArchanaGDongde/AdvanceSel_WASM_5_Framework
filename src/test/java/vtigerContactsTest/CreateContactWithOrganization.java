package vtigerContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenricUtility.ExcelFileUtility;
import vtiger.GenricUtility.JavaUtility;
import vtiger.GenricUtility.PropertyFileUtility;
import vtiger.GenricUtility.WebDriverUtility;

public class CreateContactWithOrganization {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		
		//Step 1: Create Object of generic Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil =  new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		// step 2: read all the necessary data
		String BROWSER = pUtil.readDataFormatPropertyFile("browser");
		String URL = pUtil.readDataFormatPropertyFile("url");
		String USERNAME = pUtil.readDataFormatPropertyFile("username");
		String PASSWORD =pUtil.readDataFormatPropertyFile("password");
		
		String ORGNAME= eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME= eUtil.readDataFromExcel("Contact", 1, 2);
		
		// Step 3: Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched");
		}
		else
		{
			System.out.println("browser name invalid, henced launched chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
	
	
		// step 4: Login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
		// Step 5: Navigate to Organization
			driver.findElement(By.linkText("Organizations")).click();
			
		// Step 6: Create Organizartion with mandatory fields and save
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			driver.findElement(By.name("button")).click(); //save
			//String orgHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			System.out.println("--------Organization Created-----------");
			//System.out.println(orgHeader);
			
		// Step 7: Navigate to contacts
			driver.findElement(By.xpath("//td[@class='tabSelected']")).click();

			
		//Step 8: Navigate to create contact Link
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
			
		// Switch the control to child window
			wUtil.switchToWindow(driver, "Accounts");
			driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.linkText(ORGNAME)).click();
			
		//switch the control back to parent	
			wUtil.switchToWindow(driver, "Contact");
			driver.findElement(By.name("button")).click(); //save
			//WebElement contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			System.out.println("----Contact created----");
			
		//Step 9: Logout
			wUtil.mouseHoverOn(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
