package com.crm.autodesk.objectrrepositorylib;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	WebDriver driver;
	public Logout(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']" )
	private WebElement userIcon;
	
	@FindBy(linkText = "Sign Out" )
	private WebElement logoutLink;
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	
}
