package com.erp.qa.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.SuppliersPage;
import com.erp.qa.util.TestUtil;

public class SuppliersPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SuppliersPage supplierpage;
	String sheetname= "Supplier";
	
	
	public SuppliersPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		Thread.sleep(4000);
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		Thread.sleep(4000);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		supplierpage = homePage.clickOnSupplierLink();
		Thread.sleep(5000);
		System.out.println("I am in Supplier List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateSupplier(String SupplierType, String Name, String Address1, String Address2, String Country, String Province, String City, String PostalCode, String Email, String PhoneNumber, String Comment, String NewName) throws InterruptedException
	{
		Thread.sleep(3000);
		supplierpage.CreateNewSupplier(SupplierType, Name, Address1, Address2, Country, Province, City, PostalCode, Email, PhoneNumber, Comment);
		System.out.println("New manufacture created successfully");
	}
	
	@DataProvider
	public Object[][] getTreaTestData()
	{
		Object data[][]=testUtil.getTestData(sheetname);
		return data;
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
