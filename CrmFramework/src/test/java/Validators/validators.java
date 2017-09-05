package Validators;

import java.io.IOException;

import org.testng.Assert;

import com.crm.data.data;

import Services.services;

public class validators {
	public data crmdata = new data();
	public void validateCreateAccount(services service) throws IOException, InterruptedException {
		Assert.assertEquals(service.getNameCreatedAccount(), crmdata.CrmData().getRow(1).getCell(2).getStringCellValue());
		Assert.assertEquals(service.getEmailCreatedAccount(), crmdata.CrmData().getRow(1).getCell(3).getStringCellValue());
		Assert.assertEquals(service.getPhoneNumber(), "7799095959");
		Assert.assertEquals(service.getBillingAddress(),crmdata.CrmData().getRow(1).getCell(8).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(9).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(10).getStringCellValue()+"1234"+crmdata.CrmData().getRow(1).getCell(12).getStringCellValue());
		
		System.out.println(crmdata.CrmData().getRow(1).getCell(8).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(9).getStringCellValue()+crmdata.CrmData().getRow(1).getCell(10).getStringCellValue()+"1234"+crmdata.CrmData().getRow(1).getCell(12).getStringCellValue());
		
		
	}

}
