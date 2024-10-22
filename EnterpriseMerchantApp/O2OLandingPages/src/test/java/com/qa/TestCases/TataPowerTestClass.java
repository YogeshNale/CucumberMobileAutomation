package com.qa.TestCases;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TataPowerTestClass extends TestBase {

	public TataPowerTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://www.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
	}

	// To check if user try to pay Bill with consumer for bill is available and user
	
	@Test(priority = 1)
	public void payBill() throws Throwable {
		Waits.implicitWait(7000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",amount.text );
		scroll.scrollDown(tata.BillerName);
		tata.enterConsumerNumber();
		tata.scrollOnconsumerNumberFeild();
		common.clickOnFetchBillButton1();
		Thread.sleep(2000);
		tata.billAvailablepayBill();
		//common.enterYourName(TestData.TataPower(0, 3, 1));
		tata.enterUserPhoneNumber();
	    scroll.scrollDown(common.EnterPhoneNumber);
		common.clickOnDebitCardIsWithMe();
		common.clickOnNumberOnUPI();
	     Thread.sleep(1000);
		tata.payBillAsPerStatusOfUser();
		
		
		
		
		
	}
	
}
