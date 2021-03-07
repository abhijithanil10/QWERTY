package com.crm.autodesk.purchaseordertest;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import com.crm.autodesk.genericlib.BaseClass;

import com.crm.autodesk.objectrrepositorylib.CreateNewPurchaseOrder;
import com.crm.autodesk.objectrrepositorylib.Home;

import com.crm.autodesk.objectrrepositorylib.More;
import com.crm.autodesk.objectrrepositorylib.PurchaseInfo;
import com.crm.autodesk.objectrrepositorylib.PurchaseOrder;

public class CreateNewPurchaseOrder_tc1Trial extends BaseClass{
	
	
	


	@Test(groups = "smokeTest")
	
public void m1() throws Throwable {
		/* Common Data */
		
		int randomNum   = jLib.generateRandomNum();
	
		/* test Data */
		
		 String productname       =eLib.getExcelData("Contact", "tc_04", "productname");
		 String billingAddress    =eLib.getExcelData("Contact", "tc_04", "BillingAddress")+ randomNum;
		
		
		 /*String Group            =eLib.getExcelData("Contact", "tc_04", "Assigned to");*/
		 
		 String Subject          =eLib.getExcelData("Contact", "tc_04", "subject");
		 String VendorName       =eLib.getExcelData("Contact", "tc_04", "Vendor Name");

			
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
			cnp.creatPurchase(driver, Subject, VendorName, billingAddress, productname);
				
			/*verify  created*/
			
			PurchaseInfo pf = new PurchaseInfo(driver);
			String scsmsg=pf.getSuccessFullMsg().getText();
			
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
			
	
}
	
@Test(groups = "smokeTest")
	
	public void m2() throws Throwable {
		
		/* Common Data */
		
		int randomNum   = jLib.generateRandomNum();
		
		/* test Data */
		
		 String productname       =eLib.getExcelData("Contact", "tc_04", "productname");
		 String shippingAddress   =eLib.getExcelData("Contact", "tc_04","ShippingAddress")+ randomNum;
		
		
		 /*String Group            =eLib.getExcelData("Contact", "tc_04", "Assigned to");*/
		 
		 String Subject          =eLib.getExcelData("Contact", "tc_04", "subject");
		 String VendorName       =eLib.getExcelData("Contact", "tc_04", "Vendor Name");
		 String qty                     =eLib.getExcelData("Contact", "tc_04", "qty");

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
			
			/* step  5: create new purchase order with Subject & VendorName, status, bill address,prodName,radio btn */
	        
			CreateNewPurchaseOrder cnp=new CreateNewPurchaseOrder(driver);
			cnp.createPurchase(driver, Subject, VendorName, shippingAddress, productname,qty);
				
			/*verify  created*/
			
			PurchaseInfo pf = new PurchaseInfo(driver);
			String scsmsg=pf.getSuccessFullMsg().getText();
			
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
			
		/*	String scsmsgAssigned=pf.getSuccessfulSupportGroup().getText();*/
	
		/*	Assert.assertTrue(scsmsgAssigned.contains(Group));*/
			/* step 6 : logout & close */
		
		
}

@Test(groups = "regressionTest")


public void m3() throws Throwable {
		
		/* Common Data */
		
		int randomNum   = jLib.generateRandomNum();
		
	

		/* test Data */
		
		 String productname       =eLib.getExcelData("Contact", "tc_04", "productname");
		 String billingAddress    =eLib.getExcelData("Contact", "tc_04", "BillingAddress")+ randomNum;
		 String shippingAddress   =eLib.getExcelData("Contact", "tc_04","ShippingAddress")+ randomNum;
		
		
		 /*String Group            =eLib.getExcelData("Contact", "tc_04", "Assigned to");*/
		 
		 String Subject          =eLib.getExcelData("Contact", "tc_04", "subject");
		 String VendorName       =eLib.getExcelData("Contact", "tc_04", "Vendor Name");
		 String qty                     =eLib.getExcelData("Contact", "tc_04", "qty");
		 
	
			
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
			cnp.createPurchase_sb(driver, Subject, VendorName, billingAddress, shippingAddress, productname,qty);
				
			/*verify  created*/
			
			PurchaseInfo pf = new PurchaseInfo(driver);
			String scsmsg=pf.getSuccessFullMsg().getText();
			
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
			AssertJUnit.assertTrue(scsmsg.contains(Subject));
		
			/* step 6 : logout & close */
		
}


}

