package com.crm.autodesk.purchaseordertest;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.crm.autodesk.genericlib.ExcelUtility;
	import com.crm.autodesk.genericlib.FileUtility;
	import com.crm.autodesk.genericlib.JavaUtils;
	import com.crm.autodesk.genericlib.WebDriverUtiles;
	import com.crm.autodesk.objectrrepositorylib.CreateNewPurchaseOrder;
	import com.crm.autodesk.objectrrepositorylib.Home;
	import com.crm.autodesk.objectrrepositorylib.Login;
	import com.crm.autodesk.objectrrepositorylib.More;
	import com.crm.autodesk.objectrrepositorylib.PurchaseInfo;
	import com.crm.autodesk.objectrrepositorylib.PurchaseOrder;


	/**
	 * 
	 * @author Abhijith
	 *
	 */

public class CreatePurchaseOrder_tc2 { 
		/* object  Creation*/
		JavaUtils jLib = new JavaUtils();
		WebDriverUtiles wLib = new WebDriverUtiles();
		FileUtility flib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		@Test
		
	public void M1() throws Throwable {
			
			/* Common Data */
			
			int randomNum   = jLib.generateRandomNum();
			
			String USERNAME = flib.getPropertyKeyValue("username");
			String PASSWORD = flib.getPropertyKeyValue("password");
			String URL      = flib.getPropertyKeyValue("url");
			String BROWSER  = flib.getPropertyKeyValue("browser");

			/* test Data */
			
			 String productname       =eLib.getExcelData("Contact", "tc_04", "productname");
			 String shippingAddress   =eLib.getExcelData("Contact", "tc_04","ShippingAddress")+ randomNum;
			
			
			 /*String Group            =eLib.getExcelData("Contact", "tc_04", "Assigned to");*/
			 
			 String Subject          =eLib.getExcelData("Contact", "tc_04", "subject");
			 String VendorName       =eLib.getExcelData("Contact", "tc_04", "Vendor Name");
			 String qty                     =eLib.getExcelData("Contact", "tc_04", "qty");
			 
			 /* BROWSER*/
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("firefox")) {
					driver= new FirefoxDriver();  
				}else if(BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				}else if(BROWSER.equalsIgnoreCase("ie")) {
					driver = new InternetExplorerDriver();
				}

				wLib.waitForHTMLDOM(driver);
				driver.get(URL);

			 /* step 1 : login to APP */
				Login lp = new Login(driver);
				lp.loginToApp(USERNAME, PASSWORD);
	  
				
			  /* step 2 : navigate to more page */
				Home h=new Home(driver);
		        h.getMorelink().click();
				
		        /* step 3 : navigate to purchase order page in more link */
		        More m= new More(driver);
		        wLib.waitforElementToBeClickable(driver, m.getpurchaseOrderLinkInMORE());
		        m.getpurchaseOrderLinkInMORE().click();

				/* step 4 : navigate to create new purchase order page */
				PurchaseOrder po=new PurchaseOrder(driver);
				po.getCreatePurchaseimg().click();
				
		        /*test case 1: */
				
				/* step  5: create new purchase order with Subject & VendorName, status, bill address,prodName,radio btn */
		        
				CreateNewPurchaseOrder cnp=new CreateNewPurchaseOrder(driver);
				cnp.createPurchase(driver, Subject, VendorName, shippingAddress, productname,qty);
					
				/*verify  created*/
				
				PurchaseInfo pf = new PurchaseInfo(driver);
				String scsmsg=pf.getSuccessFullMsg().getText();
				
				Assert.assertTrue(scsmsg.contains(Subject));
				Assert.assertTrue(scsmsg.contains(Subject));
				
			/*	String scsmsgAssigned=pf.getSuccessfulSupportGroup().getText();*/
		
			/*	Assert.assertTrue(scsmsgAssigned.contains(Group));*/
				/* step 6 : logout & close */
				h.logout();
			
	}}

