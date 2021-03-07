package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;	

public class CreateNewVendors {
	
	 WebDriver driver;
	 WebDriverUtiles w=new WebDriverUtiles();

	public CreateNewVendors(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "vendorname")
	private WebElement vendorname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

	public WebElement getVendorname() {
		return vendorname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createvendor(String name) {
		vendorname.sendKeys(name);
		
		saveBtn.click();
	}
}