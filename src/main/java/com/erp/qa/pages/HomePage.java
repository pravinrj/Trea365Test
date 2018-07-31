package com.erp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.qa.base.TestBase;
import com.erp.qa.pages.Admin.BusinessNaturePage;

public class HomePage extends TestBase {

	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/header/nav/div/ul/li[1]/a/span")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "/html/body/trea-app-root/ng-component/div/div[2]/section/app-summary/div/div[1]")
	@CacheLookup
	WebElement HomePageTitle;
		
	@FindBy(xpath = "//*[@id='leftside-navigation']/ul/li[2]/a/span[1]")
	WebElement AdminTab;
	
	@FindBy(xpath = "//*[@id='leftside-navigation']/ul/li[2]/ul/li[1]/a")
	WebElement NatureofBusinessLink;
	
	@FindBy(xpath="//*[@id='leftside-navigation']/ul/li[2]/ul/li[4]/a")
	WebElement MfgPartLink;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return HomePageTitle.getText();
		//return driver.getTitle();
	}
		
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnAdminTab()
	{
		AdminTab.click();
	}
	
	public BusinessNaturePage clickOnNatureofBusinessLink(){
		NatureofBusinessLink.click();
		return new BusinessNaturePage();
	}
	/*public void ClickOnNatureofBusinessTab()
	{
		NatureofBusinessLink.click();
	}*/
	
}
