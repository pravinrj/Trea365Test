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
import com.erp.qa.util.TestUtil;

public class ItemCategoriesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ItemCategoriesPage itemcategoriespage;
	String sheetname= "ItemCat";
	
	
	public ItemCategoriesPageTest()
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
		itemcategoriespage = homePage.clickOnItemCategoriesLink();
		Thread.sleep(5000);
		System.out.println("I am in Item categories List");
	}
	
	@Test(priority=1,dataProvider="getTreaTestData")
	public void CreateItemCategories(String CatName, String ItemType, String Comments, String NewComments) throws InterruptedException
	{
		Thread.sleep(3000);
		itemcategoriespage.CreateCategory(CatName, ItemType, Comments);
	}
	
	@Test(priority=2,dataProvider="getTreaTestData")
	public void VerifySearchedCategory(String CatName, String ItemType, String Comments, String NewComments) throws InterruptedException
	{
		Thread.sleep(3000);
		String searchedText= itemcategoriespage.SearchedItemCategory(CatName);
		Assert.assertEquals(searchedText, CatName, "Searched Item Catagory not found");
		System.out.println("Item category searched successfully");
	}
	
	@Test(priority=3,dataProvider="getTreaTestData")
	public void EditCategory(String CatName, String ItemType, String Comments, String NewComments) throws InterruptedException
	{
		Thread.sleep(3000);
		itemcategoriespage.EditItemCategory(CatName,NewComments);
		System.out.println("Item category updated successfully");
	}
	
	@Test(priority=4,dataProvider="getTreaTestData")
	public void DeleteCatogory(String CatName, String ItemType, String Comments, String NewCatName) throws InterruptedException
	{
		Thread.sleep(3000);
		itemcategoriespage.DeleteItemCategory(CatName);
		System.out.println("Item catgory deleted successfully");
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
