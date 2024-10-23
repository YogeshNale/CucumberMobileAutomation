package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.Waits;

public class BillAmountTestClass extends TestBase {

	public BillAmountTestClass () {
		PageFactory.initElements(driver, this);
	}
	
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://www.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
	}
	
	@Test(priority = 1)
	public void getBillAmounts() throws Throwable {
		Waits.implicitWait(3000);
		amount.checkBillAmountForConsumerNumber();
	}
}
