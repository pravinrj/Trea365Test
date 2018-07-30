package com.erp.qa.pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.qa.base.TestBase;
import com.erp.qa.util.TestUtil;

public class BusinessNaturePage extends TestBase {
	
	TestUtil testUtil;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[1]")
	WebElement BusinessPageTitle;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[2]/div[2]/button/span")
	WebElement NewBusinessTypeBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-business-nature/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement BusinessTypeText;
	
	@FindBy(xpath = "//*[@id='serType0']")
	WebElement SeriveTypeText;
	
	@FindBy(xpath = "//*[@id='ser0def0']")
	WebElement SeriveTypeDescText;
	
	@FindBy(xpath = "//*[@id='ser0price0']")
	WebElement PriceText;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-business-nature/div/div[2]/form/div[2]/table/tbody/tr[1]/td[3]/div[2]/img")
	WebElement PlusServiceDefBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-business-nature/div/div[2]/form/div[2]/table/tbody/tr[1]/td[3]/div[1]/div[2]/div[1]/img")
	WebElement CancelServiceDefBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-business-nature/div/div[2]/form/div[3]/button[1]")
	WebElement NextBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-business-nature/div/div[2]/form/div[3]/button[2]")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//*[@id='addBusiNature']/span")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-review-business-nature/div/div[3]/button[2]")
	WebElement EditBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/div[1]")
	WebElement SuccessfullMsgPopup;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]/span")
	WebElement DoneBtnOnMsgPopup;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[2]/div[1]/div/input")
	WebElement SearchTextBox;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[2]/div[1]/div/button/span")
	WebElement SearchButton;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[4]/table/tbody/tr/td[1]")
	WebElement SearchedBuType;
		
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[4]/table/tbody/tr[6]/td[1]")
	WebElement SelectRecord;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[6]/div[1]/div[1]/div/button")
	WebElement GridEditButton;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[6]/div[1]/div[1]/div/ul/li[1]/a")
	WebElement GridEditInfoButton;
	
	@FindBy(xpath = "//*[@id='addBusiNature']/span")
	WebElement UpdateBuTypeBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button/span")
	WebElement DoneBtnOnUpdateBuPopup;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-business-nature/div/div[6]/div[1]/div[1]/div/ul/li[2]/a")
	WebElement GridDeleteButton;

	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[1]/div")
	WebElement DeleteConfirmationMsg;

	@FindBy(xpath = "//*[@id='remove-btn']/span")
	WebElement YesDelConfirmationBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[1]/div")
	WebElement DeleteSuccessfulMsg;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button")
	WebElement DoneBtnOnDeleteSuccessPopup;
	
	
	public BusinessNaturePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CreateNewBusinessType(String BuType, String ServiceType, String ServiceDef, String Price) throws InterruptedException
	{

		NewBusinessTypeBtn.click();
		Thread.sleep(3000);
		BusinessTypeText.sendKeys(BuType);
		SeriveTypeText.sendKeys(ServiceType);
		SeriveTypeDescText.sendKeys(ServiceDef);
		PriceText.sendKeys(Price);
		Thread.sleep(2000);
		NextBtn.click();
		Thread.sleep(2000);
		SubmitBtn.click();
				
		DoneBtnOnMsgPopup.click();
		
	}
	
	public String SearchedBuType(String BuType) throws InterruptedException
	{
		SearchTextBox.sendKeys(BuType);
		SearchButton.click();
		Thread.sleep(3000);
		return SearchedBuType.getText();
		
	}
	
	public String EditBuType(String OldBuType, String NewBuType) throws InterruptedException
	{
		SearchTextBox.sendKeys(OldBuType);
		SearchButton.click();
		Thread.sleep(3000);
		SearchedBuType.click();
		GridEditButton.click();
		GridEditInfoButton.click();
		BusinessTypeText.clear();
		BusinessTypeText.sendKeys(NewBuType);
		NextBtn.click();
		Thread.sleep(2000);
		UpdateBuTypeBtn.click();
		DoneBtnOnUpdateBuPopup.click();
		Thread.sleep(2000);
		SearchTextBox.sendKeys(OldBuType);
		SearchButton.click();
		Thread.sleep(3000);
		SearchedBuType.click();
		return SearchedBuType.getText();
	}
		
	public void DeleteBuType(String BuType) throws InterruptedException
	{
		SearchTextBox.sendKeys(BuType);
		SearchButton.click();
		Thread.sleep(3000);
		SearchedBuType.click();
		GridEditButton.click();
		GridDeleteButton.click();
		YesDelConfirmationBtn.click();
		DoneBtnOnDeleteSuccessPopup.click();
	}
	
	
	
	
	
	
	
	

}
