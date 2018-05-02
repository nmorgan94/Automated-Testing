package com.qa.selenium;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class automationTest {
	
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
	public void test() throws InterruptedException {
		
//		String search = "blouse";
//		String url = "http://automationpractice.com​";
//		
//		driver.manage().window().maximize();
//		driver.get(url);
//		
//		WebElement searchBar = driver.findElement(By.name
//				("search_query"));
//		
//		searchBar.sendKeys(search);
//		searchBar.submit();
//		
//		WebElement image = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
//		
//		image.click();
//		
//		Thread.sleep(2000);
//		
//		List<WebElement> addToCart = driver.findElements(By.xpath("//*[@id=\"add_to_cart\"]/button"));
//		System.out.println(addToCart.size());	
//		WebElement addToCartbtn = driver.findElement(By.tagName("span"));
//		addToCartbtn.click();
//		Thread.sleep(3000);
		
//		String url = "http://automationpractice.com​";
		
//		driver.manage().window().maximize();	
		driver.get("http://automationpractice.com");
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).click();
		Select dropdown=new Select(driver.findElement(By.id("group_1")));
		dropdown.selectByVisibleText("M");
		driver.findElement(By.id("add_to_cart")).click();
		driver.findElement(By.tagName("span")).click();
		Thread.sleep(3000);
	}

}
