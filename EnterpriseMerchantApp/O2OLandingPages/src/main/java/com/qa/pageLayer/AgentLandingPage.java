package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class AgentLandingPage extends TestBase {

	public AgentLandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Click to onboard as merchant button
	@FindBy(xpath = "(//button[text()=' Click here to onboard as merchant'])[1]")
	private WebElement OnboardAsMerchantButton;

	public boolean clickOnOnboardAsMerchantButton() {
		Waits.implicitWait(1000);
		boolean onboardAsMerchantButton = OnboardAsMerchantButton.isDisplayed();
		if (onboardAsMerchantButton == true) {
			OnboardAsMerchantButton.click();
			log.info("Onboard as merchant Button Populate on WebPage ");
		} else if (onboardAsMerchantButton == false) {
			log.info("Onboard as merchant Button not Populate on WebPage ");
			fail();
		}
		return onboardAsMerchantButton;

	}

	// To check after click on onboard as merchant button user redirect on admin
	// panel web App
	public void redirectOnAdminPanel(String a) throws Throwable {
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		log.info("User redirect on Admin panel Web App ");
		Assert.assertEquals(url, a);
	}

	// click on shop type movable radio button
	@FindBy(xpath = "//input[@id='iff-3']")
	private WebElement ShopType;

	public void clickOnShopTypeMovable() {
		Waits.implicitWait(1000);
		ShopType.click();
	}

	// To check for selected Bank Account deit pin required or not on UAT Envoirment 
	public void uatOnboardingAsPerdebitPinRequiredOrNot() throws Throwable {
		Thread.sleep(2000);
		boolean DIDOn2ndPage = common.DIDPopulateOn2ndpage.isDisplayed();
		boolean getUPIOtpButton = common.GetUPIOTP.isDisplayed();
		if (DIDOn2ndPage == true) {
			log.info("For selected Bank To complete onboarding process Debit Pin is required ");
			common.dIDPopulateOn2ndpage();
			Thread.sleep(20000);
			common.checkUserRedirectOn3rdPage();
			Thread.sleep(1000);
			common.receivedCallBackAction();
			Thread.sleep(1000);
			scroll.scrollDown(common.AcceptTermsAndConitionAction);
			common.concernAction();
			Thread.sleep(3000);
			common.verifyEnterOTPAction();
			Thread.sleep(2000);
			common.verifySetUPIPinAction();
			Thread.sleep(2000);
			common.verifyReEnterUPIPinAction();
			Thread.sleep(2000);
			scroll.scrollDown(common.SetUPIPinAction);
			common.onboardSucessfullyAction();
			Thread.sleep(2000);
			agent.clickOnOnboardAsMerchantButton();
			agent.redirectOnAdminPanel("https://uatadmin.panel.localdomain:4201/login");
		}

		else if (getUPIOtpButton == true) {
			log.info("For selected Bank To complete onboarding process Debit Pin is not  required ");
			common.clickOnGetUPIOTP();
			common.dIDPopulateOn2ndpage();
			Thread.sleep(10000);
			common.checkUserRedirectOn3rdPage();
			Thread.sleep(4000);
			common.receivedCallBackAction();
			Thread.sleep(2000);
			common.concernAction();
			scroll.scrollDown(common.AcceptTermsAndConitionAction);
			Thread.sleep(2000);
			common.verifyEnterOTPAction();
			Thread.sleep(5000);
			common.verifySetUPIPinAction();
			Thread.sleep(4000);
			common.verifyReEnterUPIPinAction();
			scroll.scrollDown(common.SetUPIPinAction);
			Thread.sleep(2000);
			common.onboardSucessfullyAction();
			Thread.sleep(4000);
			agent.clickOnOnboardAsMerchantButton();
			agent.redirectOnAdminPanel("https://uatadmin.panel.localdomain:4201/login");

		}

		else if (DIDOn2ndPage || getUPIOtpButton == false) {
			log.info(" DID not get populate or Get OTP button also on 2nd page to complete onboardinge process  ");
			fail();
		}

	}

	// To check user selected account is new UPI account or existing UPI account as on UAT Envoirment 
	// per UPi status do onboarding
	public void uatOnboardingAsPerUPIStatusOfAccount() throws Throwable {
		Waits.implicitWait(1000);
		boolean CardNumberFeild = common.DebitCardNumber.isDisplayed();
		if (CardNumberFeild == false) {
			log.info(" Selected account is existing UPI Account hence onboarding flow for Existing UPI Account start ");
			Thread.sleep(1000);
			common.dIDPopulateOn2ndpage();
			Thread.sleep(10000);
			common.checkUserRedirectOn3rdPage();
			Thread.sleep(2000);
			common.receivedCallBackAction();
			scroll.scrollDown(common.ReceivedCallBackAction);
			common.concernAction();
			Thread.sleep(1000);
			common.onboardSucessfullyAction();
			Thread.sleep(1000);
			agent.clickOnOnboardAsMerchantButton();
			agent.redirectOnAdminPanel("https://uatadmin.panel.localdomain:4201/login");

		}

		else if (CardNumberFeild == true) {
			log.info(" Selected account is new  UPI Account hence onboarding flow for new  UPI Account start ");
			common.enterDebitCardNumber(TestData.agent(0, 3, 2));
			common.enterDebitCardExpiryDate(TestData.agent(0, 4, 2));
			agent.clickOnShopTypeMovable();
			scroll.scrollDown(agent.ShopType);
			Thread.sleep(2000);
			agent.uatOnboardingAsPerdebitPinRequiredOrNot();

		}

	}

	// to check if user is existing MCP user or new MCP user if user is new MCP user on UAT Envoirment 
	public void uatOnboardingUserAsPerStatusOfUser() throws Throwable {
		boolean did = common.dIDPopulateOn1stPage();
		boolean GetotpButton = common.getOTPButton();

		if (did == true) {
			scroll.scrollDown(common.DIDPopulate1stPage);
			log.info("User is alredy onboarded on Misscall pay if you call On DID One call flow will start ");
			agent.clickOnOnboardAsMerchantButton();
			agent.redirectOnAdminPanel("https://uatadmin.panel.localdomain:4201/login");

		}

		else if (GetotpButton == true) {
			common.clickOnGetOTP();
			log.info("user is new MCP user onboarding flow start ");
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			common.checkUserRedirectOn2rdPage();
			common.selectLanguage();
			common.enterBankName((TestData.agent(0, 2, 2)));
			scroll.scrollDown(common.SelectLanguage);
			Waits.implicitWait(1000);
			common.clickonTermsAndCondtionCheckBox();
			Thread.sleep(2000);
			common.SelectBankAccount();
			agent.clickOnShopTypeMovable();
			agent.uatOnboardingAsPerUPIStatusOfAccount();

		}

		else if (did || GetotpButton == false) {
			log.info(" DID not get populate or Get OTP button also ");
			fail();
		}

	}

	// To check for selected Bank Account deit pin required or not
		public void productionOnboardingAsPerdebitPinRequiredOrNot() throws Throwable {
			Thread.sleep(2000);
			boolean DIDOn2ndPage = common.DIDPopulateOn2ndpage.isDisplayed();
			boolean getUPIOtpButton = common.GetUPIOTP.isDisplayed();
			if (DIDOn2ndPage == true) {
				log.info("For selected Bank To complete onboarding process Debit Pin is required ");
				common.dIDPopulateOn2ndpage();
				Thread.sleep(20000);
				common.checkUserRedirectOn3rdPage();
				Thread.sleep(1000);
				common.receivedCallBackAction();
				Thread.sleep(1000);
				scroll.scrollDown(common.AcceptTermsAndConitionAction);
				common.concernAction();
				Thread.sleep(3000);
				common.verifyEnterOTPAction();
				Thread.sleep(2000);
				common.verifySetUPIPinAction();
				Thread.sleep(2000);
				common.verifyReEnterUPIPinAction();
				Thread.sleep(2000);
				scroll.scrollDown(common.SetUPIPinAction);
				common.onboardSucessfullyAction();
				Thread.sleep(2000);
				agent.clickOnOnboardAsMerchantButton();
				agent.redirectOnAdminPanel("https://uatadmin.panel.localdomain:4201/login");
			}

			else if (getUPIOtpButton == true) {
				log.info("For selected Bank To complete onboarding process Debit Pin is not  required ");
				common.clickOnGetUPIOTP();
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				common.checkUserRedirectOn3rdPage();
				Thread.sleep(4000);
				common.receivedCallBackAction();
				Thread.sleep(2000);
				common.concernAction();
				scroll.scrollDown(common.AcceptTermsAndConitionAction);
				Thread.sleep(2000);
				common.verifyEnterOTPAction();
				Thread.sleep(5000);
				common.verifySetUPIPinAction();
				Thread.sleep(4000);
				common.verifyReEnterUPIPinAction();
				scroll.scrollDown(common.SetUPIPinAction);
				Thread.sleep(2000);
				common.onboardSucessfullyAction();
				Thread.sleep(4000);
				agent.clickOnOnboardAsMerchantButton();
				agent.redirectOnAdminPanel("https://admin.misscallpay.com:4202/login");

			}

			else if (DIDOn2ndPage || getUPIOtpButton == false) {
				log.info(" DID not get populate or Get OTP button also on 2nd page to complete onboardinge process  ");
				fail();
			}

		}

		// To check user selected account is new UPI account or existing UPI account as
		// per UPi status do onboarding
		public void productionOnboardingAsPerUPIStatusOfAccount() throws Throwable {
			Waits.implicitWait(1000);
			boolean CardNumberFeild = common.DebitCardNumber.isDisplayed();
			if (CardNumberFeild == false) {
				log.info(" Selected account is existing UPI Account hence onboarding flow for Existing UPI Account start ");
				Thread.sleep(1000);
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				common.checkUserRedirectOn3rdPage();
				Thread.sleep(2000);
				common.receivedCallBackAction();
				scroll.scrollDown(common.ReceivedCallBackAction);
				common.concernAction();
				Thread.sleep(1000);
				common.onboardSucessfullyAction();
				Thread.sleep(1000);
				agent.clickOnOnboardAsMerchantButton();
				agent.redirectOnAdminPanel("https://admin.misscallpay.com:4202/login");

			}

			else if (CardNumberFeild == true) {
				log.info(" Selected account is new  UPI Account hence onboarding flow for new  UPI Account start ");
				common.enterDebitCardNumber(TestData.agent(0, 3, 1));
				common.enterDebitCardExpiryDate(TestData.agent(0, 4, 1));
				agent.clickOnShopTypeMovable();
				scroll.scrollDown(agent.ShopType);
				Thread.sleep(2000);
				agent.productionOnboardingAsPerdebitPinRequiredOrNot();

			}

		}

		// to check if user is existing MCP user or new MCP user if user is new MCP user
		// then onboarding Flow will start
		public void OnboardingUserAsPerStatusOfUser() throws Throwable {
			Thread.sleep(6000);
			boolean did = common.dIDPopulateOn1stPage();
			boolean GetotpButton = common.getOTPButton();

			if (did == true) {
				
				scroll.scrollDown(common.DIDPopulate1stPage);
				log.info("User is alredy onboarded on Misscall pay if you call On DID One call flow will start ");
				agent.clickOnOnboardAsMerchantButton();
				agent.redirectOnAdminPanel("https://admin.misscallpay.com:4202/login");

			}

			else if (GetotpButton == true) {
				common.clickOnGetOTP();
				log.info("user is new MCP user onboarding flow start ");
				common.enterOTP();
				Thread.sleep(15000);
				common.clickONProceedButton();
				common.checkUserRedirectOn2rdPage();
				common.selectLanguage();
				common.enterBankName((TestData.agent(0, 2, 1)));
				scroll.scrollDown(common.SelectLanguage);
				Waits.implicitWait(1000);
				common.clickonTermsAndCondtionCheckBox();
				Thread.sleep(5000);
				common.SelectBankAccount();
				agent.clickOnShopTypeMovable();
				agent.productionOnboardingAsPerUPIStatusOfAccount();

			}

			else if (did || GetotpButton == false) {
				log.info(" DID not get populate or Get OTP button also ");
				fail();
			}

		}


}
