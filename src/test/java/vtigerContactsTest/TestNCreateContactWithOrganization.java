package vtigerContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class TestNCreateContactWithOrganization extends vtiger.GenricUtility.BaseClass{

	@Test
	public void createContactWithOrganization() throws EncryptedDocumentException, IOException
	{
			// step 2: read all the necessary data			
				String ORGNAME= eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
				String LASTNAME= eUtil.readDataFromExcel("Contact", 1, 2);
		
				// Step 5: Navigate to Organization
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				Reporter.log("Organization link clicked", true);
			
			// Step 6: Navigate to create org image
				OrganizationsPage op= new OrganizationsPage(driver);
				op.ClickOnNewOrgImg();
				Reporter.log("Create org Look up image", true);
			
				//Create organization with mandatory fields
				CreateNewOrganizationPage cop =new CreateNewOrganizationPage(driver);
				cop.CreateNewOrg(ORGNAME);
				Reporter.log("--New Organization Created--", true);
				
				//validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader= oip.getOrgHeader();
				System.out.println(OrgHeader);
				Assert.assertTrue(OrgHeader.contains(LASTNAME));
				Assert.fail();
			// Step 7: Navigate to contacts link
				hp.clickOnContactsLink();
				Reporter.log("Contacts link clicked", true);
				
			//Step 8: Navigate to create contact img
				ContactPage cp= new ContactPage(driver);
				cp.clickOnConLookupimg();
				Reporter.log("Create contact look up image clciked");
				
			//Create contact with org details
				CreateNewContactPage cnp = new CreateNewContactPage(driver);
				cnp.createNewConWithOrg(LASTNAME, ORGNAME, driver);
				Reporter.log("new contact with organization created", true);
				
			//Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contatcHeader = cip.getContactHeader();
				System.out.println(contatcHeader);
				Assert.assertEquals(contatcHeader.contains(LASTNAME), true);
	}
}
