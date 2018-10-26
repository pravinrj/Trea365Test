package com.erp.qa.pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.qa.base.TestBase;
import com.erp.qa.util.TestUtil;

public class SuppliersPage extends TestBase{
	
TestUtil testutil;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[1]/div[2]/button/span")
	WebElement NewSupplierBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-supplier/div/div/div/form/div[1]/div/div/select")
	WebElement SupplierTypeDropDown;
	
	@FindBy(xpath = "//*[@id='supplierName']")
	WebElement SupplierNameTxt;
	
	@FindBy(xpath = "//*[@id='address1']")
	WebElement Address1Txt;
	
	@FindBy(xpath = "//*[@id='address2']")
	WebElement Address2Txt;
	
	@FindBy(xpath = "//*[@id='countryId']")
	/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-supplier/div/div/div/form/div[5]/div/div/div/div/mat-form-field/div/div[1]/div
	WebElement CountryDropDown;
	
	@FindBy(xpath = "//*[@id='provinceId']")
	WebElement ProvinceDropDown;
	
	@FindBy(xpath = "//*[@id='cityId']")
	WebElement CityDropDown;
	
	@FindBy(xpath = "//*[@id='postalCode']")
	WebElement PostalcodeTxt;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement EmailTxt;
	
	@FindBy(xpath = "//*[@id='phoneNumber']")
	WebElement PhoneNumberTxt;
	
	@FindBy(xpath = "//*[@id='comment']")
	WebElement CommentsTxt;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-supplier/div/div/div/form/div[12]/div/button[1]")
	WebElement NextBtn;
	
	@FindBy(xpath = "//*[@id='addSupBtn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]")
	WebElement DoneBtnOnSuccessfullAddMsg;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[1]/div[1]/div/input")
	WebElement SearchTextBox;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[1]/div[1]/div/button/span")
	WebElement SearchBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[3]/table/tbody/tr[1]")
	WebElement SearchedRecordBox;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[5]/div/div[1]/div/button/span")
	WebElement EditBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[5]/div/div[1]/div/ul/li[1]/a")
	WebElement EditInfoBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[5]/form/div/div[1]/div/div[1]/div[2]/div/input")
	WebElement EditNameText;
	
	@FindBy(xpath = "//*[@id='updateSupplier']")
	WebElement UpdateBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[3]/table/tbody/tr[1]/td[1]")
	WebElement UpdatedNameBox;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-supplier-list/div/div[5]/div/div[1]/div/ul/li[2]/a")
	WebElement DeleteBtn;
	
	@FindBy(xpath = "//*[@id='remove-btn']")
	WebElement YesBtnOnDeleteMsg;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-4']/mat-dialog-container/ng-component/div/div[2]/div[2]/button/span")
	WebElement DoneBtnOnDeleteMsg;
	
	
	public SuppliersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CreateNewSupplier(String SupplierType, String Name, String Address1, String Address2, String Country, String Province, String City, String PostalCode, String Email, String PhoneNumber, String Comment) throws InterruptedException
	{
		Thread.sleep(2000);
		NewSupplierBtn.click();
		Select Suppliertype = new Select(SupplierTypeDropDown);
		Suppliertype.selectByVisibleText(SupplierType);
		Thread.sleep(2000);
		SupplierNameTxt.sendKeys(Name);
		Address1Txt.sendKeys(Address1);
		Address2Txt.sendKeys(Address2);
		//CountryDropDown.sendKeys(Country);
		Thread.sleep(2000);
		Select countryname=new Select(CountryDropDown);
		countryname.selectByVisibleText(Country);
		Thread.sleep(2000);
		//ProvinceDropDown.sendKeys(Province);
		Select provincename=new Select(ProvinceDropDown);
		provincename.selectByVisibleText(Province);
		Thread.sleep(2000);
		//CityDropDown.sendKeys(City);
		Select cityname=new Select(CityDropDown);
		cityname.selectByVisibleText(City);
		Thread.sleep(2000);
		PostalcodeTxt.sendKeys(PostalCode);
		EmailTxt.sendKeys(Email);
		PhoneNumberTxt.sendKeys(PhoneNumber);
		CommentsTxt.sendKeys(Comment);
		NextBtn.click();
		Thread.sleep(2000);
		SubmitBtn.click();
		DoneBtnOnSuccessfullAddMsg.click();
		
	}
	
	public String SearchSupplier(String Name) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(Name);
		SearchBtn.click();
		SearchedRecordBox.click();
		return SearchedRecordBox.getText();
	}
	
	public void EditSupplier(String Name, String NewName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(Name);
		SearchBtn.click();
		SearchedRecordBox.click();
		EditBtn.click();
		EditInfoBtn.click();
		EditNameText.clear();
		EditNameText.sendKeys(NewName);
		UpdateBtn.click();
		
	}
	
	public void DeleteSupplier(String NewName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(NewName);
		SearchBtn.click();
		SearchedRecordBox.click();
		EditBtn.click();
		DeleteBtn.click();
		Thread.sleep(2000);
		YesBtnOnDeleteMsg.click();
		DoneBtnOnDeleteMsg.click();
		
	}
	
	
	
	
	
	
	

	
	
	
}
