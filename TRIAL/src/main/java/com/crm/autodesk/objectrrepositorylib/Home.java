package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author Deepak , Nithish
 *
 */

public class Home  extends WebDriverUtiles{
	WebDriver driver;
	public Home(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	public WebElement getProductlnk() {
		return productlnk;
	}

	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	
	@FindBy(linkText = "Products")
    private WebElement productlnk;
	
	@FindBy(xpath = "//a[.='More']" )
	private WebElement morelink;
	
	@FindBy(xpath = "//a[@name='Quotes']" )
	private WebElement quotelink;
	
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
			private WebElement purchaseOrderlink;
	
	
	public WebElement getpurchaseOrderlink() {
		return purchaseOrderlink;
	}

	
	public WebElement getQuotelink() {
		return quotelink;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	
	public WebElement getMorelink() {
		return morelink;
	}

	public void logout() {
		moveToExpectedElemnet(driver, adminstrationImg);
		signOutLnk.click();
	}
		
	
	}