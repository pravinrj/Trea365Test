package com.erp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.BusinessNaturePage;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.util.TestUtil;

public class BusinessNaturePageTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	BusinessNaturePage businessNaturePage;
	String sheetname= "Buisness";
	
	public BusinessNaturePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnAdminTab();
		businessNaturePage = homePage.clickOnNatureofBusinessLink();
		Thread.sleep(3000);
		System.out.println("I am in Business Type List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateBusinessTypeTest(String BUType, String ServiceType, String ServiceDef, String Price) throws InterruptedException
	{
		businessNaturePage.CreateNewBusinessType(BUType, ServiceType, ServiceDef, Price);
		
	}
	
	@Test(priority=2,dataProvider="getTreaTestData")
	public void VerifySearchBuType(String BUType, String ServiceType, String ServiceDef, String Price) throws InterruptedException
	{
		Thread.sleep(3000);
		String SearchedText=businessNaturePage.SearchedBuType(BUType);
		Assert.assertEquals(SearchedText, BUType,"Searched text not matched");
	}
	
	@Test(priority=3,dataProvider="getTreaTestData")
	public void EditBusinessTypeTest(String BUType, String ServiceType, String ServiceDef, String Price) throws InterruptedException
	{
		Thread.sleep(3000);
		String SearchedText=businessNaturePage.EditBuType(BUType,"TestBUNew");
		Assert.assertEquals(SearchedText, "TestBUNew","Edited BU text not matched:");
	}
	@Test(priority=4,dataProvider="getTreaTestData")
	public void DeleteBuTypeTest(String BUType, String ServiceType, String ServiceDef, String Price) throws InterruptedException
	{
		Thread.sleep(3000);
		businessNaturePage.DeleteBuType(BUType);
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
