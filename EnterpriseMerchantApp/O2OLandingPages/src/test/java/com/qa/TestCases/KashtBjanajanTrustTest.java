package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;

public class KashtBjanajanTrustTest extends TestBase{

	public KashtBjanajanTrustTest() {
		PageFactory.initElements(driver,this); 
	}
	
	// To check if user Open URL in Browser
		@Test(priority = 0)
		public void OpenURL() {
			driver.get("https://upi.misscallpay.com/misscall2dada.html");
		}
		
		//To check if user try to donate amount 
		@Test(priority=1)
		public void donateAmount() throws Throwable {
			Thread.sleep(1000);
			sarangpur.selectAmount();
			common.enterAmount(TestData.sarangpur(0, 1, 1));
			common.enterYourName(TestData.sarangpur(0, 2, 1));
			common.enterPhoneNumber(TestData.sarangpur(0, 3, 1));
			scroll.scrollDown(common.EnterYourName);
			common.clickOnNumberOnUPI();
			common.clickOnDebitCardIsWithMe();
			sarangpur.donateAmountPerStatusOfUser();
			
			
		}
}
