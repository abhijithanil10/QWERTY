package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewPurchaseOrder {
	 WebDriver driver;
	 WebDriverUtiles w=new WebDriverUtiles();

	public CreateNewPurchaseOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath = "//input[@name='vendor_id']/following-sibling::img")
	private WebElement vendorNameImg;
	
	@FindBy(xpath = "//select[@name='postatus']")
    private WebElement statusBox;
	
	
	
	
	public WebElement getStatusBox() {
		return statusBox;
	}

	@FindBy(xpath = "//textarea[@name='bill_street']")
    private WebElement billingEdt;
	
	@FindBy(name="ship_street")
	private WebElement shippingEdt;
	
	@FindBy(xpath = "//b[.='Copy Billing address']/preceding-sibling::input[@name='cpy']")
    private WebElement copyBillingToshipng;
	
	@FindBy(xpath = "//b[.='Copy Shipping address']/preceding-sibling::input[@onclick='return copyAddressLeft(EditView)']")
	  private WebElement copyShippingToBilling;
	
	@FindBy(xpath = "//input[@name='productName1']/following-sibling::img")
    private WebElement itemNameEdt;
	
	@FindBy(name = "qty1")
    private WebElement itemCountEdt;
	
	@FindBy(id = "productName1")
    private WebElement productName;
	
	@FindBy(xpath = "//input[@value='U']")
    private WebElement radioUser;
	
	@FindBy(xpath = "//input[@value='T']")
    private WebElement radioGroup;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}


	public WebElement getVendorNameImg() {
		return vendorNameImg;
	}
	
	@FindBy(id = "search_txt")
    private WebElement searchone;
	
	@FindBy(name = "search")
    private WebElement searchoneA;
	

	public WebElement getSearchoneA() {
		return searchoneA;
	}


	public WebElement getSearchone() {
		return searchone;
	}


	public WebElement getBillingEdt() {
		return billingEdt;
	}

	public WebElement getShippinggEdt() {
	return shippingEdt;
	}
	public WebElement getCopyBillingToshipng() {
		return copyBillingToshipng;
		}
	public WebElement getcopyShippingToBilling() {
		return copyShippingToBilling;
		}
		
	

	public WebElement getItemNameEdt() {
		return itemNameEdt;
	}


	public WebElement getItemCountEdt() {
		return itemCountEdt;
	}


	public WebElement getProductName() {
		return productName;
	}


	public WebElement getRadioUser() {
		return radioUser;
	}


	public WebElement getRadioGroup() {
		return radioGroup;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void creatPurchase(WebDriver driver,String Subject ,String VendorName , String billingAddress,String prodName) {
		
		//subject
	    subjectEdt.sendKeys(Subject); 
		
		//vendor name
		vendorNameImg.click();
		w.swicthToWindow(driver, "Vendors&action");
		w.waitforElementToBeClickable(driver,searchone );
		searchone.sendKeys(VendorName);
		searchoneA.click();
		w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+""+VendorName+"']")));
		driver.findElement(By.xpath("//a[text()='"+""+VendorName+"']")).click();
		
		w.swicthToWindow(driver, "PurchaseOrder");
		
		//assign to
	/*	if(radiobtn=="User")
		  getRadioUser().clear();
		
		else if(radiobtn=="Group")
		  getRadioGroup().click();*/
		
		//bill address
		billingEdt.sendKeys(billingAddress);
		copyBillingToshipng.click();
		
		//product details
		itemNameEdt.click();
		
		productName.sendKeys(prodName);
		w.swicthToWindow(driver, "Products&action");
		w.waitforElementToBeClickable(driver, searchone);
		searchone.sendKeys(prodName);
		searchoneA.click();
		w.waitforElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"+prodName+"']")));
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		
		//product count
		w.swicthToWindow(driver, "Quotes");
		itemCountEdt.sendKeys("2");

	    //save
		saveBtn.click();

}


	public void createPurchase(WebDriver driver, String subject, String vendorName, String shippingAddress,
			String productname,String qty) {
		
			//subject
		    subjectEdt.sendKeys(subject); 
			
			//vendor name
			vendorNameImg.click();
			w.swicthToWindow(driver, "Vendors&action");
			w.waitforElementToBeClickable(driver,searchone );
			searchone.sendKeys(vendorName);
			searchoneA.click();
			w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")));
			driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")).click();
			
			w.swicthToWindow(driver, "PurchaseOrder");
			
			//shipping address
			shippingEdt.sendKeys(shippingAddress);
			copyShippingToBilling.click();
			
			//product details
			itemNameEdt.click();
			
			productName.sendKeys(productname);
			w.swicthToWindow(driver, "Products&action");
			w.waitforElementToBeClickable(driver, searchone);
			searchone.sendKeys(productname);
			searchoneA.click();
			w.waitforElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"+productname+"']")));
			driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
			
			//product count
			w.swicthToWindow(driver, "PurchaseOrder");
			itemCountEdt.sendKeys("2");

		    //save
			saveBtn.click();

	}
		

	public void createPurchase_sb(WebDriver driver, String subject, String vendorName,String billingAddress, String shippingAddress,
			String productname,String qty) {
		
			//subject
		    subjectEdt.sendKeys(subject); 
			
			//vendor name
			vendorNameImg.click();
			w.swicthToWindow(driver, "Vendors&action");
			w.waitforElementToBeClickable(driver,searchone );
			searchone.sendKeys(vendorName);
			searchoneA.click();
			w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")));
			driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")).click();
			
			w.swicthToWindow(driver, "PurchaseOrder");
			
			//bill address
			billingEdt.sendKeys(billingAddress);
			
			//shipping address
			shippingEdt.sendKeys(shippingAddress);
			
			//product details
			itemNameEdt.click();
			
			productName.sendKeys(productname);
			w.swicthToWindow(driver, "Products&action");
			w.waitforElementToBeClickable(driver, searchone);
			searchone.sendKeys(productname);
			searchoneA.click();
			w.waitforElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"+productname+"']")));
			driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
			
			//product count
			w.swicthToWindow(driver, "PurchaseOrder");
			
			itemCountEdt.sendKeys("2");

		    //save
			saveBtn.click();

	}
		
	
	

public void createPurchase_group(WebDriver driver, String subject,String Group, String vendorName,String billingAddress, String shippingAddress,
		String productname, String qty) {
	
		//subject
	    subjectEdt.sendKeys(subject); 
		
		//vendor name
		vendorNameImg.click();
		w.swicthToWindow(driver, "Vendors&action");
		w.waitforElementToBeClickable(driver,searchone );
		searchone.sendKeys(vendorName);
		searchoneA.click();
		w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")));
		driver.findElement(By.xpath("//a[text()='"+""+vendorName+"']")).click();
		
		w.swicthToWindow(driver, "PurchaseOrder");
		
		if(Group.equalsIgnoreCase("User"))
			  getRadioUser().click();
			
			else if(Group.equalsIgnoreCase("Group"))
			  getRadioGroup().click();
	
		//bill address
		billingEdt.sendKeys(billingAddress);
		
		//shipping address
		shippingEdt.sendKeys(shippingAddress);
		
		//product details
		itemNameEdt.click();
		
		productName.sendKeys(productname);
		w.swicthToWindow(driver, "Products&action");
		w.waitforElementToBeClickable(driver, searchone);
		searchone.sendKeys(productname);
		searchoneA.click();
		w.waitforElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='"+productname+"']")));
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		
		//product count
		w.swicthToWindow(driver, "PurchaseOrder");
		
		itemCountEdt.sendKeys("2");

	    //save
		saveBtn.click();

}
	
	
}
