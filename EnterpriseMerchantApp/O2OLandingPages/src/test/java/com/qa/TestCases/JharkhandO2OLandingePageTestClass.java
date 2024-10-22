package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class JharkhandO2OLandingePageTestClass extends TestBase {

	public JharkhandO2OLandingePageTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://app.misscallpay.com/bill-payment/jharkhand-bijli-vitran-nigam-jbvnl.html");
	}
	
	// To check if user try to pay Bill 
		@Test(priority = 1)
		public void payBill() throws Throwable {
			Waits.implicitWait(3000);
			scroll.scrollDown(common.BillerNameDropDown);
			common.enterConsumerNumber(TestData.Jharkhand(0, 1, 2));
			common.enterSubDivisionCode(TestData.Jharkhand(0, 2, 2));
			common.clickOnFetchBillButton1();
			jharkhand.billAvailablepayBill();
			common.clickOnPayBillButton();
			common.enterYourName(TestData.Jharkhand(0, 3, 2));
			common.enterPhoneNumber(TestData.Jharkhand(0, 4, 2));
			scroll.scrollDown(common.EnterYourName);
			Thread.sleep(2000);
			common.clickOnDebitCardIsWithMe();
			common.clickOnNumberOnUPI();
			jharkhand.payBillAsPerStatusOfUser();
		}

}
