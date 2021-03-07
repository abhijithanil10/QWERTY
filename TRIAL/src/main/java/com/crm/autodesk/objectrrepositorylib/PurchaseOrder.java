package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrder {

	
	 public PurchaseOrder(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreatePurchaseimg;
	
	public WebElement getCreatePurchaseimg() {
		return CreatePurchaseimg;
	}
}
