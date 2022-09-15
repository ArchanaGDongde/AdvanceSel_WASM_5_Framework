package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenricUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateNewOrgLookUpImg;

// Initialization
public  OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
}

//Utilization
public WebElement getCreateNewOrgLookUpImg() {
	return CreateNewOrgLookUpImg;
}

//Business Library
/**
 * This method will click on  create new organization
 */
 public void ClickOnNewOrgImg() {
	CreateNewOrgLookUpImg.click(); 
 }
}

