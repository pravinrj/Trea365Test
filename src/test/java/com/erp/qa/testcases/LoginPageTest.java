package com.erp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		//System.out.println(title);
		Assert.assertEquals(title, "Trea365");
		
	}

	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void InvalidloginTest(){
		String ErrorMsg = loginPage.InvalidUsernameMsg(prop.getProperty("invalidusername"), prop.getProperty("password"));
		
		Assert.assertEquals(ErrorMsg, "User does not exist.");
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
