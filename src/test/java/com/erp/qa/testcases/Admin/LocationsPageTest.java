package com.erp.qa.testcases.Admin;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.LocationsPage;
import com.erp.qa.util.TestUtil;

public class LocationsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	LocationsPage locationsPage;
	String sheetname="Locations";
	
	public LocationsPageTest()
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
		locationsPage = homePage.clickOnLocationsLink();
		//homePage.ClickOnNatureofBusinessTab();
		Thread.sleep(3000);
		System.out.println("I am in Locations List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateLocation(String LocType, String Name, String ShortForm, String Address, String DivisionName, String DivisionType, String Value) throws InterruptedException
	{
		Thread.sleep(2000);
		locationsPage.CreateLocation(LocType, Name, ShortForm, Address, DivisionName, DivisionType, Value);
	}
	
	@Test(priority=2,dataProvider="getTreaTestData")
	public void VerifySearchedLocation(String LocType, String Name, String ShortForm, String Address, String DivisionName, String DivisionType, String Value) throws InterruptedException
	{
		Thread.sleep(2000);
		String searchedText= locationsPage.SearchedLocation(Name);
		Assert.assertEquals(searchedText, Name,"Searched locationed not found");
		System.out.println("Location verified successfully");
		
	}
	
	@Test(priority=3,dataProvider="getTreaTestData")
	public void DeleteLocation(String LocType, String Name, String ShortForm, String Address, String DivisionName, String DivisionType, String Value) throws InterruptedException
	{
		Thread.sleep(2000);
		locationsPage.DeleteLocation(Name);
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
