package com.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class SMFGCreditFinanceTestLayer extends TestBase {
	public SMFGCreditFinanceTestLayer() {
		PageFactory.initElements(driver, this);
	}
	// To launch merchant page URL on browser
	@Test(priority=0)
	public void launchURL() throws IOException {
		driver.get(GetUrl.getURL("SMFGCreditFinance"));
		log.info("User Launch URL on browser "+GetUrl.getURL("SMFGCreditFinance"));
		driver.switchTo().frame(0);
		
	}

	@Test(priority=1)
	public void paySMFGCreditFinanceBill() throws Throwable {
		Waits.explicitWait(common.EnterMobileNumber);
		Scroll.ScrollPage(common.EnterMobileNumber);
		common.enterMobileNumber(TestData.SMFGCredit(0, 1, 1));
		Scroll.ScrollPage(common.EnterMobileNumber);
		Waits.explicitWait(common.NoOnUPIToggle);
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		common.clickOnGetOTP();
		common.clickOnProceedButton();
		Thread.sleep(2000);
		common.clickOnElement(common.addAnotherConsumerNumber, "User click on another consumer radio Button.");
		common.sendData(SMFGCredit.enterLoanNumber, TestData.SMFGCredit(0, 2, 1), "User Enter Consumer Number "+ TestData.AUBank(0, 2, 1));
		Thread.sleep(1000);
		Scroll.ScrollPage(common.FetchBillButton);
		common.clickOnElement(common.FetchBillButton);
		SMFGCredit.billAvailablepayBill();
		SMFGCredit.payBillAsPerStatusOfUser();
	}

}
