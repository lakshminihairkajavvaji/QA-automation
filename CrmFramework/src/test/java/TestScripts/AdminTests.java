package TestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.data.data;

import Services.services;
import Validators.validators;

public class AdminTests {
	public services service = null;
	public data crmdata = null;
	public validators validata = null;

	@BeforeClass
	public void init() throws IOException, InterruptedException {
		service = new services();
		crmdata = new data();
		validata = new validators();
		
		service.openCrmHomePage().loginToCrm(crmdata.CrmData().getRow(1).getCell(0).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(1).getStringCellValue());
	}
	
	
	
	
	@Test(description = "Create Account with valid data")
	public void createAccountWithValidData() throws IOException, InterruptedException {
		service.navigateToAccounts().clickOnCreatAccount();
		service.enterNameAccountsPage(crmdata.CrmData().getRow(1).getCell(2).getStringCellValue())
		       .enterAccountEmail(crmdata.CrmData().getRow(1).getCell(3).getStringCellValue())
		       .enterAccountPhoneNumber()
		       .enterAccountWebsite(crmdata.CrmData().getRow(1).getCell(7).getStringCellValue());
		service.enterBillingAddressStreet(crmdata.CrmData().getRow(1).getCell(8).getStringCellValue())
		        .enterBillingAddressCity(crmdata.CrmData().getRow(1).getCell(9).getStringCellValue())
		        .enterBillingAddressState(crmdata.CrmData().getRow(1).getCell(10).getStringCellValue())
		        .enterBillingAddressPostalCode()
		        .enterBillingAddressCountry(crmdata.CrmData().getRow(1).getCell(12).getStringCellValue());
		service.enterShippingAddressAccountPage().enterDetailsAccountPage().clickSaveButtonAccountsPage();
		service.getNameCreatedAccount();
		service.getEmailCreatedAccount();
		service.getPhoneNumber();
		service.getEmailCreatedAccount();
//		service.getBillingAddress();		
//		System.out.println(crmdata.CrmData().getRow(1).getCell(8).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(9).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(10).getStringCellValue()+"1234"+crmdata.CrmData().getRow(1).getCell(12).getStringCellValue());
		service.clickEditButton();
		service.enterNameAccountsPage("Niharika");
		service.clickSaveButtonAccountsPage();
		
		
	}
	
	@Test(description = "Create Contact with valid data")
	public void CreateContactWithValidData() throws IOException, InterruptedException {
		service.ClickOnContactsDashBoard();
		service.ClickOnCreateContactButton();
		
		service.EnterNameContacts();
		service.EnterAccountsContactsPage();
		
	}
	
//	@Test(description="enter details in account page")
//	public void enterDetailsAccountPage() throws IOException, InterruptedException {
//		service.enterNameAccountsPage(crmdata.CrmData().getRow(1).getCell(2).getStringCellValue()).enterdetailsAccountPage(crmdata.CrmData().getRow(1).getCell(3).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(4).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(5).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(6).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(7).getStringCellValue()).enterBillingAddressAccountPage(crmdata.CrmData().getRow(1).getCell(8).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(9).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(10).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(11).getStringCellValue(),crmdata.CrmData().getRow(1).getCell(12).getStringCellValue()).enterShippingAddressAccountPage().enterDetailsAccountPage().clickSaveButtonAccountsPage();
//	}
	
	//@Test(description = "login to the CrmHomePage with valid username and password")
	//public void verifyCrmLogin() throws IOException {
	//	crmservice.openCrmHomePage().loginToCrm();
	//}

}
