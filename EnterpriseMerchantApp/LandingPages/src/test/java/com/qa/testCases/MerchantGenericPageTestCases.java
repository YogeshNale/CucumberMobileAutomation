package com.qa.testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;

public class MerchantGenericPageTestCases extends TestBase {

	@Test(priority=0)
	public void openURL() throws IOException {
		driver.get(GetUrl.getURL("MerchantGenericPage"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
	@Test(priority=1)
	public void payAmountToMerchant() throws InterruptedException, IOException {
		Thread.sleep(1000);
		Scroll.ScrollPage(generic.EnterDID);
		Scroll.ScrollPage(common.enterAmount);
		Thread.sleep(1000);
		common.enterAmount(TestData.generic(0, 1, 1));
		common.enterMobileNumber(TestData.generic(0, 2, 1));
		common.clickNoOnUPIToogle();
		common.clickDebitCardWithMeToogle();
		generic.TransactionToMerchant();
	
}
}
