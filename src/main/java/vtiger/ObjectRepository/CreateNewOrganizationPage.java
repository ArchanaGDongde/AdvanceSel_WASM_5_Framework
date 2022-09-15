package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenricUtility.WebDriverUtility;

/**
 * 
 * @author archa
 *
 */
public class CreateNewOrganizationPage extends WebDriverUtility{
 // Declaration
	@FindBy(name= "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name= "industry")
	private WebElement IndustryDroDown;

	@FindBy(name= "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(name= "button")
	private WebElement saveBtn;
	
 //Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
 //Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDroDown() {
		return IndustryDroDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
// Business Library
	/**
	 * This method will create organization with Org name
	 */
	public void CreateNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}

	/**
	 * This method will create organization with Industry drop down
	 */
	public void CreateNewOrg(String Orgname, String IndustryType)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndustryType, IndustryDroDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with type and Industry drop down
	 */
	public void CreateNewOrg(String Orgname, String IndustryType, String Type)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndustryType, IndustryDroDown);
		handleDropDown(Type, typeDropDown);
		saveBtn.click();
	}
	
	
	
}
