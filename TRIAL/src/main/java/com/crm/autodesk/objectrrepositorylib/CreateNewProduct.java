package com.crm.autodesk.objectrrepositorylib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewProduct {
	
	WebDriver driver;
	WebDriverUtiles w=new WebDriverUtiles();
	
	public CreateNewProduct(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="productname" )
	private WebElement prodname;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']" )
	private WebElement savebtn;
	
	public void createProduct(WebDriver driver,String prodName) {
		Products p=new Products(driver);
		WebElement pr = p.getAddbutn();
		w.waitforElementToBeClickable(driver,pr);
		pr.click();
		prodname.sendKeys(prodName);
		savebtn.click();
	}	
}
