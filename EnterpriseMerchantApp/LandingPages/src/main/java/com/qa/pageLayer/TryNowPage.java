package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qa.testBase.TestBase;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TryNowPage extends TestBase {
	
	
  //Select ACtion Element 
	@FindBy(xpath="//select[@id='what-you-want-input']")
	public WebElement SelectAction; 
	
	public void selectAction() {
		Select action = new Select(SelectAction);
		action.selectByIndex(1);
	}
	
	//process  as per status of user 
	public void checkStatusOfUserOnMisscallPay() throws InterruptedException {
		Thread.sleep(4000);
		boolean getOTPButton=common.GetOTP.isDisplayed();
		if(getOTPButton==true) {
			log.info("User Is New MCP User Onboarding Flow start");
			common.clickOnGetOTP();
			common.enterOTP();
			common.clickOnProceedButton();
			Thread.sleep(1000);
			Scroll.ScrollPage(common.SelectLanguage);
			common.selectLanguage(2);
			common.enterBankName("BOI New");
			common.selectBankAccount(1);
			trynow.OnboardUserAsPerUPIStatusOfUserSelectedAccount();
		}
		else if (getOTPButton==false) {
			log.info("User Is Existing MCP User ");
		}
		else {
			
		}
	}
	
	//Onboard User As Per Status Of User 
	
	public void OnboardUserAsPerUPIStatusOfUserSelectedAccount() throws InterruptedException {
		Thread.sleep(1000);
		boolean debitCardNumberFeild=common.DebitCardNumber.isDisplayed();
		if(debitCardNumberFeild==true) {
			log.info("Selected Account is New UPI User , Onboarding with New UPI User Start");
			Scroll.ScrollPage(common.DebitCardNumber);
			common.enterDebitCradNumber("123456");
			Scroll.ScrollPage(common.DebitCardExpityMonthYear);
			common.enterDebitCardExpityMonthYear("1234");
			Thread.sleep(1000);
			Scroll.ScrollPage(common.TermsAndCondition);
			common.clickOnTermsAndCondition();
		}
	}

	
}
