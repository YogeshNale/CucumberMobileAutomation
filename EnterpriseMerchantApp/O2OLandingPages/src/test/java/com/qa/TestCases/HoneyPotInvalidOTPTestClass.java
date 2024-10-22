package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class HoneyPotInvalidOTPTestClass extends TestBase {

	public HoneyPotInvalidOTPTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
	}

	@Test(priority = 1)
	// To check if user enter invalid OTP 3 time user get Block or not
	public void maxInvalidOTP() throws Throwable {
		Waits.implicitWait(2000);
		common.enterConsumerNumber(TestData.honey(0, 1, 2));
		scroll.scrollDown(common.EnterConsumerNumber);
		common.clickOnFetchBillButton1();
		honey.billAvailableToPayBill();
		scroll.scrollDown(common.FetchedBillDetails2);
		common.clickOnPayBillButton();
		scroll.scrollDown(common.EnterPhoneNumber);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		common.clickOnNumberOnUPI();
		common.clickOnGetOTP();
		honey.enterOtp();
		Thread.sleep(2000);
		honey.NumberIsBarredErrorMSG("Tata Power Merchant Page ");

	}

	// check number is barred on Tata Power page also
	//@Test(priority = 2)
	public void checkNumberBarredOnTataPowerPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredOnTataPowerPageAlso(
				"https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");

	}

	// check number is barred on agenet page also
	@Test(priority = 3)
	public void checkNumberBarredOnAgentPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForAgentPageAlso("https://app.misscallpay.com/agent.html");

	}

	// check number is barred on kasht Bhanjan trust o2O page also
	@Test(priority = 4)
	public void checkNumberBarredOnKashtBhanajanPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForKashtBhanjanPageAlso("https://app.misscallpay.com/misscall2dada.html");

	}

	// check number is barred on try page also
	@Test(priority = 5)
	public void checkNumberBarredOnTryPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForKashtBhanjanPageAlso("https://app.misscallpay.com/try-now.html");

	}

	// check number is barred on ref page also
	@Test(priority = 6)
	public void checkNumberBarredOnRefPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForKashtBhanjanPageAlso("https://app.misscallpay.com/ref-now.html");

	}

	// check number is barred on invite friend page also
	@Test(priority = 7)
	public void checkNumberBarredOnInviteFriendPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForInvitefriendPageAlso("https://app.misscallpay.com/invite_friend.html");

	}

	// check number is barred on invite consumer page also
	@Test(priority = 8)
	public void checkNumberBarredOnInviteConsumerPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForInviteConsumerPageAlso(
				"https://app.misscallpay.com/invite_consumer.html?utm_biller=TPWODL");

	}

	// check number is barred on Merchant generic page also
	@Test(priority = 9)
	public void checkNumberBarredOnMerchantGenericPageAlso() throws Throwable {
		Waits.implicitWait(1000);
		honey.checkNumberBarredForMerchantgenericPageAlso(
				"https://app1.misscallpay.com/invite_consumer.html?utm_source=TP");

	}

}
