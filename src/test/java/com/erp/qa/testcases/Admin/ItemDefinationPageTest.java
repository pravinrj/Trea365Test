package com.erp.qa.testcases.Admin;

import org.testng.annotations.BeforeMethod;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.ItemDefinationPage;
import com.erp.qa.util.TestUtil;

public class ItemDefinationPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetname="Item Def";
	
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
		//homePage.ClickOnNatureofBusinessTab();
		Thread.sleep(3000);
		System.out.println("I am in Item Defination List");
	}
	
}



