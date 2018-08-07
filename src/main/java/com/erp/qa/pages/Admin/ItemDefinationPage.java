package com.erp.qa.pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.qa.base.TestBase;

public class ItemDefinationPage extends TestBase {

	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[1]/div/div[2]/button/span")
	WebElement NewItemDefBtn ;
	
	@FindBy(xpath="//*[@id='mat-input-14']")
	WebElement ItemCategoryDropdown;
	
	@FindBy(xpath="//*[@id='mat-input-0']")
	WebElement MfgDropdown;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[2]/div/input")
	WebElement ItemDefnoText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[3]/div/input")
	WebElement UPCText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[4]/div/textarea")
	WebElement FullNameText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[5]/div/input")
	WebElement ShortNameText;
			
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[7]/div/div/ss-multiselect-dropdown/div/button")
	WebElement ReplacesDropdown;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[8]/div/div/ss-multiselect-dropdown/div/button")
	WebElement EquivalentDropdown;
	
	@FindBy(xpath="//*[@id='minimumStock']")
	WebElement MinimumStockText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[10]/div/select")
	WebElement UOMDropdown;
	
	@FindBy(xpath="//*[@id='salesMarkup']")
	WebElement SalesMarkupText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[3]/button[1]")
	WebElement NextBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input")
	WebElement AttributeLabelText;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[1]/div[1]/div[2]/div/div/div[2]/input")
	WebElement AttributeDataText;
	
	@FindBy(xpath="//*[@id='dropZone']/div/div/a")
	WebElement SelectUploadFileLink;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[2]/button[2]")
	WebElement NextBtnOnAttributePage;
	
	@FindBy(xpath="//*[@id='sub-btn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]")
	WebElement DoneBtnOnSuccessfulAddMsg;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[1]/div/div[1]/input")
	WebElement SearchTextBox;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[2]/div/table/tbody/tr/td[2]")
	WebElement SearchedItemShortName;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[2]/div/table/tbody/tr")
	WebElement SearchedResultBox;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[4]/div[1]/div[2]/button")
	WebElement EditBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[4]/div[4]/form/div[1]/div[5]/div[2]/div/input")
	WebElement EditScreenShortNameTextBox;
	
	@FindBy(xpath="//*[@id='update-details-btn']")
	WebElement UpdateBtn;
			
			
	public ItemDefinationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CreateItemDef(String ItemCategory, String Mfg, String ItemDefNo, String UPC, String FullName, String ShortName, String UOM, String AttributeLabel, String AttributeData)
	{
		NewItemDefBtn.click();
		ItemCategoryDropdown.click();
		ItemCategoryDropdown.sendKeys(ItemCategory);
		MfgDropdown.click();
		MfgDropdown.sendKeys(Mfg);
		ItemDefnoText.sendKeys(ItemDefNo);
		UPCText.sendKeys(UPC);
		FullNameText.sendKeys(FullName);
		ShortNameText.sendKeys(ShortName);
		
		Select drpUOM = new Select(UOMDropdown);
		drpUOM.selectByVisibleText(UOM);
		
		NextBtn.click();
		
		AttributeLabelText.sendKeys(AttributeLabel);
		AttributeDataText.sendKeys(AttributeData);
		
		NextBtnOnAttributePage.click();
		SubmitBtn.click();
		DoneBtnOnSuccessfulAddMsg.click();
	}
	
	public String SearchedItemDef(String ShortName) throws InterruptedException
	{
		SearchTextBox.sendKeys(ShortName);
		Thread.sleep(3000);
		return SearchedItemShortName.getText();
	}
	
	public String EditItemDef(String OldItemShortName, String NewShortName)
	{
		SearchTextBox.sendKeys(OldItemShortName);
		SearchedResultBox.click();
		EditBtn.click();
		EditScreenShortNameTextBox.sendKeys(NewShortName);
		UpdateBtn.click();
		SearchedItemShortName.click();
		return SearchedItemShortName.getText();
	}
	
	


	
	
	
	
	
	
}
