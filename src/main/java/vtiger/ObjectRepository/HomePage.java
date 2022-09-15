package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
import vtiger.GenricUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

		//Declaration
		@FindBy(linkText = "Organizations")
		private WebElement OrganizationsLnk;
		
		@FindBy(linkText = "Contacts")
		private WebElement ContactsLnk;
		
		@FindBy(linkText = "Opportunities")
		private WebElement OpportunitiesLnk;
		
		@FindBy(linkText = "Products")
		private WebElement ProductsLnk;
		
		@FindBy(linkText = "Leads")
		private WebElement LeadsLnk;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorImg;
		
		//@FindAll({@FindBy(linkText = "Sign Out"), @FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']"))}
		@FindBy(linkText = "Sign Out")
		private WebElement signOutLnk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);			
		}
		
		//Utilization
		public WebElement getOrganizationsLnk() {
			return OrganizationsLnk;
		}

		public WebElement getContactsLnk() {
			return ContactsLnk;
		}

		public WebElement getOpportunitiesLnk() {
			return OpportunitiesLnk;
		}

		public WebElement getProductsLnk() {
			return ProductsLnk;
		}

		public WebElement getLeadsLnk() {
			return LeadsLnk;
		}

		public WebElement getAdministratorImg() {
			return administratorImg;
		}

		public WebElement getSignOutLnk() {
			return signOutLnk;
		}

		//Bussiness Library
		/**
		 * This method will perform signout operation
		 */
		public void signOutOfApp(WebDriver driver)
		{
			mouseHoverOn(driver, administratorImg);
			signOutLnk.click();
		}
		
		/**
		 * This method will click on Organization
		 */
		 public void clickOnOrgLink()
		 {
			 OrganizationsLnk.click();
		 }
		
		 /**
		 * This method will click on Opportunities
		 */
		 public void clickOnOppLink()
		 {
			 OpportunitiesLnk.click();
		 }	 
		
		 /**
		 * This method will click on Products
		 */
		 public void clickOnProductLink()
		 {
			 ProductsLnk.click();
		 }	 
			 
		 /**
		  ** This method will click on Leads
		 */
		 public void clickOnLeadsLink()
		 {
			 LeadsLnk.click();
		 }

		public void clickOnContactsLink() {
			ContactsLnk.click();
		}	 
}
