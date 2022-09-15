package vtiger.GenricUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to wed driver actions
 * @author archa
 *
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void waitForElementToLoadInDOM(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait for particular  element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for the particular element to perform click operation
	 * if the element is not interactive  it will wait for 1 second
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<10)
		{
			try 
			{
				element.getClass();
				break;
			}
			catch (Exception e) {
				// TODO: handle exception
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method will deselect deselect drop down content using index
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element, int index)
	{
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	/**
	 * This method deselect drop down content using visible text
	 * @param element
	 * @param index
	 */
	public void deselectByVisibleText(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.deselectByVisibleText(visibleText);
	}
	
	/**
	 * This method will deselect deselect drop down content using value
	 * @param element
	 * @param index
	 */
	public void deselectByValue(String value, WebElement element)
	{
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	/**
	 * This method will deselect All drop down content
	 * @param element
	 * @param index
	 */
	public void deselectAll(String value, WebElement element)
	{
		Select s = new Select(element);
		s.deselectAll();
	}
	/**
	 * This method will handle the drop down by select class using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle the drop down by select class using visible text
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will handle the drop down by select class using value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle the mouse hover on particular element
	 * @param element
	 * @param index
	 */
	public void handleMouseHover( WebDriver driver, WebElement element)
	{
		Actions a= new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse hover action over the offset
	 * @param element
	 * @param index
	 */
	public void mouseHoverOn( WebDriver driver,int x, int y)
	{
		Actions a= new Actions(driver);
		a.moveByOffset(x, y).perform();
	}
	/**
	 * This method will handle  double click over a particular element
	 * @param element
	 * @param index
	 */
	public void doubleClickOn( WebDriver driver, WebElement element)
	{
		Actions a= new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method will handle  double click over a page
	 * @param element
	 * @param index
	 */
	public void doubleClick( WebDriver driver)
	{
		Actions a= new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method will perform Right click on the particular element
	 * @param element
	 * @param index
	 */
	public void rightClickOn( WebDriver driver, WebElement element)
	{
		Actions a= new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will perform Right click on the particular element
	 * @param element
	 * @param index
	 */
	public void rightClick( WebDriver driver)
	{
		Actions a= new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method will handle the mouse hover
	 * @param element
	 * @param index
	 */
	public void handleDragAndDrop( WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions a= new Actions(driver);
		a.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * This method will switch to Frame based on index
	 * @param element
	 * @param index
	 */
	public void switchToFrame( WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method will switch to Frame based on id or name
	 * @param element
	 * @param index
	 */
	public void switchToFrame( WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
		
	}
	
	/**
	 * This method will switch to Frame based on element
	 * @param element
	 * @param index
	 */
	public void switchToFrame( WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
		
	}
	
	/**
	 * This method will accept the alert popup
	 * @param element
	 * @param index
	 */
	public void acceptAlert( WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param element
	 * @param index
	 */
	public void dismissAlert( WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will accept the alert popup
	 * @param element
	 * @param index
	 * @return 
	 */
	public String getTextInAlert( WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * This method will switch to default content
	 * @param element
	 * @param index
	 */
	public void switchBackToFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();	
	}
	
	/**
	 * This method will handle the Alert  PopUp and switch to Frame
	 * @param element
	 * @param index
	 */
	public void handleAlertPopUp( WebDriver driver)
	{
		driver.switchTo().frame(0);
		
	}
	
	/**
	 * This method will accept the alert popup
	 * @param element
	 * @param index
	 */
	public void switchToWindow( WebDriver driver, String PartialTitle)
	{
		//Step 1: get all window handles
		Set<String> windowIds = driver.getWindowHandles();
	
		//Step 2: iterate thru all the windowIds
		Iterator<String> it = windowIds.iterator();
		
		//Step 3:Navigate inside the windows
		while(it.hasNext())	//loop until windowIds exist
		{
			//capture all the window ids
			String winId= it.next();
			
			//Switch to the window and capture the title
			String currentTitle= driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(PartialTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take screenshot and return the address of destination path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".";
		File dst= new File(path);
		FileUtils.copyFile(src, dst);;
		return  dst.getAbsolutePath();
	}

	public void mouseHoverOn(WebDriver driver, WebElement element) {
		 Actions a= new Actions(driver);
		 a.moveToElement(element);
		
	}
}
