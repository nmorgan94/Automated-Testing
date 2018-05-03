package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Resize {

	@FindBy(how = How.XPATH, using = "//*[@id=\"resizable\"]/div[3]")
	private WebElement resize;

	
	public void resize(Actions action) {
		action.moveToElement(resize).click().clickAndHold().moveByOffset(300, 0).perform();
	}

}