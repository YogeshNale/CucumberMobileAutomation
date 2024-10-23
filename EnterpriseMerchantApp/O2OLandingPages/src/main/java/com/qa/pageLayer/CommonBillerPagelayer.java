package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class CommonBillerPagelayer extends TestBase {

	public CommonBillerPagelayer() {
		PageFactory.initElements(driver, this);

	}

	public boolean billAvailableGetAmount(int j) throws Throwable {
		Thread.sleep(6000);
		boolean billAvailable = tata.BillDetails.isDisplayed();
		if (billAvailable == true) {
			Thread.sleep(1000);
			scroll.scrollDown(tata.BillDetails);
			String n = tata.getBillAmount();
			System.out.println(n);
			String billAmount = amount.writeBillAmount();
			TestData.writeBillAmount(1, j, 1, billAmount);

		} else if (billAvailable == false) {
			String error_msg = common.fetchBillErrorMsg();
			System.out.println(error_msg);
			TestData.writeBillAmount(1, j, 1, error_msg);

		}

		return billAvailable;
	}

	public void checkBillAmountForConsumerNumber() throws Throwable, InterruptedException {

		for ( int i = 0; i <=1; i++) {
			Waits.implicitWait(1000);
			driver.navigate().refresh();
		driver.switchTo().frame(0);
		commonE.enterState("Odisha");
		scroll.scrollDown(commonE.EnterState);
		commonE.enterBiller("TP Western Odisha Distribution Limited");
		scroll.scrollDown(commonE.BillerName);
		commonE.enter1stParamater(TestData.billAmount(0, i, 0));
		tata.scrollOnconsumerNumberFeild();
		scroll.scrollDown(common.GetBillAmont);
		common.clickOnFetchBillButton1();
		
		com.billAvailableGetAmount(i);
		
		System.out.println(i);
		
		}

	}
}
