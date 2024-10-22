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

public class HoneyPot extends TestBase {

	public HoneyPot() {
		PageFactory.initElements(driver, this);
	}

	// enter name in hidden feild
	@FindBy(xpath = "//input[@class='pincode form-control']")
	private WebElement EnterPincodeHideFeild;

	public void enterPincodeFeild(String a) {
		Waits.implicitWait(1000);
		EnterPincodeHideFeild.click();
		EnterPincodeHideFeild.sendKeys(a);
		log.info("Bot enter name in user name feild ");
	}

	// enter Email ID in hidden feild
	@FindBy(xpath = "//input[@class='email form-control']")
	private WebElement EnterEmailHideFeild;

	public void enterEmailHideFeild(String a) {
		Waits.implicitWait(1000);
		EnterEmailHideFeild.click();
		EnterEmailHideFeild.sendKeys(a);
		log.info("Bot enter Email ID  in  Email ID  feild ");
	}
	
	// enter name in hidden feild
	@FindBy(xpath = "//input[@class='input-group pincode']")
	private WebElement EnterPincodeHideFeild1;

	public void enterPincodeFeild1(String a) {
		Waits.implicitWait(1000);
		EnterPincodeHideFeild1.click();
		EnterPincodeHideFeild1.sendKeys(a);
		log.info("Bot enter name in user name feild ");
	}

	// enter Email ID in hidden feild
	@FindBy(xpath = "//input[@class='input-group email']")
	private WebElement EnterEmailHideFeild1;

	public void enterEmailHideFeild1(String a) {
		Waits.implicitWait(1000);
		EnterEmailHideFeild1.click();
		EnterEmailHideFeild1.sendKeys(a);
		log.info("Bot enter Email ID  in  Email ID  feild ");
	}

	// number is blocked error msg
	@FindBy(xpath = "//div[@id='resend-otp-error-msg']")
	public WebElement NumberIsBarredErrorMSG;

	public void NumberIsBarredErrorMSG(String a) throws InterruptedException, Throwable {
		Thread.sleep(3000);
		boolean error_MSG = NumberIsBarredErrorMSG.isDisplayed();
		
		if (error_MSG   == true) {
			log.info(TestData.honey(0, 2, 2) + " This Number is barred for " + a);

		} else if (error_MSG  == false) {
			log.info("Number is not blocked yet ");
			fail();
		}
	}

	// number is blocked error msg
	@FindBy(xpath = "//div[@id='mobile-number-error-msg']")
	public WebElement afterNumberIsBarredErrorMSG;

	public void afterNumberIsBarredErrorMSG(String a) throws InterruptedException, Throwable {
		Thread.sleep(3000);
		boolean error_MSG = afterNumberIsBarredErrorMSG.isDisplayed();
		if (error_MSG = true) {
			log.info(TestData.honey(0, 2, 2) + " This Number is barred for " + a);

		} 
		
		else if (error_MSG == false) {
			log.info("user is new MCP user  " );
			fail();
		}
		
	}

	// To check for entered consumer number Bill available or not

	public boolean billAvailableToPayBill() throws Throwable {
		Thread.sleep(2000);
		boolean billAvailable = common.fetchedBillDetails2();
		if (billAvailable == true) {
			log.info("Bill Available for entered Consumer Number ");

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

	// public void enter OTP 3 time
	public void enterOtp() throws Throwable {
		for (int i = 0; i <= 3; i++) {
			common.EnterOTP.click();
			common.EnterOTP.clear();
			common.EnterOTP.sendKeys(TestData.honey(0, 3, 2));
			common.ProccedButton.click();
			log.info("User enter Invalid OTP " + i + " Time ");

		}
	}

	// To check number is existing UPI user new UPI user
	public void checkStatus() throws Throwable {
		Thread.sleep(1000);
		boolean OTP = common.GetOTPButton.isDisplayed();
		boolean DID = common.dIDPopulateOn1stPage();
		if (OTP == true) {
			common.clickOnGetOTP();
			honey.enterOTPAndProcced();
		}

		else if (DID == true) {

		}
	}

	// enter OTP and click on proceed Button
	public void enterOTPAndProcced() throws Throwable {
		Waits.implicitWait(1000);
		common.EnterOTP.click();
		common.EnterOTP.sendKeys(TestData.honey(0, 3, 2));
		common.clickONProceedButton();

	}

	// check number is get blocked for tata power landinge page also
	public void checkNumberBarredOnTataPowerPageAlso( ) throws Throwable {
		Waits.implicitWait(1000);
		driver.get("https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
		common.enterConsumerNumber(TestData.honey(0, 1, 2));
		scroll.scrollDown(common.EnterConsumerNumber);
		common.clickOnFetchBillButton();
		honey.billAvailableToPayBill();
		scroll.scrollDown(common.FetchedBillDetails2);
		common.clickOnPayBillButton();
		scroll.scrollDown(common.EnterPhoneNumber);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("TataPowerPageAlso");

	}
	//check number is blocked on tata power merchant page also 
	public void checkNumberIsBarredOnTataPowerMerchantPageAlso() throws Throwable {
		driver.get("https://app.misscallpay.com/upi/tpwodl1.html");
		Waits.implicitWait(2000);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		scroll.scrollDown(common.EnterPhoneNumber);
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("TataPowerMerchantPageAlso");
	}

	// check number is get block for agent page also
	public void checkNumberBarredForAgentPageAlso( ) throws Throwable {
		Waits.implicitWait(1000);
		driver.get("https://app.misscallpay.com/agent.html");
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("Agent Page Also");

	}

	// check number is get block for kasht Bhanjan page also
	public void checkNumberBarredForKashtBhanjanPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		driver.get("https://app.misscallpay.com/misscall2dada.html");
		sarangpur.selectAmount();
		common.enterAmount("1");
		common.enterYourName("Yogesh");
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		scroll.scrollDown(common.EnterYourName);
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("KashtBhanjan Page Also");

	}

	// check number is get block for try page also
	public void checkNumberBarredForTryAlso( ) throws Throwable {
		Thread.sleep(3000);
		driver.get("https://app.misscallpay.com/try-now.html");
		common.selectActionWhatWantToDO();
		common.enterYourName(TestData.honey(0, 7, 2));
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		scroll.scrollDown(common.EnterYourName);
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("try  Page Also");

	}

	// check number is get block for ref page also
	public void checkNumberBarredForRefAlso( ) throws Throwable {
		Thread.sleep(3000);
		driver.get("https://app.misscallpay.com/ref-now.html");
		common.selectActionWhatWantToDO();
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		common.clickOnNumberOnUPI();
		honey.afterNumberIsBarredErrorMSG("ref  Page Also");

	}

	// check number is get block for invite friend page also
	public void checkNumberBarredForInvitefriendPageAlso() throws Throwable {
		Thread.sleep(3000);
		driver.get("https://app.misscallpay.com/invite_friend.html");
		scroll.scrollDown(common.LandingePage1);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		common.clickOnGetOTP();
		Thread.sleep(1000);
		boolean error=common.NotOnbordedErrorMSG.isDisplayed();
		Assert.assertEquals(error, false);

	}

	// check number is get block for invite consumer page also
	public void checkNumberBarredForInviteConsumerPageAlso( ) throws Throwable {
		
		driver.get("https://app.misscallpay.com/invite_consumer.html?utm_biller=TPWODL");
		Thread.sleep(3000);
		scroll.scrollDown(common.GetOTPButton);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		honey.afterNumberIsBarredErrorMSG(" invite consumer Page Also");

	}

	// check number is get block for Merchant generic page also
	public void checkNumberBarredForMerchantgenericPageAlso() throws Throwable {
		Thread.sleep(3000);
		driver.get("https://app.misscallpay.com/merchant_generic.html?utm_did=8066741981&utm_extension=1003");
		common.enterAmount(TestData.honey(0, 6, 2));
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		scroll.scrollDown(common.LandingePage1);
		common.clickOnNumberOnUPI();
		Thread.sleep(3000);
		honey.afterNumberIsBarredErrorMSG(" Merchant generic Page Also");

	}

	//
}
