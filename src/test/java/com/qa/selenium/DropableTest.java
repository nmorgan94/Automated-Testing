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




public class DropableTest{
	
	SeleniumUtils utils = new SeleniumUtils();
	
	WebDriver driver;
	
	Actions action;

	String URL = "http://demoqa.com/droppable//";
	


	@Before
	public void setUp() {
		driver = utils.setDriver("FIREFOX");
		action = new Actions(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(URL);
		Dropable page = PageFactory.initElements(driver, Dropable.class);
		page.drop(action);
		Thread.sleep(3000);
	}

}
