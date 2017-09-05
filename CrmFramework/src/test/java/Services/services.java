package Services;

import java.io.IOException;

import com.crm.config.Configuration;
import com.crm.config.CrmPageConstants;

import CommonUtils.CommonUtils;
import ObjectRepository.PageObjects;

public class services extends Configuration{
public PageObjects pageobj;
	
	public services openCrmHomePage() {
		pageobj = new PageObjects();
		invokeBrowser();
		return this;
	}
      
	public services loginToCrm(String uname,String pword) throws IOException, InterruptedException  {
		//CommonUtils.validatePage(CrmPageConstants.CRM_LOGIN_PAGE_TITLLE.title(), wd);
		CommonUtils.insertText("id", pageobj.getpageObjects().getProperty("crm_username_textbox_id"), uname, wd);
		CommonUtils.insertText("id", pageobj.getpageObjects().getProperty("crm_password_textbox_id"), pword, wd);
		CommonUtils.clickButton("id", pageobj.getpageObjects().getProperty("crm_login_button_id"), wd);
		Thread.sleep(3000);
		
		
		return this;
	}
	
	public services navigateToAccounts() throws IOException, InterruptedException {
		CommonUtils.clickLink("link", pageobj.getpageObjects().getProperty("crm_dashboard_accountslink"), wd);
		//CommonUtils.validatePage(CrmPageConstants.CRM_ACCOUNT_PAGE_TITLE.title(), wd);
		CommonUtils.wait(3);
		return this ;
	}
	
	public services clickOnCreatAccount() throws IOException, InterruptedException {
		CommonUtils.clickLink("link", pageobj.getpageObjects().getProperty("crm_accounts_creataccountlink"), wd);
		//CommonUtils.validatePage(CrmPageConstants.CRM_CREATEACCOUNT_PAGE_TITLE.title(), wd);
		CommonUtils.wait(3);
		return this ;
	}
    public services enterNameAccountsPage(String name) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_name_textbox"), name, wd);
    	return this;
    }
    
    public services enterAccountEmail(String email) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_email_textbox"), email, wd);
    	return this;
    }
    
    public services enterAccountPhoneNumber() throws IOException {
    	//String pnumber=phoneNumber.toString();
    	//CommonUtils.selectDropDownItem("css", pageobj.getpageObjects().getProperty("crm_phone_dropdown"), phoneNumberSelectValue, phoneNumberDropDown, wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_phone_textbox"), "7799095959", wd);
    	return this;
    	
    }
    public services enterAccountWebsite(String website) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_website_textbox"), website, wd);
    	return this;
    }
    

    public services enterBillingAddressStreet(String streetBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_billingaddress_street"), streetBillingAddress, wd);
    	return this;
    }
    public services enterBillingAddressCity(String cityBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_billingaddress_city"), cityBillingAddress, wd);
    	return this;
    	
    }
    public services enterBillingAddressState(String stateBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_billingaddress_state"), stateBillingAddress, wd);
    	return this;
    	
    }
    public services enterBillingAddressPostalCode() throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_billingaddress_postalcode"), "1234", wd);
    	return this;   	
    	
    }
    public services enterBillingAddressCountry(String countryBillingAddress) throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_billingaddress_country"), countryBillingAddress, wd);
    	return this;
    	
    }
     public services enterShippingAddressAccountPage() throws IOException {
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_shippingaddress_street"), "KPHB", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_shippingaddress_city"), "hyd", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_shippingaddress_state"), "AP", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_shippingaddress_postalcode"), "1234", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_shippingaddress_country"), "INDIA", wd);
    	
    	return this;
    	
    }
    public services enterDetailsAccountPage() throws IOException {
    	CommonUtils.selectDropDownItem("css", pageobj.getpageObjects().getProperty("crm_details_type_dropdown"), "text", "Investor", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_details_siccode_textbox"), "1234", wd);
    	CommonUtils.selectDropDownItem("css", pageobj.getpageObjects().getProperty("crm_details_industry"), "text", "Agriculture", wd);
    	CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_details_description"), "desciption entered here", wd);
    	
    	
    	return this;
    }
    public services clickSaveButtonAccountsPage() throws IOException, InterruptedException {
    	Thread.sleep(3000);
    	CommonUtils.clickButton("css", pageobj.getpageObjects().getProperty("crm_accountspage_save_button"), wd);
    	return this;
    }
    public services clickEditButton() throws IOException {
    	CommonUtils.clickButton("css", pageobj.getpageObjects().getProperty("crm_accounts_edit_button"), wd);
    	return this;
    }
    
   public String getNameCreatedAccount() throws IOException, InterruptedException {
	   CommonUtils.wait(2);
	   String Name=CommonUtils.getText("css", pageobj.getpageObjects().getProperty("crm_accountCreatedName_Data"), wd);
	   
	   System.out.println(Name);
   	   return Name;
   	
   }
   public String getEmailCreatedAccount() throws IOException {
	   String Email = CommonUtils.getText("css", pageobj.getpageObjects().getProperty("crm_getEmail_AccountsPage"), wd);
	   return Email;
   }
   
   public String getPhoneNumber() throws IOException {
	   String phoneNumber = CommonUtils.getText("css", pageobj.getpageObjects().getProperty("crm_getPhoneNumber_AccountsPage"), wd);
	   return phoneNumber;
   }
   public String getEmail() throws IOException {
	   String email = CommonUtils.getText("css", pageobj.getpageObjects().getProperty("crm_getEmail_AccountsPage"), wd);
	   return email;
   }
   public String getBillingAddress() throws IOException {
	   String billingAddress = CommonUtils.getText("css", pageobj.getpageObjects().getProperty("crm_getBillingAddress_AccountsPage"), wd);
//	   System.out.println(billingAddress);
//	   String []strArray=billingAddress.split(" ");
//	   for(int i=0; i<strArray.length;i++) {
//		     System.out.println(strArray[i]);
//		}
	   System.out.println(billingAddress);
	   return billingAddress;
	
   }
   public services ClickOnContactsDashBoard() throws IOException, InterruptedException {
	   CommonUtils.clickLink("id", pageobj.getpageObjects().getProperty("crm_contacts_contactslink"), wd);
	   CommonUtils.wait(2);
	return this;
   }
   
   public services ClickOnCreateContactButton() throws IOException {
	   CommonUtils.clickButton("id", pageobj.getpageObjects().getProperty("crm_contacts_CreateContact_id"), wd);
	   return this;
   }
   
   public services EnterNameContacts() throws IOException {
	   CommonUtils.selectDropDownItem("id", pageobj.getpageObjects().getProperty("crm_contacts_saluationname_id"), "text", "Mrs.", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_FirstName_TextBox"), "Lakshmi Niharika", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_LastName_TextBox"), "javvaji", wd);
	   return this;
   }
   
   public services EnterAccountsContactsPage() throws IOException {
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_Accounts_TextBox"), "Harika1", wd);
	   return this;
   }
   
   public services EnterEmailContactsPage() throws IOException {
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_Email_TextBox"), "abcd@gmail.com", wd);
	   return this;
   }
   
   public services EnterPhoneContactsPage() throws IOException {
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_PhoneNumber_TextBox"), "1234", wd);
	   return this;
   }
   
   public services EnterAddressContactsPage() throws IOException {
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_Street_TextBox"), "kphb", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_City_TextBox"), "hyd", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_state_TextBox"), "TS", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_PostalCode_TextBox"), "1234", wd);
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_country_TextBox"), "India", wd);
	   return this;
   }
   
   public services ClickDoNotDisturbCheckBOx() throws IOException {
	   CommonUtils.clickRadioButton("css", pageobj.getpageObjects().getProperty("crm_contacts_DoNotDisturb_CheckBox"), wd);
	   return this;
   }
   
   public services EnterDescriptionContactsPage() throws IOException {
	   CommonUtils.insertText("css", pageobj.getpageObjects().getProperty("crm_contacts_Description_TextBox"), "Description entered here", wd);
	   return this;
   }
   
   public services ClickSaveButtonContactsPage() throws IOException {
	   CommonUtils.clickButton("css", pageobj.getpageObjects().getProperty("crm_contacts_Save_Button"),wd);
	   return this;
   }
   
   
   
    
    
}
