package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class RefLandingePageTestClass extends TestBase {

	public RefLandingePageTestClass() {
		PageFactory.initElements(driver, this);
	}

	// To check if user Open URL in Browser
			@Test(priority = 0)
			public void OpenURL() {
				driver.get("https://www.misscallpay.com/ref-now.html");
			}
			
			//To check user is existing MCP user or new MCP and if existing MCP user then add add account 
			@Test(priority = 1)
			public void checkTryLandingePage() throws Throwable, InterruptedException {
				Waits.implicitWait(3000);
				common.selectActionWhatWantToDO();
				common.enterPhoneNumber(TestData.ref(0, 1, 1));
				common.clickOnNumberOnUPI();
				scroll.scrollDown(common.EnterPhoneNumber);
				common.clickOnDebitCardIsWithMe();
				ref.checkRefPageAsPerUserStatus();
				
				
			}

}
