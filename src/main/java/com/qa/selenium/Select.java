package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Select {
	


	@FindBy(how = How.XPATH, using = "//*[@id=\"selectable\"]/li[7]")
	private WebElement select;

	
	public void select(Actions action) {
		action.moveToElement(select).click().clickAndHold().moveByOffset(0, -150).perform();
	}

}