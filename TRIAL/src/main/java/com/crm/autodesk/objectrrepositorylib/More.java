package com.crm.autodesk.objectrrepositorylib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class More {

	public More(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[.='More']" )
	private WebElement morelink;
	
	@FindBy(xpath = "//a[@name='Purchase Order']")
	private WebElement purchaseOrderLinkInMORE;
	
	@FindBy(xpath = "//a[@name='Vendors']")
	private WebElement vendorsLink;
	
	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	
	public WebElement getpurchaseOrderLinkInMORE() {
		return purchaseOrderLinkInMORE;}
	
	public WebElement getMorelink() {
		return morelink;
	}
}
