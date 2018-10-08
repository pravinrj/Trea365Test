package com.erp.qa.pages.Admin;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.mobile.AddNetworkConnection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.qa.base.TestBase;
import com.erp.qa.util.TestUtil;

public class ItemCategoriesPage extends TestBase {
	
	TestUtil testUtil;

	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[1]/div[2]/button/span")
	WebElement NewItemCatagoryBtn;
	
	@FindBy(xpath = "//div[2]/button/span[@class='mat-button-wrapper']")
	WebElement NewFrame;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div")
	WebElement NewItemCatagoryInnerFrame;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div/div[1]/div")
					//*[@id="cdk-overlay-1"]/mat-dialog-container/ng-component/div/div[1]/div
	WebElement NewItemCatagoryFrameTitle;
	
	//@FindBy(xpath = "//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div/div[2]/form/div[1]/div[1]/div/input")
	@FindBy(name="itemClassName")
	WebElement CatagoryNameText;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-1']/mat-dialog-container/ng-component/div/div[1]/div")
	WebElement DialogTitle;
	
		
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/form/div[1]/div[2]/div/select")
	WebElement ItemTypeDropDowm;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/form/div[1]/div[3]/div/textarea")
	WebElement CommentsText;
	
	@FindBy(xpath = "//*[@id='addItemClass']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-0']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]/span")
	WebElement SuccessfullMsgDoneBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[1]/div[1]/div/input")
	WebElement SearchTxt;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[1]/div[1]/div/button/span")
	WebElement SearchBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[3]/div/table/tbody/tr/td[1]")
	WebElement SelectedRecord;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[5]/div[1]/div/div/button")
	WebElement EditBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[5]/div[1]/div/div/ul/li[1]/a")
	WebElement EditInfoBtn;
			
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[5]/div[1]/div/div/ul/li[2]/a")
	WebElement DeleteBtn;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-item-classes/div/div/div[5]/div[3]/div[1]/div[4]/div[2]/form/div/textarea")
	WebElement EdtCommentText;
	
	@FindBy(xpath = "//*[@id='updateItemClass']")
	WebElement UpdateBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-1']/mat-dialog-container/ng-component/div/div[2]/div[2]/button/span")
	WebElement UpdateSuccessMsgDoneBtn;
	
	@FindBy(xpath = "//*[@id='remove-btn']/span")
	WebElement DeleteConfirmationYesBtn;
	
	@FindBy(xpath = "//*[@id='cdk-overlay-2']/mat-dialog-container/ng-component/div/div[2]/div[2]/button/span")
	WebElement DeleteConfirmationDoneBtn;
	
	
	public ItemCategoriesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	private static Object firstHandle;
	private static Object lastHandle;

	public static void switchToWindowsPopup() {
	    Set<String> handles = driver.getWindowHandles();
	   
	    Iterator<String> itr = handles.iterator();
	    firstHandle = itr.next();
	    lastHandle = firstHandle;
	    while (itr.hasNext()) {
	        lastHandle = itr.next();
	    }
	    driver.switchTo().window(lastHandle.toString());
	}

	public static void switchToMainWindow() {
	    driver.switchTo().window(firstHandle.toString());
	}
	
	public void CreateCategory(String CatName, String ItemType, String Comments) throws InterruptedException
	{
		Thread.sleep(4000);
		NewItemCatagoryBtn.click();
		Thread.sleep(4000);
		
		Actions action = new Actions(driver);
		action.moveToElement(NewFrame).perform();
		
		System.out.println(NewFrame.getText());
				
		CatagoryNameText.sendKeys(CatName);
		Thread.sleep(3000);
		Select ItemTypeDrop = new Select(ItemTypeDropDowm);
		Thread.sleep(2000);
		ItemTypeDrop.selectByVisibleText(ItemType);
		Thread.sleep(2000);
		CommentsText.sendKeys(Comments);
		SubmitBtn.click();
		Thread.sleep(2000);
		SuccessfullMsgDoneBtn.click(); 
		
		System.out.println("Item Category created successfully");
	}
	
	public String SearchedItemCategory(String CatName) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchTxt.clear();
		SearchTxt.sendKeys(CatName);
		SearchBtn.click();
		Thread.sleep(2000);
		SelectedRecord.click();
		return SelectedRecord.getText();
	}
	
	public void EditItemCategory(String CatName, String NewComments) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchTxt.clear();
		SearchTxt.sendKeys(CatName);
		SearchBtn.click();
		Thread.sleep(2000);
		SelectedRecord.click();
		EditBtn.click();
		EditInfoBtn.click();
		Thread.sleep(2000);
		EdtCommentText.clear();
		EdtCommentText.sendKeys(NewComments);
		UpdateBtn.click();
		Thread.sleep(2000);
		//UpdateSuccessMsgDoneBtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(NewFrame).click().perform();
		
	}
	
	public void DeleteItemCategory(String Name) throws InterruptedException
	{
		Thread.sleep(5000);
		SearchTxt.clear();
		SearchTxt.sendKeys(Name);
		SearchBtn.click();
		Thread.sleep(2000);
		SelectedRecord.click();
		EditBtn.click();
		DeleteBtn.click();
		Thread.sleep(2000);
		DeleteConfirmationYesBtn.click();
		Thread.sleep(2000);
		//DeleteConfirmationDoneBtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(NewFrame).click().perform();
	}
	
	
	
	
	
	
	
	
	
}
