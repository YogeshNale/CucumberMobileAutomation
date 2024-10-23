package com.qa.TestCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.CompareImage;
import com.qa.utility.GetURLs;
import com.qa.utility.TestData;

public class CommonBillerTestClass extends TestBase {

	public CommonBillerTestClass() {
		PageFactory.initElements(driver, this);
	}

	// Common Biller pay Bill for particular Biller
	@Test(priority = 0, groups = { "Sanity" })
	public void launchCommonBillerURL() throws Throwable {
		for (int i = Integer.parseInt(TestData.commonBiller(1, 0, 1)); i <= Integer
				.parseInt(TestData.commonBiller(1, 0, 2)); i++) {
			driver.get(GetURLs.pageURL("UATURL"));
			driver.switchTo().frame(0);
			commonB.passBillerDetails(0, i, 0, 1, 3, 4, 5);
			common.clickOnFetchBillButton1();
			Thread.sleep(2000);
			if (commonB.BillAvailablepayBill() == true) {
				CompareImage.compareImage(TestData.commonBiller(1, 1, 1) + TestData.commonBiller(0, i, 7),
						common.billerLogoImage, TestData.commonBiller(0, i, 1));
				scroll.scrollDown(common.ClickOnPayBillButton);
				
			}
			else {
				log.info("For Enter Consumer Number Bill Not Available ");
				fail();
			}
			
			common.clickOnPayBillButton();
			common.enterYourName(TestData.commonBiller(1, 2, 1));
			scroll.scrollDown(common.EnterYourName);
			Thread.sleep(500);
			scroll.scrollDown(common.EnterPhoneNumber);
			common.enterPhoneNumber(TestData.commonBiller(1, 3, 1));
			Thread.sleep(500);
			common.clickOnDebitCardIsWithMe();
			common.clickOnNumberOnUPI();
			commonB.UatPayBillAsPerStatusOfUser();

		}
	}

	// Common Biller Regression upto Fetch Bill
	@Test(priority = 1, groups = { "Sanity" })
	public void fetchBillRegression() throws Throwable {
		driver.get(GetURLs.pageURL("UATURL"));
		for (int i = Integer.parseInt(TestData.commonBiller(1, 0, 1)); i <= Integer
				.parseInt(TestData.commonBiller(1, 0, 2)); i++) {
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			commonB.passBillerDetails(0, i, 0, 1, 3, 4, 5);
			common.clickOnFetchBillButton1();
			Thread.sleep(2000);
	
			if (commonB.BillAvailablepayBill() == true) {
				CompareImage.compareImage(TestData.commonBiller(1, 1, 1) + TestData.commonBiller(0, i, 7),
						common.billerLogoImage, TestData.commonBiller(0, i, 1));
				scroll.scrollDown(common.ClickOnPayBillButton);
				driver.navigate().refresh();
				System.out.println(i);
			}

			else {
				driver.navigate().refresh();
				System.out.println(i);
			}
		}

	}

}
