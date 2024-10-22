package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class UATTataPowerTestClass extends TestBase {

	public UATTataPowerTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
	//@Test(priority = 0)
	//public void OpenURL() {
	//	driver.get("https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
	//}

	// To check if user try to pay Bill with consumer for bill is available and user

	@Test(priority = 1 ,invocationCount=2 ,threadPoolSize=2)
	public void payBill() throws Throwable {
		driver.get("https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
	Waits.implicitWait(3000);
	common.enterConsumerNumber(TestData.TataPower(0, 1, 2));
	common.clickOnFetchBillButton1();
	tata.UatBillAvailablepayBill();
	tata.UatPayBillAsPerStatusOfUser();
	
	}
}
