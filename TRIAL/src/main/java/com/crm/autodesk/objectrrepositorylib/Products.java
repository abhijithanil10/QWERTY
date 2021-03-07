package com.crm.autodesk.objectrrepositorylib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {


	 public Products(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	 
	@FindBy(xpath =  "//img[@alt='Create Product...']")
	private WebElement addbutn;
	
	public WebElement getAddbutn() {
		return addbutn;
	}
	
	
	
}

