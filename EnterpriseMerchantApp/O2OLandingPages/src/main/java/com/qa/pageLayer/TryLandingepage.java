package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TryLandingepage extends TestBase {

	public TryLandingepage() {
		PageFactory.initElements(driver, this);
	}

// Check user us existing mcp is or new MCP user if user is existing MCP user then add account or if new MCP user dew onboarding 
	public void checkTryPageAsPerUserStatus() throws Throwable {
		Waits.implicitWait(5000);
		boolean DIDPupulate = common.dIDPopulateOn1stPage();
		if (DIDPupulate == true) {
			log.info("DID Populate on 1st page user is existing MCP user if user call on DID One call flow Will start  ");
			common.clickAddMorePaymentMehodURL();
			scroll.scrollDown(common.EnterPhoneNumber);
			common.clickOnGetOTP();
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			common.enterBankName(TestData.tryPage(0, 3, 1));
			scroll.scrollDown(common.EnterBankName);
			common.SelectBankAccount();
			common.clickonTermsAndCondtionCheckBox();
			Thread.sleep(5000);
			common.checkUserRedirectOn3rdPage();
			Thread.sleep(2000);
			common.receivedCallBackAction();
			Thread.sleep(2000);
			common.concernAction();
			Thread.sleep(2000);
			common.onboardSucessfullyAction();

		}

		else if (DIDPupulate == false) {
			log.info(" User is new MCP user onboraing process start ");
			common.clickOnGetOTP();
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			common.checkUserRedirectOn2rdPage();
			common.selectLanguage();
			common.enterBankName(TestData.tryPage(0, 3, 1));
			scroll.scrollDown(common.SelectLanguage);
			common.SelectBankAccount();
			common.clickonTermsAndCondtionCheckBox();
			Thread.sleep(12000);
			common.checkUserRedirectOn3rdPage();
			Thread.sleep(5000);
			common.receivedCallBackAction();
			scroll.scrollDown(common.ReceivedCallBackAction);
			Thread.sleep(2000);
			common.concernAction();
			Thread.sleep(2000);
			common.onboardSucessfullyAction();

		}
	}

}
