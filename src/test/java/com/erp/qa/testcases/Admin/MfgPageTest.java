package com.erp.qa.testcases.Admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.ItemCategoriesPage;
import com.erp.qa.pages.Admin.MfgPage;
import com.erp.qa.util.TestUtil;

public class MfgPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MfgPage mfgpage;
	String sheetname= "Mfg";
	
	
	public MfgPageTest()
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
		mfgpage = homePage.clickOnMfgLink();
		Thread.sleep(5000);
		System.out.println("I am in Manufacture List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateMfg(String FullName, String Comment, String NewComment) throws InterruptedException
	{
		Thread.sleep(3000);
		mfgpage.createMfg(FullName, Comment);
		System.out.println("New manufacture created successfully");
	}
	@Test(priority=2,dataProvider="getTreaTestData")
	public void VerifySearchedMfg(String FullName, String Comment, String NewComment) throws InterruptedException
	{
		Thread.sleep(3000);
		String searchedtext=mfgpage.searchMfg(FullName);
		Assert.assertEquals(searchedtext, FullName, "Searched Mfg name mismatch");
		System.out.println("Mfg name surched successfully");
	}
	
	@Test(priority=3,dataProvider="getTreaTestData")
	public void VerifyEditMfg(String FullName, String Comment, String NewComment) throws InterruptedException
	{
		Thread.sleep(3000);
		mfgpage.EditMfg(FullName, NewComment);
		System.out.println("Mfg udated successfully");
	}
	@Test(priority=4,dataProvider="getTreaTestData")
	public void VerifyDeleteMfg(String FullName, String Comment, String NewComment) throws InterruptedException
	{
		Thread.sleep(3000);
		mfgpage.DeleteMfg(FullName);
		System.out.println("Mfg Deleted successfully");
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
