package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class UatAgentPageTestclass extends TestBase {

	public UatAgentPageTestclass() {
		PageFactory.initElements(driver, this);
	}
	
	@Test(priority =0)
	public void openURL() {
		driver.get("https://app.misscallpay.com/agent.html");
	}
	
	@Test(priority =1 )
	public void onboardingProcess() throws Throwable {
		Waits.implicitWait(3000);
		common.enterPhoneNumber((TestData.agent(0, 1, 2)));	
		common.clickOnNumberOnUPI();
		common.clickOnDebitCardIsWithMe();
	    scroll.scrollDown(common.ClickNumberOnUPI);
	    agent.uatOnboardingUserAsPerStatusOfUser();
		
		
	

}
}
