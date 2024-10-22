package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.Waits;

public class TataPowerMerchantO2OTestClass extends TestBase {

	public TataPowerMerchantO2OTestClass() {
		PageFactory.initElements(driver, this);
	}

   //To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://mcp.pe/tpwodl");
	}
	
	// To check if user try to pay a bill
	@Test(priority=1)
	public void payBill() throws Throwable {
		Waits.implicitWait(5000);
		merchant.enterPhoneNumber();
	//	scroll.scrollDown(common.EnterPhoneNumber);
		common.clickOnNumberOnUPI();
		common.clickOnDebitCardIsWithMe();
		common.clickOnGetOTP();
		common.enterOTP();
		Thread.sleep(17000);
		common.clickONProceedButton();
		Thread.sleep(3000);
		common.mobileVerificationIcon();
		Thread.sleep(1000);
		//scroll.scrollDown(merchant.AddConsumerRadioButton);
		merchant.enterConsumerNumber();
		merchant.clickOnFetchBillButton();
		merchant.billAvailablepayBill();
		merchant.payBillAsPerStatusOfUser();
	}

}
