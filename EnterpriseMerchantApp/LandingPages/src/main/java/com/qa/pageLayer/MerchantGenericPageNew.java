package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.testBase.TestBase;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class MerchantGenericPageNew extends TestBase {

	public MerchantGenericPageNew() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='phone-number-input']")
	public WebElement EnterMobileNumber;

	// enter amount
	@FindBy(xpath = "//input[@id='donate-amount-input']")
	public WebElement enterAmount;

	// enter invoice Number
	@FindBy(xpath = "//input[@id='bill-details-input']")
	public WebElement invoiceNumber;
	// check status of customer and pay amount to merchant

	@FindBy(xpath = "//button[@id='miss-call-btn']")
	public WebElement click2PayBuuton;

	public void selectBankAccount() throws InterruptedException {
		Thread.sleep(1000);
		boolean accountAutofetch = common.AccountAutofetched.isDisplayed();
		if (accountAutofetch == true) {
			log.info("User Account Details get Autofetched.");
			common.select1stAutofetchedBank();

		}
	}

	// user onboarding as per status of user
	public void transactionAsperStatusOfUser() throws InterruptedException, IOException {
		boolean click2Pay = common.clickToPayButton.isDisplayed();
		if (click2Pay == true) {
			log.info("User is existing MCP User , pay money to merchant with existing UPI User Start.");
			common.qrImage("yes");
			Thread.sleep(1000);
			common.clickToPayButton();
		}

		else if (click2Pay == false) {
			log.info("User is New MCP User ,pay money with new MCP user flow start.");
			merchantNew.selectBankAccount();
			common.selectLanguage(1);
			merchantNew.onboardingOfMerchantAsPerUPIStatus();
		}
	}

	public void onboardingOfMerchantAsPerUPIStatus() throws IOException, InterruptedException {
		boolean debitCardFeild = common.DebitCardNumber.isDisplayed();

		if (debitCardFeild == true) {
			log.info("Selected Account Is new UPI User ,Onboarding with New UPI User Start.");
			common.sendData(common.DebitCardNumber, TestData.MerchantGenerciPageNew(0, 5, 1),
					"User Enter debit card Number.");
			common.sendData(common.DebitCardExpityMonthYear, TestData.MerchantGenerciPageNew(0, 5, 1),
					"User enter debit card Expiry Month and Year.");
			Thread.sleep(10000);
			common.clickOnTermsAndCondition();
			merchantNew.checkBankUPIRequiredORNot();

		}

		else if (debitCardFeild == false) {
			log.info("Selected Account existing  UPI User ,Onboarding with existing UPI User Start.");
			common.clickOnElement(common.TermsAndCondition, "User Accept terms and condition.");
			common.clickOnElement(merchantNew.click2PayBuuton, "User Click on Call 2 pay Button.");
		}

	}

	public void checkBankUPIRequiredORNot() {
		boolean UPIOTP= common.GetUPIOtp.isDisplayed();
		
		if(UPIOTP ==true) {
			log.info("Selected Bank not required Debit Crad Pin To Onboard.");
			common.clickOnElement(common.GetUPIOtp);
		}
		else if(UPIOTP ==false) {
			log.info("Selected Bank Required Debit pin for Onboard.");
			common.clickOnElement(common.clickToPayButton);
		}

	}

}