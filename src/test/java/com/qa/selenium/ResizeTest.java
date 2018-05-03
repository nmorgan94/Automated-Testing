package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.qa.selenium.ActionsTest.Browser;

public class ResizeTest{
	

	
	WebDriver driver;
	
	Actions action;

	String URL = "http://demoqa.com/resizable/";
	
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
						driver = new FirefoxDriver(); 
						break;
		}
		action = new Actions(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(URL);
		Resize page = PageFactory.initElements(driver, Resize.class);
		page.resize(action);
		Thread.sleep(3000);
	}

}
