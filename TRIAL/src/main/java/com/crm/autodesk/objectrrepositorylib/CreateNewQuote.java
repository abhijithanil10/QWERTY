package com.crm.autodesk.objectrrepositorylib;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.crm.autodesk.genericlib.WebDriverUtiles;

	public class CreateNewQuote {
		 WebDriver driver;
		 WebDriverUtiles w=new WebDriverUtiles();

		public CreateNewQuote(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name = "subject")
		private WebElement subjectEdt;
		
		@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img")
		private WebElement contactImg;
		
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	    private WebElement organiztionImg;
		
		@FindBy(xpath = "//textarea[@name='bill_street']")
	    private WebElement billingEdt;
		
		@FindBy(xpath = "//b[.='Copy Billing address']/preceding-sibling::input[@name='cpy']")
	    private WebElement copyBillingToshipng;
		
		@FindBy(xpath = "//input[@name='productName1']/following-sibling::img")
	    private WebElement itemNameEdt;
		
		@FindBy(name = "qty1")
	    private WebElement itemCountEdt;
		
		@FindBy(id = "productName1")
	    private WebElement productName;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn;
		
		@FindBy(id = "search_txt")
	    private WebElement searchone;
		
		@FindBy(name = "search")
	    private WebElement searchoneA;
		

		public WebElement getSearchone() {
			return searchone;
		}

		public WebElement getSubjectEdt() {
			return subjectEdt;
		}

		public WebElement getContactImg() {
			return contactImg;
		}

		public WebElement getOrganiztionImg() {
			return organiztionImg;
		}

		public WebElement getBillingEdt() {
			return billingEdt;
		}

		public WebElement getCopyBillingToshipng() {
			return copyBillingToshipng;
		}

		public WebElement getItemNameEdt() {
			return itemNameEdt;
		}

		public WebElement getItemCountEdt() {
			return itemCountEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
	    
	public void creatQuote(String SUBJECT ) {
			
			subjectEdt.sendKeys(SUBJECT);
	}
		
	public void creatQuote(WebDriver driver,String contLastNAme ,String SUBJECT,String orgName ,String billaddress,String prodName) {
		//subject
	    subjectEdt.sendKeys(SUBJECT); 
		contactImg.click();
		//contact name
		w.swicthToWindow(driver, "Contacts&action");
		w.waitforElementToBeClickable(driver,searchone );
		searchone.sendKeys(contLastNAme);
		searchoneA.click();
		w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+" "+contLastNAme+"']")));
		driver.findElement(By.xpath("//a[text()='"+" "+contLastNAme+"']")).click();
		w.alertOK(driver);
		w.swicthToWindow(driver, "Quotes");
		
		//organiztion name
		organiztionImg.click();
		w.swicthToWindow(driver, "Account&action");
		w.waitforElementToBeClickable(driver, searchone);
		searchone.sendKeys(orgName);
		searchoneA.click();
		w.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='"+orgName+"']")));
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		w.alertOK(driver);
		w.swicthToWindow(driver, "Quotes");
		
		//billaddress
		billingEdt.sendKeys(billaddress);
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

		
	}

