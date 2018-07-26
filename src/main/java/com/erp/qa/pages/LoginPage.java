package com.erp.qa.pages;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:

	@FindBy(xpath="//*[@id='Username']")
	WebElement username;

	
	@FindBy(xpath="//*[@id='mat-input-1']")
	WebElement password;

	@FindBy(xpath="//*[@id='login-fm-btn']")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div/div[1]/div[1]/div[1]/form/div[4]/small")
	WebElement InvalidloginError;

	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div/div[1]/div[1]/div[1]/mat-grid-list/div/mat-grid-tile[1]/figure/div/a")
	WebElement ForgotUserID;
	
	@FindBy(xpath="/html/body/trea-app-root/ng-component/div/div/div[1]/div[1]/div[1]/mat-grid-list/div/mat-grid-tile[2]/figure/div/a")
	WebElement ForgotPassword;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    		    		    
				return new HomePage();
	}
	
	public String InvalidUsernameMsg(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
	    
				return InvalidloginError.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
