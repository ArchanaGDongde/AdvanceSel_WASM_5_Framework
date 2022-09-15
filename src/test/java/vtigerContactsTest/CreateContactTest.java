package vtigerContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenricUtility.ExcelFileUtility;
import vtiger.GenricUtility.JavaUtility;
import vtiger.GenricUtility.PropertyFileUtility;
import vtiger.GenricUtility.WebDriverUtility;

/**
 * This contains test scripts to crete contact
 * @author archa
 *
 */
public class CreateContactTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		
		/* Step 1: Create object ob all utilities*/
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil =  new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		// step 2: read all the necessary data
		String BROWSER = pUtil.readDataFormatPropertyFile("browser");
		String URL = pUtil.readDataFormatPropertyFile("url");
		String USERNAME = pUtil.readDataFormatPropertyFile("username");
		String PASSWORD =pUtil.readDataFormatPropertyFile("password");
		
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
			
		// step 5: Navigate to Contacts link
			driver.findElement(By.linkText("Contacts")).click();
			
		//step 6: click on create contact look up image
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
		//step 7: Create contact with the mandatory info
			driver.findElement(By.name("lastname")).sendKeys("dhongde");
			
		//Step 8: Save 
			driver.findElement(By.name("button")).click();
		// step 9: Logout
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverOn(driver, element);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
