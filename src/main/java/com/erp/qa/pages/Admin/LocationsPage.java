package com.erp.qa.pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.qa.base.TestBase;
import com.erp.qa.util.TestUtil;

public class LocationsPage extends TestBase {

	TestUtil testUtil;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[1]/div[2]/button/span")
	WebElement NewLocationBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-location/div/div[2]/form/div[1]/div/div/div[2]/div[2]/div/select")
	WebElement LocationTypeDropDown;
	
	@FindBy(xpath="//*[@id='Name']")
	WebElement LocationNameText;
	
	@FindBy(xpath="//*[@id='shortForm']")
	WebElement LocationShortFormText;
	
	@FindBy(xpath="//*[@id='addressLine1']")
	WebElement LocationAddressText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-location/div/div[2]/form/div[3]/div/div/div/div[2]/div/div/div/div/span/span")
	WebElement AddDivisionBtn;
	
	@FindBy(xpath="//*[@id='divName0']")
	WebElement DivisionNameText;
	
	@FindBy(xpath="//*[@id='divType0']")
	WebElement DivisionTypeDropDown;
	
	@FindBy(xpath="//*[@id='div0val0']")
	WebElement DivisionValueText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-location/div/div[2]/form/div[4]/button[1]")
	WebElement NextBtn;
	
	@FindBy(xpath="//*[@id='submit-btn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-13']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]/span")
	//*[@id="cdk-overlay-4"]/mat-dialog-container
	WebElement CreateMsgDoneBtn;
	
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[1]/div[1]/div/input")
	WebElement SearchText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[1]/div[1]/div/button/span")
	WebElement SearchBtn;
		
	//@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[3]/div[1]/table/tbody/tr[2]/td[1]")
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[3]/div[1]/table/tbody")
	WebElement SelectedRecord;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[3]/div[1]/table/tbody/tr/td[2]")
				   
	WebElement SelectedRecordLocation;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[3]/div[3]/div[1]/span[2]/span/button/span")
	WebElement PrintLabelBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-location-list/div[1]/div/div[3]/div[3]/div[1]/span[2]/button/span")
	WebElement DeleteBtn;
	
	@FindBy(xpath="//*[@id='remove-btn']/span")
	WebElement DeleteYesBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-14']/mat-dialog-container/ng-component/div/div[2]/div[2]/button/span")
	WebElement DeleteDoneBtn;
	
	
	
	public LocationsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CreateLocation(String LocType, String Name, String ShortForm, String Address, String DivisionName, String DivisionType, String Value) throws InterruptedException
	{
		Thread.sleep(4000);
		NewLocationBtn.click();
		
		Select drpType = new Select(LocationTypeDropDown);
		drpType.selectByValue(LocType);
		
		LocationNameText.sendKeys(Name);
		LocationShortFormText.sendKeys(ShortForm);
		LocationAddressText.sendKeys(Address);
		AddDivisionBtn.click();
		DivisionNameText.sendKeys(DivisionName);
		Thread.sleep(3000);
		Select drpDivType = new Select(DivisionTypeDropDown);
		drpDivType.selectByVisibleText(DivisionType);
		
		DivisionValueText.sendKeys(Value);
		Thread.sleep(2000);
		NextBtn.click();
		Thread.sleep(2000);
		SubmitBtn.click();
		Thread.sleep(2000);
		//testUtil.switchToFrame();
		//Thread.sleep(1000);
		//CreateMsgDoneBtn.click();
		
		System.out.println("Location created successfully");
		
	}
	
	public String SearchedLocation(String Name) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchText.sendKeys(Name);
		SearchBtn.click();
		Thread.sleep(2000);
		SelectedRecord.click();
		SelectedRecordLocation.click();
		return SelectedRecordLocation.getText();
		
	}
	
	public void DeleteLocation(String Name) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchText.clear();
		SearchText.sendKeys(Name);
		SearchBtn.click();
		Thread.sleep(2000);
		SelectedRecord.click();
		DeleteBtn.click();
		//DeleteYesBtn.click();
		//Thread.sleep(2000);
		//DeleteDoneBtn.click();
		System.out.println("Location deleted successfully");
	}
		
}
