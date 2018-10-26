package com.erp.qa.pages.Admin;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.qa.base.TestBase;
import com.erp.qa.util.TestUtil;

public class MfgPage extends TestBase  {

	TestUtil testutil;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[2]/div[2]/button/span")
	WebElement NewMfgBtn;
	
	@FindBy(xpath = "//div[2]/button/span[@class='mat-button-wrapper']")
	WebElement NewFrame;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/form/div/div[1]/div/input")
	WebElement FullNameText;
	
	@FindBy(xpath = "//*[@id='comment']")
	WebElement CommentText;
	
	@FindBy(xpath="//*[@id='add-manufacturer-btn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]/span")
	WebElement DoneBtnOnConfirm;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[2]/div[1]/div/input")
	WebElement SearchTextBox;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[2]/div[1]/div/button/span")
	WebElement SearchBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[3]/div/table/tbody/tr/td[1]")
	WebElement SearchedTextBox;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[5]/div[1]/div/div/button/span")
				  
	WebElement EditBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[5]/div[1]/div/div/ul/li[1]/a")
	WebElement EditInfoBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer/div/div[5]/div[1]/div/div/ul/li[2]/a")
	WebElement DeleteBtn;
	
	@FindBy(xpath="//*[@id='comment']")
	WebElement EditCommentText;
	
	@FindBy(xpath="//*[@id='update-manufacturer-btn']")
	WebElement 	UpdateBtn;
	
	@FindBy(xpath="//*[@id='remove-btn']/span")

	WebElement 	DeleteConfYesBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button")
	WebElement 	DeleteConfDoneBtn;
	
	public MfgPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void createMfg(String FullName, String Comment) throws InterruptedException
	{
		Thread.sleep(3000);
		NewMfgBtn.click();
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
		action.moveToElement(NewFrame).perform();
		FullNameText.sendKeys(FullName);
		CommentText.sendKeys(Comment);
		SubmitBtn.click();
		Thread.sleep(2000);
		DoneBtnOnConfirm.click();
			
	}
	
	public String searchMfg(String FullName) throws InterruptedException
	{
		Thread.sleep(3000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(FullName);
		SearchBtn.click();
		Thread.sleep(3000);
		SearchedTextBox.click();
		return SearchedTextBox.getText();
		
	}
	
	public void EditMfg(String FullName, String NewComment) throws InterruptedException
	{
		Thread.sleep(3000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(FullName);
		SearchBtn.click();
		SearchedTextBox.click();
		Thread.sleep(2000);
		EditBtn.click();
		EditInfoBtn.click();
		EditCommentText.clear();
		EditCommentText.sendKeys(NewComment);
		Thread.sleep(3000);
		UpdateBtn.click();
		
	}
	
	public void DeleteMfg(String FullName) throws InterruptedException
	{
		Thread.sleep(3000);
		SearchTextBox.clear();
		SearchTextBox.sendKeys(FullName);
		SearchBtn.click();
		SearchedTextBox.click();
		Thread.sleep(3000);
		EditBtn.click();
		DeleteBtn.click();
		Thread.sleep(2000);
		DeleteConfYesBtn.click();
		Thread.sleep(2000);
		DeleteConfDoneBtn.click();
	}
	
	
}
