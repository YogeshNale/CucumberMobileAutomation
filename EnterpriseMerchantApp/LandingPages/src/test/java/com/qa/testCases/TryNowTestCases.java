package com.qa.testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TryNowTestCases extends TestBase {
	
	
	// To check if user Open URL in Browser
	@Test(priority = 0)
	public void OpenURL() throws IOException {
		driver.get(GetUrl.getURL("TryNowPage"));
		Waits.implicitWait(10);
	}

	
	@Test(priority = 1)
	public void checkTryLandingePage() throws Throwable, InterruptedException {
		Thread.sleep(1000);
		Scroll.ScrollPage(trynow.SelectAction);
		trynow.selectAction();
		Scroll.ScrollPage(common.EnterName);
		common.enterName(TestData.trynow(0, 1, 1));
		common.enterMobileNumber(TestData.trynow(0, 2, 1));
		common.clickNoOnUPIToogle();
		Scroll.ScrollPage(common.DebitCardWithMeToggel);
		common.clickDebitCardWithMeToogle();
		trynow.checkStatusOfUserOnMisscallPay();

	}

}
