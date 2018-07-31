package com.erp.qa.pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.qa.base.TestBase;

public class MfgPartPage extends TestBase {

	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-manufacturer-part/div/div[1]/div/div[2]/button/span")
	WebElement NewmfgpartBtn ;
	
	@FindBy(xpath="//*[@id='mat-input-0']")
	WebElement MfgDropdown;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[2]/div/input")
	WebElement MfgPartno;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[3]/div/input")
	WebElement UPC;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[4]/div/textarea")
	WebElement FullName;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[5]/div/input")
	WebElement ShortName;
	
	@FindBy(xpath="//*[@id='mat-input-1']")
	WebElement ClassDropdown;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[7]/div/div/ss-multiselect-dropdown/div/button")
	WebElement ReplacesDropdown;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[8]/div/div/ss-multiselect-dropdown/div/button")
	WebElement EquivalentDropdown;
	
	@FindBy(xpath="//*[@id='minimumStock']")
	WebElement MinimumStock;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[2]/div[10]/div/select")
	WebElement UOMDropdown;
	
	@FindBy(xpath="//*[@id='salesMarkup']")
	WebElement SalesMarkup;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-add-manufacturer-part/div/div/form/div[3]/button[1]")
	WebElement NextBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input")
	WebElement AttributeLabel;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[1]/div[1]/div[2]/div/div/div[2]/input")
	WebElement AttributeDate;
	
	@FindBy(xpath="//*[@id='dropZone']/div/div/a")
	WebElement SelectFileLink;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div[2]/section/app-mfg-attributes/div/div/div[2]/button[2]")
	WebElement NextBtnOnAttributePage;
	
	@FindBy(xpath="//*[@id='sub-btn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//*[@id='cdk-overlay-3']/mat-dialog-container/ng-component/div/div[2]/div[2]/button[2]")
	WebElement DoneBtnOnSuccessfulAddMsg;
	
	public MfgPartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//public void CreateMfgPart(String )
	
	
	
	
	
	

	
	
	
//	WebElement listbox=driver.findElement(By.id("mfg"));
//	listbox.sendkeys("b");
//	listbox.sendkeys(keys.DOWN);
//	listbox.sendkeys(keys.ENTER);

	
	
	
	
	
	
}
