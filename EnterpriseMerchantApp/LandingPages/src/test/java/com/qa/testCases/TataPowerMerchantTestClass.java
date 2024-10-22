package com.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.Waits;

public class TataPowerMerchantTestClass extends TestBase {

	public TataPowerMerchantTestClass() {
		PageFactory.initElements(driver,this);
	}
	
	@Test(priority=0)
	public void openUrl() throws Throwable {
		driver.get(GetUrl.getURL("TataMerchantMyli"));
		log.info("Launched URL on browser "+GetUrl.getURL("TataMerchantMyli"));
		driver.switchTo().frame(0);
		log.info(System.getProperty("User.dir"));
		
		
	}
	
	@Test(priority=1)
	public void BillPayProcess() throws Throwable {
		Waits.implicitWait(2000);
		Scroll.ScrollPage(common.EnterMobileNumber);
		common.enterMobileNumber("9604677424");
		Scroll.ScrollPage(common.EnterMobileNumber);
		Thread.sleep(1000);
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		common.clickOnGetOTP();
		
		common.clickOnProceedButton();
		Thread.sleep(2000);
		Merchant.clickonAnotherConsumerRadioButton();
		Thread.sleep(1000);
		common.enterConsumerNumber("813425041628");
		Scroll.ScrollPage(common.FetchBillButton);
		Thread.sleep(1000);
		common.clickOnFetchBillButton();
		Thread.sleep(5000);
		Merchant.billAvailablepayBill();
		Thread.sleep(1000);
		Scroll.ScrollPage(Merchant.FetchedBillAmount);
		Merchant.fetchedBillAmount();
		Scroll.ScrollPage(common.SelectMorePaymentMethodText);
		Waits.implicitWait(1000);
		Merchant.payBillAsPerStatusOfUser();
		
		
		
		
		
	

	}
}
