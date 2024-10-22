package com.qa.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class UATAjmerPageTestClass extends TestBase {

	public UATAjmerPageTestClass() {
		PageFactory.initElements(driver, this);
	}
	
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://app.misscallpay.com/bill-payment/tp-ajmer-distribution-limited-tpadl.html");
	}
	
	@Test(priority = 1)
	public void payBill() throws Throwable {
		Waits.implicitWait(3000);
		ajmer.enterKNumber();
		scroll.scrollDown(ajmer.KNumberField);
		common.clickOnFetchBillButton1();
		ajmer.UatBillAvailablepayBill();
		scroll.scrollDown(common.EnterYourName);
		common.enterYourName(TestData.ajmer(0, 2, 2));
		common.enterPhoneNumber(TestData.ajmer(0, 3, 2));
		common.clickOnMobileNumberIsKLinkedToBank();
		common.clickOnDebitCardIsWithMe();
		common.clickOnNumberOnUPI();
		ajmer.payBillAsPerStatusOfUser();
		
	
	}
}
