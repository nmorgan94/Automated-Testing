package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Sortable {

	@FindBy(how = How.XPATH, using = "//*[@id=\"sortable\"]/li[1]")
	private WebElement sortable;

	
	public void sort(Actions action) {
		action.moveToElement(sortable).click().dragAndDropBy(sortable, 0, 150).perform();
	}

}