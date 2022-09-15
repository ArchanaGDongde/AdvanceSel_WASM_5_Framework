package vtigerContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenricUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement OrgNameLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	
	//Initialization
	public  CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	//Utilization
	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}


	public WebElement getOrgNameLookUpImg() {
		return OrgNameLookUpImg;
	}


	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create contact
	 * @param lastName
	 */
	public void createNewContact(String lastName) {
		ContactNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
		
		/**
		 * This method will create contact
		 * @param lastName
		 */
		public void createNewConWithOrg(String lastName, String orgName, WebDriver driver) {
			ContactNameEdt.sendKeys(lastName);
			OrgNameLookUpImg.click();
			switchToWindow(driver, "Accounts");
			searchBoxEdt.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();	//Dynamic xpath
			switchToWindow(driver, "Contacts");
			saveBtn.click();
	}
	
	
}
