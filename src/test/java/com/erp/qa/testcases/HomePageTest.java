package com.erp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.BusinessNaturePage;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	BusinessNaturePage businessNaturePage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Summary","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyNatureOfBusinessLinkTest(){
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		businessNaturePage = homePage.clickOnNatureofBusinessLink();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
