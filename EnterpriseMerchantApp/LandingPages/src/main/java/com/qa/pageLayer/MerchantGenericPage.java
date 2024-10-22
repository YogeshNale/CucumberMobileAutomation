package com.qa.pageLayer;


import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;

public class MerchantGenericPage extends TestBase{

	@FindBy(xpath="//input[@id='extention-input']")
	public WebElement EnterDID;
	
	@FindBy(xpath="//button[@id='miss-call-btn']")
	public WebElement DIDOn2ndPage;
	public void dIDOn2ndPage() throws InterruptedException {
		Thread.sleep(2000);
		boolean did=DIDOn2ndPage.isDisplayed();
		if(did==true) {
			log.info("After Select Bank details and Terms And condition DID Populate On UI");
		}
		
		else if (did==false){
			log.info("After Select Bank details and Terms And condition DID Not  Populate On UI");
			fail();
		}
	}
	
	
	
	//To DO transaction as per the Status of User Onboarded on Misscall pay 
	public void TransactionToMerchant() throws InterruptedException, IOException {
		Thread.sleep(3000);
		boolean DIDDisplayed=common.callOnDIDButton();
		boolean getOTPButton= common.GetOTP.isDisplayed();
		if(DIDDisplayed == true) {
			log.info("User Is Existing MCP User ,Transaction To Merchant With Existing User Start");
			Thread.sleep(10000);
			Scroll.ScrollPage(common.QRImage);
			Thread.sleep(1000);
			Scroll.ScrollPage(common.GenerateQR);
			common.qrImage(TestData.generic(0, 3, 1));
			/*Thread.sleep(20000);
			common.checkUserReceivedCallBack();
			Thread.sleep(5000);
			common.verifyAmountAction();
			Thread.sleep(5000);
			common.enterUPIPinAction();
		*/
		}
			else if (getOTPButton == true) {	
			log.info("User Is New MCP User , Transaction To Merchant with New MCP User Start");
			common.clickOnGetOTP();
			common.enterOTP();
			common.clickOnProceedButton();
			log.info("User Verify OTP Sucessfully ");
			Thread.sleep(1000);
			Scroll.ScrollPage(common.SelectLanguage);
			common.selectLanguage(1);
			boolean accountAutofetch=common.accountAutofetched();
			
			if(accountAutofetch==true) {
				log.info("Accounts are available and get  Autofetched Sucessfully ");
				Thread.sleep(2000);
				common.select1stAutofetchedBank();
				Scroll.ScrollPage(common.OtherBankRadioButton);
				generic.onboardUserAsPerStatusOfUser();
			}
			else if (accountAutofetch == false) {
				log.info("No Account get autofetched ,Enter bank name and select bank account To Onboard");
				Scroll.ScrollPage(common.OtherBankRadioButton);
				common.clickOnOtherBankRadioButton();
				common.enterBankName(TestData.generic(0, 4, 1));
				Thread.sleep(1000);
				common.selectBankAccount(1);
				generic.onboardUserAsPerStatusOfUser();
			}
			
		}
			else if (getOTPButton && DIDDisplayed == false) {
				log.info("DID or get OTP Button not get displayed on UI");
				fail();
			}
			
	}
	
	public void onboardUserAsPerStatusOfUser() throws InterruptedException, IOException {
		boolean debitCardFeild =common.DebitCardNumber.isDisplayed();
		if(debitCardFeild==true) {
			log.info("Selected Accout is New UPI Account , onboarding For New UPI Account Start");
			Thread.sleep(1000);
			Scroll.ScrollPage(common.DebitCardNumber);
			common.enterDebitCradNumber(TestData.generic(0, 5, 1));
			common.enterDebitCardExpityMonthYear(TestData.generic(0, 6, 1));
			common.DebitCardNumber.click();
			Thread.sleep(1000);
			Scroll.ScrollPage(common.TermsAndCondition);
			common.clickOnTermsAndCondition();
			Thread.sleep(1000);
			if(generic.DIDOn2ndPage.isDisplayed()==true){
				log.info("Selected Account Debit Pin Is required");
				Thread.sleep(10000);
				Scroll.ScrollPage(common.QRImageOn2ndPage);
				common.qrImageOn2ndPage(TestData.generic(0, 3, 1));
			}
			
			else if (common.GetUPIOtp.isDisplayed()==true) {
				log.info("Selected Account  Pin Is Not required");
				common.ClickOnGetUPIOTP();
				Thread.sleep(1000);
				Scroll.ScrollPage(generic.DIDOn2ndPage);
				generic.dIDOn2ndPage();
				Thread.sleep(10000);
				Scroll.ScrollPage(common.QRImageOn2ndPage);
				common.qrImageOn2ndPage(TestData.generic(0, 3, 1));
			}
			
			
		}
		else if (debitCardFeild == false ) {
			log.info("Selected Accout is Existing UPI  UPI Account , onboarding For Existing UPI Account Start");
			Thread.sleep(2000);
			Scroll.ScrollPage(common.TermsAndCondition);
			common.clickOnTermsAndCondition();
			Scroll.ScrollPage(DIDOn2ndPage);
			generic.dIDOn2ndPage();
			Thread.sleep(10000);
			Scroll.ScrollPage(common.QRImageOn2ndPage);
			common.qrImageOn2ndPage(TestData.generic(0, 3, 1));
			/*Thread.sleep(25000);
			common.checkUserReceivedCallBack();
			Thread.sleep(10000);
			common.UserAcceptTermsAndConditionAction();
			Thread.sleep(10000);
			common.onboardedAction();
			Thread.sleep(10000);
			common.verifyAmountAction();
			*///Thread.sleep(10000);
			//common.enterUPIPinAction();
		
			
		}
	}
	
}
