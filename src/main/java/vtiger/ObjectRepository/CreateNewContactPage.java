package vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vtiger.GenricUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	//Declaration
	@FindBy(name = "lastname")
	private WebElement ContactNameEdt;
	
	//@FindBy(xpath = "input[@name='account_name']/following-sibling::img[@title='Select']");
	//private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "Search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leacsourceDropDown;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]'")
	private WebElement saveBtn;
}
	
	
