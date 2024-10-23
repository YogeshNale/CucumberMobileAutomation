package com.qa.TestCases;

import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;


public class AgentTestClass extends TestBase {
	public AgentTestClass() {
		PageFactory.initElements(driver , this );
	}

	@Test(priority =0)
	public void openURL() {
		driver.get("https://www.misscallpay.com/agent.html");
	}
	
	@Test(priority =1 )
	public void onboardingProcess() throws Throwable {
		Waits.implicitWait(3000);
		common.enterPhoneNumber((TestData.agent(0, 1, 1)));	
		common.clickOnNumberOnUPI();
		common.clickOnDebitCardIsWithMe();
	    scroll.scrollDown(common.ClickNumberOnUPI);
	    agent.OnboardingUserAsPerStatusOfUser();
		
		
	}

}
