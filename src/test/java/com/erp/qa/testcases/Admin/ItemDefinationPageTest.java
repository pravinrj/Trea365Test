package com.erp.qa.testcases.Admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.ItemDefinationPage;
import com.erp.qa.util.TestUtil;

public class ItemDefinationPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ItemDefinationPage itemdefinationpage;
	String sheetname="ItemDef";
	
	public ItemDefinationPageTest()
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
		Thread.sleep(3000);
		//ItemDefinationPage = homePage.clickOnItemDefinationLink();
		homePage.ClickonItemDefLink();
		Thread.sleep(3000);
		System.out.println("I am in Item Defination List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateItemDefTest(String ItemCategory, String Mfg, String ItemDefNo, String UPC, String FullName, String ShortName, String UOM, String AttributeLabel, String AttributeData) throws InterruptedException
	{
		itemdefinationpage.CreateItemDef(ItemCategory, Mfg, ItemDefNo, UPC,FullName,ShortName,UOM,AttributeLabel,AttributeData);
		
	}
	
	@DataProvider
	public Object[][] getTreaTestData()
	{
		Object data[][]=testUtil.getTestData(sheetname);
		return data;
	}
	
}



