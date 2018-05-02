package com.qa.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.selenium.DDTReadWriteFromFile.Browser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Actionstt {

	WebDriver driver;
	
	
	
	Actions action;

	String URL = "http://demoqa.com/";
	
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
		action = new Actions(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();

	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get(URL);
		
		driver.findElement(By.xpath(
				"//*[@id=\"menu-item-140\"]/a"))
				.click();
		
		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		
		action.moveToElement(draggable).clickAndHold().moveByOffset(300, 0).perform();
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-141\"]/a")).click();
		
		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"draggableview\"]/p"));
		
		
		
		
		
		
		Thread.sleep(2000);
	}


}
