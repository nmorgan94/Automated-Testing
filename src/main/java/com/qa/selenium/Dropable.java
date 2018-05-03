package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Dropable {

	@FindBy(how = How.XPATH, using = "//*[@id=\"draggableview\"]")
	private WebElement dropable;

	
	public void drop(Actions action) {
		action.moveToElement(dropable).click().clickAndHold().moveByOffset(150, 0).perform();
	}

}