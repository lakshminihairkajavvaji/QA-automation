package com.crm.data;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class data {
	public HSSFSheet CrmData() throws IOException {
		FileInputStream dfis = new FileInputStream("src//test//CrmDataExcel.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(dfis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		return sheet;
		
	}
	

}
