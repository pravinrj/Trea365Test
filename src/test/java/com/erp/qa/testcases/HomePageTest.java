package com.erp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.HomePage;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.pages.Admin.BusinessNaturePage;
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
	public void verifyNatureOfBusinessURLTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetNatureofBusinessPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/business-nature", "URL not match");
		
	}
	
	@Test(priority=4)
	public void verifyLocationsURLTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetLocationsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/location-list", "URL not match");
		}
	@Test(priority=5)
	public void verifyMFGURLTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetMFGPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/manufacturer", "URL not match");
		}
	@Test(priority=6)
	public void verifyItemDefinitionTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetItemDefinitionPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/manufacturer-part", "URL not match");
		}
	@Test(priority=7)
	public void verifyItemCategoriesTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetItemCategoriesPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/item-classes", "URL not match");
		}
	@Test(priority=8)
	public void verifySuppliersTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetSuppliersPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/supplier-list", "URL not match");
		}
	@Test(priority=9)
	public void verifyPermissionsTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetPermissionsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/role-list", "URL not match");
		}
		
	@Test(priority=10)
	public void verifyLabelsTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnAdminTab();
		Thread.sleep(3000);
		String url= homePage.GetLabelsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/print-label", "URL not match");
		}

	/*@Test(priority=11)
	public void verifyProductsTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetProductsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/product-list", "URL not match");
		}
	@Test(priority=12)
	public void verifyAssetsTest() throws InterruptedException{

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetAssetsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/asset-list", "URL not match");
		}
	@Test(priority=13)
	public void verifyMaterialTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetMaterialPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/material-list", "URL not match");
		}
	@Test(priority=14)
	public void verifyMaintenanceTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetMaintenancePageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/maintenance-list", "URL not match");
		}
	@Test(priority=15)
	public void verifyPurchaseOrderTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetPurchaseOrdersPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/purchase-order-list", "URL not match");
		}
	
	@Test(priority=16)
	public void verifyRecievingSlipsTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetRecievingSlipsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/receiving-slips-list", "URL not match");
		}
	
	@Test(priority=17)
	public void verifyAuditTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnInventoryTab();
		Thread.sleep(3000);

		String url= homePage.GetAuditPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/inventory/audit-list", "URL not match");
		}
	
	//WorkflowTab  WorkOrders Scheduling
	
	@Test(priority=18)
	public void verifyProjectEstimatorTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnWorkflowTab();

		Thread.sleep(3000);

		String url= homePage.GetProjectEstimatorPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/quotation-list", "URL not match");
		}
	@Test(priority=19)
	public void verifyWorkOrdersTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnWorkflowTab();

		Thread.sleep(3000);
		String url= homePage.GetWorkOrdersPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/work-order-list", "URL not match");

		}
	
	@Test(priority=20)
	public void verifySchedulingTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnWorkflowTab();
		Thread.sleep(3000);
		String url= homePage.GetSchedulingsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/schedule-list", "URL not match");
		}

	@Test(priority=21)
	public void verifyCRMTest() throws InterruptedException{
		//testUtil.switchToFrame();
		homePage.clickOnCRMLink();

		Thread.sleep(4000);
	
		

		String url= homePage.GetCRMPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/crm/csa/client-list", "URL not match");
		}
	//Employees SubContractor Timesheets HRTab
	@Test(priority=22)
	public void verifyEmployeesTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnHRTab();
		Thread.sleep(3000);
		String url= homePage.GetEmployeesPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/employee-list", "URL not match");

		}
	@Test(priority=23)
	public void verifySubContractorTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnHRTab();
		Thread.sleep(3000);
		String url= homePage.GetSubContractorPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/sub-contractor-list", "URL not match");

		}
	@Test(priority=24)
	public void verifyTimesheetsTest() throws InterruptedException{
		//testUtil.switchToFrame();

		homePage.clickOnHRTab();
		Thread.sleep(3000);
		String url= homePage.GetTimesheetsPageURL();
		Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/timesheet-list", "URL not match");

		}
	
	
		@Test(priority=25)
		public void verifyPaymentSchedulesTest() throws InterruptedException{
			//testUtil.switchToFrame();

			homePage.clickOnAccountingTab();
			Thread.sleep(3000);
			String url= homePage.GetPaymentSchedulesPageURL();
			Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/acc-receivables", "URL not match");

			}
		@Test(priority=26)
		public void verifyInvoiceTest() throws InterruptedException{
			//testUtil.switchToFrame();

			homePage.clickOnAccountingTab();
			Thread.sleep(3000);
			String url= homePage.GetInvoicePageURL();
			Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/create-invoice", "URL not match");

			}
		//MessagingPage
		@Test(priority=27)
		public void verifyMessagingTest() throws InterruptedException{
			//testUtil.switchToFrame();
			homePage.clickOnMessagingLink();

			Thread.sleep(4000);

		
			
			String url= homePage.GetMessagingPageURL();
			Assert.assertEquals(url, "https://www.trea365.com/steam/#/csa/messaging", "URL not match");
			}

		**/

		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
	
