package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadWriteFromFile {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = "C:\\Users\\Admin\\Desktop\\excel\\TestData.xlsx";
	
	public enum Browser {
	    CHROME,
	    FIREFOX
	}
	
	Browser browser = Browser.FIREFOX;

	@Before
	public void setUp() {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, 0);
	
		switch (browser) {
	    case CHROME   : System.setProperty("webdriver.chrome.driver", "C:/Development/chromedriver.exe");
						driver = new ChromeDriver();
						break;
	    case FIREFOX : 	System.setProperty("webdriver.gecko.driver", "C:/Development/geckodriver.exe");
						driver = new FirefoxDriver();; 
						break;
		}
		
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\DDT.html");
		test = report.startTest("StartingTest");
	}

	@Test
	public void excelTest() throws InterruptedException, IOException {

		FileInputStream file = null;
		file = new FileInputStream(LoginData);
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();

			driver.get("http://asp.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			test.log(LogStatus.INFO, "inputting new username");

			driver.findElement(By.xpath(
					"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[3]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input"))
					.sendKeys(user);

			test.log(LogStatus.INFO, "inputting new password");

			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input"))
					.sendKeys(pass);

			test.log(LogStatus.INFO, "Saving new user");

			driver.findElement(By
					.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/input"))
					.click();

			test.log(LogStatus.INFO, "navigate to login");

			driver.findElement(By.xpath(
					"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[4]"))
					.click();
			Thread.sleep(1000);

			test.log(LogStatus.INFO, "Entering username on login screen");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input"))
					.sendKeys(user);

			test.log(LogStatus.INFO, "Entering password in login screen");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input"))
					.click();
			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input"))
					.sendKeys(pass);

			test.log(LogStatus.INFO, "Saving login, testing if it exists");

			driver.findElement(By
					.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input"))
					.click();

			String title = driver.findElement(By.xpath("/html/body/big/blockquote/blockquote/div/h2/font/center/b"))
					.getText();

			String expected = "**Successful Login**";
			assertEquals(expected, title);
			
			test.log(LogStatus.PASS, "Successfully created a "
					+ " and logged in with it");
			
			test.log(LogStatus.INFO, "Writing to Spreadsheet");
			
			ExcelUtils.setCellData("Pass fi", i, 2);
			
			String actual = ExcelUtils.getCellData(i, 2);
			assertEquals("Pass fi", actual);
			test.log(LogStatus.PASS, "Successfully written to spreadsheet");

			Thread.sleep(1000);

		}
	}

	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();

	}

}