package com.crm.autodesk.objectrrepositorylib;	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class PurchaseInfo {
		public PurchaseInfo(WebDriver driver) {             
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		  private WebElement successFullMsg;

		@FindBy(xpath = "//font[.='Delivered']")
		  private WebElement successfulltestcase1;
		
		@FindBy(xpath = "//a[.='Support Group']")
			private WebElement successfulSupportGroup;
		
		@FindBy(xpath = "//a[.='Team Selling ']")
			private WebElement successfulTeamSelling;
		
		public WebElement getSuccessfulSupportGroup() {
			return successfulSupportGroup;
		}

		
		public WebElement getSuccessfulTeamSelling() {
			return successfulTeamSelling;
		}

		
		public WebElement getSuccessfulltestcase1() {
			return successfulltestcase1;
		}

		public WebElement getSuccessFullMsg() {
			return successFullMsg;
		}
	}
