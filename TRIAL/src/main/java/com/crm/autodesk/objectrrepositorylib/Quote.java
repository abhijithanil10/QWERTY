package com.crm.autodesk.objectrrepositorylib;
	

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quote {

	 public Quote(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//img[@alt='Create Quote...']")
	private WebElement createQuoteimg;
	
	public WebElement getCreateQuoteimg() {
		return createQuoteimg;
	}
}
