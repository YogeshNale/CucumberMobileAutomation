package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class AjemerO2OLandingPage extends TestBase {

	public AjemerO2OLandingPage() {
		PageFactory.initElements(driver, this);
	}

	// K number field
	@FindBy(xpath = "//input[@id='K-Number-input']")
	public WebElement KNumberField;

	public void enterKNumber() throws Throwable {
		KNumberField.click();
		KNumberField.clear();
		KNumberField.sendKeys(TestData.ajmer(0, 1, 2));

	}

	// To check for entered consumer number Bill available or not on UAT

	public boolean UatBillAvailablepayBill() throws Throwable {
		Thread.sleep(3000);
		boolean billAvailable = common.BillDetails.isDisplayed();
	
		if (billAvailable == true) {
			scroll.scrollDown(common.BillDetails);
			//common.getConsumerName();
			//common.checkConsumerNumberinFetchedBill2(TestData.ajmer(0, 1, 2));
			//common.getBillAmount();
			// scroll.scrollDownFalse(common.ClickOnPayBillButton);
			common.clickOnPayBillButton();
			
		} else if (billAvailable == false) {
			String error_msg = common.fetchBillErrorMsg();

			if (error_msg == "Payment received for the billing period - no bill due") {
				log.info("Payment received for the billing period - no bill due");
				fail();
			} else if (error_msg == "No bill data available") {
				log.info("No bill data available");
				fail();
			} else {
				log.info(error_msg);
				fail();
			}
		}

		return billAvailable;
	}
	
	//check  entered number is existing MCP user or new MCP user and Do pay bill 
	public void payBillAsPerStatusOfUser() throws Throwable {
		boolean did = common.dIDPopulateOn1stPage();
		boolean otp = common.getOTPButton();

		if (did == true) {
			scroll.scrollDown(common.DIDPopulate1stPage);
			log.info("Pay Bill with Existing MCP user Flow start ");
			Thread.sleep(12000);
			scroll.scrollDown(common.DIDPopulate1stPage);
			common.qrCodeAvialavle();
			Thread.sleep(20000);
			common.receivedCallBackAction();
			Thread.sleep(10000);
			common.verifyAmountAction();
			tata.scrollOnBillAmountAction();
			

		}

		else if (otp == true) {
			common.clickOnGetOTP();
			log.info("Pay bill with new MCP User flow start ");
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			Thread.sleep(2000);
			scroll.scrollDown(common.SelectLanguage);
			common.selectLanguage();
			common.enterBankName(TestData.ajmer(0, 4, 2));
			Thread.sleep(5000);
			common.SelectBankAccount();
			ajmer.uatOnboardingAsPerUPIStatusOfAccount();

		}

		else if (did || otp == false) {
			log.info(" DID not get populate or Get OTP button also ");
			fail();
		}

	}
	
	// To check user selected account is new UPI account or existing UPI account as on UAT Envoirment as per account status do onboarding and do payment 
		
		public void uatOnboardingAsPerUPIStatusOfAccount() throws Throwable {
			Waits.implicitWait(1000);
			boolean CardNumberFeild = common.DebitCardNumber.isDisplayed();
			if (CardNumberFeild == false) {
				log.info(" Selected account is existing UPI Account hence onboarding flow for Existing UPI Account start ");
				 common.clickonTermsAndCondtionCheckBox();
				 common.dIDPopulateOn2ndpage();
				 Thread.sleep(12000);
			     scroll.scrollDown(common.QRCode);
			     common.qrCodeAvialavle();
			     common.clickOnGenerateQRButton();
			     common.checkTimeoutStopWatch();
			     
				
			}

			else if (CardNumberFeild == true) {
				log.info(" Selected account is new  UPI Account hence onboarding flow for new  UPI Account start ");
				
			}

		}

}


