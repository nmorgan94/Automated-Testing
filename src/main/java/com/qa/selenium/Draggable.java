package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Draggable {

	@FindBy(how = How.XPATH, using = "//*[@id=\"draggable\"]")
	private WebElement draggable;

	
	public void drag(Actions action) {
		action.moveToElement(draggable).clickAndHold().moveByOffset(300, 0).perform();
	}

}