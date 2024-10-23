package com.qa.testCases;

import java.io.File;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class UATTataPowerMerchantTestClass extends TestBase {

	public UATTataPowerMerchantTestClass() {
		PageFactory.initElements(driver, this);
	}
	
	
    //Lunch URL and switch frame 
	
	@Test(priority = 0)
	public void openUrl() throws Throwable {
		driver.get(GetUrl.getURL("UATTataMerchantMyli"));
		log.info("User Launched URL on browser " + GetUrl.getURL("UATTataMerchantMyli"));
		driver.switchTo().frame(0);

	}
 // Entire Bill pay In Positive Way existing , new mcp new UPI , new MCP existing UPI all cases handaled 
	@Test(priority = 1)
	public void BillPayProcess() throws Throwable {
		Waits.explicitWait(common.EnterMobileNumber);
		Scroll.ScrollPage(common.EnterMobileNumber);
		common.enterMobileNumber(TestData.UatTataPower(0, 1, 1));
		Scroll.ScrollPage(common.EnterMobileNumber);
		Waits.explicitWait(common.NoOnUPIToggle);
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		common.clickOnGetOTP();
		common.clickOnProceedButton();
		Waits.explicitWait(uatMerchant.AnotherConsumerRadioButton);
		Scroll.ScrollPage(uatMerchant.AnotherConsumerRadioButton);
		uatMerchant.clickonAnotherConsumerRadioButton();
		Waits.implicitWait(2000);
		Scroll.ScrollPage(common.ConsumerNumber);
		common.enterConsumerNumber("813425041628");
		Thread.sleep(5000);
		Scroll.ScrollPage(common.FetchBillButton);
		Waits.explicitWait(common.FetchBillButton);
		common.clickOnFetchBillButton();
		uatMerchant.billAvailablepayBill();
	    Waits.implicitWait(2000);
		Scroll.ScrollPage(Merchant.FetchedBillAmount);
		Merchant.fetchedBillAmount();
		Scroll.ScrollPage(common.SelectMorePaymentMethodText);
		Waits.implicitWait(1000);
		uatMerchant.payBillAsPerStatusOfUser();

	}
	
	//To check if user want To fetch another Bill 
	//@Test(priority=2)
	public void fetchAnotherBill() throws Throwable {
		Waits.implicitWait(2000);
		Scroll.ScrollPage(common.EnterMobileNumber);
		common.enterMobileNumber(TestData.UatTataPower(0, 1, 1));
		Scroll.ScrollPage(common.EnterMobileNumber);
		Thread.sleep(1000);
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		common.clickOnGetOTP();
		common.clickOnProceedButton();
		Scroll.ScrollPage(uatMerchant.AnotherConsumerRadioButton);
		Thread.sleep(2000);
		uatMerchant.clickonAnotherConsumerRadioButton();
		Thread.sleep(2000);
		common.enterConsumerNumber("813425041628");
		Scroll.ScrollPage(common.FetchBillButton);
		Thread.sleep(1000);
		common.clickOnFetchBillButton();
		Thread.sleep(5000);
		uatMerchant.billAvailablepayBill();
		uatMerchant.fetchAnotherBill();
		Thread.sleep(1000);
		log.info("User Click on fetch another Bill And Another Bill Fetch Process Start.");
		Scroll.ScrollPage(common.ConsumerNumber);
		common.enterConsumerNumber("813425041628");
		Scroll.ScrollPage(common.FetchBillButton);
		Thread.sleep(1000);
		common.clickOnFetchBillButton();
		
	}
	
	//@Test(priority=3)
	public void OnboardUserWithoutBillPay() throws Throwable {
		Waits.implicitWait(2000);
		Scroll.ScrollPage(common.EnterMobileNumber);
		common.enterMobileNumber(TestData.UatTataPower(0, 1, 1));
		Scroll.ScrollPage(common.EnterMobileNumber);
		Thread.sleep(1000);
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		common.clickOnGetOTP();
		common.clickOnProceedButton();
		Scroll.ScrollPage(uatMerchant.AnotherConsumerRadioButton);
		Thread.sleep(2000);
		uatMerchant.clickonAnotherConsumerRadioButton();
		Thread.sleep(2000);
		common.enterConsumerNumber("813425041628");
		uatMerchant.OnboardingWithoutPayBill();
	}
}
