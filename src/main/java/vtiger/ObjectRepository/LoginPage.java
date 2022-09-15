package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// rule 1: Create a seperate class for every page
	
	//Rule 2: Identify the element using @FindBy, @FindAll, @FindBys 
	// Declaration
	 
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor to initialize
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: provide getters to access the elements

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Step 5: Business libraru
	
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
