package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenricUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {

	// Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business Library
	/**
	 * This method will get the header text for Oganization
	 * @return 
	 */
	public String getOrgHeader()
	{
		String orgHeader = OrgHeaderText.getText();
		return orgHeader;
	}
	
}
