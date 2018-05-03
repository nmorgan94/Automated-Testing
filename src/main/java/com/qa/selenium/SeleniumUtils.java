package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class SeleniumUtils {

		
		public enum Browser {
		    CHROME,
		    FIREFOX
		}
		

	
		public WebDriver setDriver(String choice) {
			
			WebDriver driver = null;
			
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, 0);
			
			Browser browser = Browser.FIREFOX;
			
			if(choice == "FIREFOX") {
				 browser = Browser.FIREFOX;
			} else{
			     browser = Browser.CHROME;
			}
		
			switch (browser) {
		    case CHROME   : System.setProperty("webdriver.chrome.driver", "C:/Development/chromedriver.exe");
							driver = new ChromeDriver();
							break;
		    case FIREFOX : 	System.setProperty("webdriver.gecko.driver", "C:/Development/geckodriver.exe");
							driver = new FirefoxDriver(); 
							break;
			}
			return driver;

		}
		

	
}
