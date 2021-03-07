package com.crm.autodesk.quotetest;

import org.testng.annotations.Test;

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
import com.crm.autodesk.objectrrepositorylib.ContactInfo;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewConatct;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.CreateNewProduct;
import com.crm.autodesk.objectrrepositorylib.CreateNewQuote;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;
import com.crm.autodesk.objectrrepositorylib.Quote;
import com.crm.autodesk.objectrrepositorylib.QuoteInfo;


/**
 * 
 * @author Abhijith
 *
 */

public class CreateQuote {
	
	
		/* object  Creation*/
	
		JavaUtils jLib = new JavaUtils();
		WebDriverUtiles wLib = new WebDriverUtiles();
		FileUtility flib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();


			@Test
			public void createQuote() throws Throwable {
				/* Common Data */
				int randomNum = jLib.generateRandomNum();
				String USERNAME = flib.getPropertyKeyValue("username");
				String PASSWORD = flib.getPropertyKeyValue("password");
				String URL = flib.getPropertyKeyValue("url");
				String BROWSER = flib.getPropertyKeyValue("browser");

				/* test Data */
				String orgName = eLib.getExcelData("Contact", "tc_02", "orgName")+ randomNum;
				String orgType = eLib.getExcelData("Contact", "tc_02", "orgType");
				String orgIndustry = eLib.getExcelData("Contact", "tc_02", "orgIndustry");
				String orgRating = eLib.getExcelData("Contact", "tc_02", "orgRating");

				String contLastNAme = eLib.getExcelData("Contact", "tc_02", "contactName") + randomNum;

				String SUBJECT=eLib.getExcelData("Contact", "tc_02", "subject")+ randomNum;
				String contLastNAme1=eLib.getExcelData("Contact", "tc_02", "contactLastName")+ randomNum;
				String billingAddress=eLib.getExcelData("Contact", "tc_02", "billingAddress")+ randomNum;
				String productname=eLib.getExcelData("Contact", "tc_02", "product")+ randomNum;



				/* step 1 : login to APP */
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

				/* step 2 : navigate to Organization page */
				Home hp = new Home(driver);
				hp.getOrgLnk().click();

				/* step 3 : navigate to create Organization Page */
				Organizations orgPage = new Organizations(driver);
				orgPage.getCreateOrgImg().click();

				/* step 4 : create new Organization with industry & type, rating */
				CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
				createOrgPage.creatOrganization(orgName, orgIndustry, orgType, orgRating);

				/*verify */
				OrganizationInfo info = new OrganizationInfo(driver);
				String actSuccessfullMsg = info.getSuccessFullMsg().getText();
				Assert.assertTrue(actSuccessfullMsg.contains(orgName));

				/* step 5 :  navigate to Contact page */
				hp.getContactLnk().click();

				/* step 6 : navigate to create Contact page */
				Contacts cp = new Contacts(driver);
				cp.getCreateOrgImg().click();

				/* step 7 : create new Contact with Organization */
				CreateNewConatct cnc = new CreateNewConatct(driver);
				cnc.createConatct(contLastNAme1, orgName); 

				/*verify  notepad */
				
				/*  ContactInfo cnf = new ContactInfo(driver);
				  String actSuccessfullMsg3 =
				  cnf.getSuccessFullMSG().getText();
				  Assert.assertTrue(actSuccessfullMsg.contains(contLastNAme1));
				 
*/
		

				/* step 8 :  navigate to product page */
				Home h=new Home(driver);
				h.getProductlnk().click();
				CreateNewProduct cr=new CreateNewProduct(driver);
				cr.createProduct(driver, productname);



				/* step 9 : navigate to more page */

				h.getMorelink().click();

				/* step 10 : navigate to  quote Page */
				wLib.waitforElementToBeClickable(driver, h.getQuotelink());
				h.getQuotelink().click();

				/* step 11 : navigate to create new Quote Page */
				Quote q=new Quote(driver);
				q.getCreateQuoteimg().click();

				/* step  12: create new quote with subject & contact name, org name,product,quantity,billing address */
				CreateNewQuote create=new CreateNewQuote(driver);
				create.creatQuote(driver, contLastNAme1, SUBJECT, orgName, billingAddress, productname);

				/*verify */
				QuoteInfo qnf = new QuoteInfo(driver);
				String actSuccessfullMsg1 = qnf.getSuccessFullMsg().getText();
				Assert.assertTrue(actSuccessfullMsg1.contains(SUBJECT));

				/* step 13 : logout & close */
				h.logout();
				/*
				 * logout l=new logout(driver); wLib.moveToExpectedElemnet(driver,
				 * l.getUserIcon()); l.getLogoutLink().click();
				 */

			}

	}


