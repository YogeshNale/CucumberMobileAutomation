package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class UatTataPowerMerchantTestClass extends TestBase {

	public UatTataPowerMerchantTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://app.misscallpay.com/upi/tpwodl1.html");
	}

	// To check if user try to pay a bill
	@Test(priority = 1)
	public void payBill() throws Throwable {
	
		Waits.implicitWait(2000);
		common.enterPhoneNumber(TestData.tataMerchant(0, 1, 2));
		scroll.scrollDown(common.EnterPhoneNumber);
		common.clickOnNumberOnUPI();
		common.clickOnDebitCardIsWithMe();
		common.clickOnGetOTP();
		common.enterOTP();
		Thread.sleep(27000);
		common.clickONProceedButton();
		Waits.implicitWait(2000);
		common.clickOnAnotherConsumerNumberRadioButton();
		scroll.scrollDown(common.EnterConsumerNumber);
		common.enterConsumerNumber(TestData.tataMerchant(0, 2, 2));
		common.clickOnFetchBillButton2();
		merchant.billAvailablepayBill();
	    scroll.scrollDown(common.SelectPaymentMethodText);
	    merchant.payBillAsPerStatusOfUser();

	}

}
