package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateNewContatcLookUpImg;

	//Initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateNewContatcLookUpImg() {
		return CreateNewContatcLookUpImg;
	}
	
	//Business Library
	/**
	 * THIS METHOD WILL CLICK ON CONNTACT LOOK UP IMAGE
	 */
	public void clickOnConLookupimg() 
	{
	CreateNewContatcLookUpImg.click();
	}
	
	
}
