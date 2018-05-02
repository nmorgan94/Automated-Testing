package com.qa.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI {

	@Test
	public void method() {
	
		FileInputStream file = null;
		try {
			file = new FileInputStream (Constant.Path_TestData + Constant.File_TestData);
		} catch (FileNotFoundException e) {
			System.out.println("first try");
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			System.out.println("second try");
		}
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell cell = sheet.getRow(0).getCell(0);
		System.out.println(cell.getStringCellValue());
	
	}
}

