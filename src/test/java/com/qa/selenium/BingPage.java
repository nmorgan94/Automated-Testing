package com.qa.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingPage {
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchBox;
	
	WebDriver driver;

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
		
	}
	
	@Test
	public void test() {
		driver.get("http://www.bing.com/");
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("Muse");
	}


	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
	}
	

}
