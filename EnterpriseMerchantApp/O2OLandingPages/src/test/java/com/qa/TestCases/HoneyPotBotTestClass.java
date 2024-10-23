package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class HoneyPotBotTestClass extends TestBase {

	public HoneyPotBotTestClass() {
		PageFactory.initElements(driver, this);
	}

	

	//@Test(priority = 0)
	// To check if bot enter name and Emil ID 
	public void checkBotGiveInputForInvisibleFeildOnTataPowerMerchantPage() throws Throwable {
		driver.get("https://app.misscallpay.com/upi/tpwodl1.html");
		Waits.implicitWait(2000);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		scroll.scrollDown(common.EnterPhoneNumber);
		honey.enterPincodeFeild(TestData.honey(0, 4, 2));
		honey.enterEmailHideFeild(TestData.honey(0, 5, 2));
		common.clickOnNumberOnUPI();
		scroll.scrollDown(common.ClickNumberOnUPI);
		common.clickOnGetOTP();
		honey.enterOTPAndProcced(); 
		Thread.sleep(2000);
		honey.NumberIsBarredErrorMSG("Tata Power Merchant Page ");
	
	}

	// @Test(priority = 1)
	// To check if bot enter name and Emil ID 
	public void checkBotGiveInputForInvisibleFeildOnTataPowerPage() throws Throwable {
		driver.get("https://app.misscallpay.com/bill-payment/tp-western-odisha-distribution-limited-tpwodl.html");
		Waits.implicitWait(2000);
		common.enterConsumerNumber(TestData.honey(0, 1, 2));
		scroll.scrollDown(common.EnterConsumerNumber);
		common.clickOnFetchBillButton1();
		honey.billAvailableToPayBill();
		scroll.scrollDown(common.FetchedBillDetails2);
		common.clickOnPayBillButton();
		scroll.scrollDown(common.EnterPhoneNumber);
		common.enterPhoneNumber(TestData.honey(0, 2, 2));
		honey.enterPincodeFeild(TestData.honey(0, 4, 2));
		honey.enterEmailHideFeild(TestData.honey(0, 5, 2));
		common.clickOnNumberOnUPI();
		common.clickOnGetOTP();
		honey.enterOTPAndProcced(); 
		Thread.sleep(2000);
		honey.NumberIsBarredErrorMSG("Tata Power Merchant Page ");
		
	}
	  
	//  @Test(priority = 2)
		// To check if bot enter name and Emil ID 
		public void checkBotGiveInputForInvisibleFeildOnKashtBhanjanPage() throws Throwable {
			driver.get("https://app.misscallpay.com/misscall2dada.html");
			sarangpur.selectAmount();
			common.enterAmount("1");
			common.enterYourName("Yogesh");
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			scroll.scrollDown(common.EnterYourName);
			honey.enterPincodeFeild1(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild1(TestData.honey(0, 5, 2));
			common.clickOnNumberOnUPI();
			scroll.scrollDown(common.ClickNumberOnUPI);
			common.clickOnGetOTP();
			honey.enterOTPAndProcced(); 
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("KashtBhanajan Page ");
	
	  }
	
		//@Test(priority = 3)
		// To check if bot enter name and Emil ID 
		public void checkBotGiveInputForInvisibleFeildOnAgentPage() throws Throwable {
			Waits.implicitWait(1000);
			driver.get("https://app.misscallpay.com/agent.html");
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			honey.enterPincodeFeild1(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild1(TestData.honey(0, 5, 2));
			common.clickOnNumberOnUPI();
			scroll.scrollDown(common.ClickOnMobileNumberIsKLinkedToBank);
			common.clickOnGetOTP();
			honey.enterOTPAndProcced();
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("Agent Page ");
			
		}
		
		//@Test(priority = 4)
		// To check if bot enter name and Emil ID 
		public void checkBotGiveInputForInvisibleFeildOnTryPage() throws Throwable {
			Thread.sleep(3000);
			driver.get("https://app.misscallpay.com/try-now.html");
			common.selectActionWhatWantToDO();
			common.enterYourName(TestData.honey(0, 7, 2));
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			scroll.scrollDown(common.EnterPhoneNumber);
			honey.enterPincodeFeild1(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild1(TestData.honey(0, 5, 2));
			scroll.scrollDown(common.EnterYourName);
			common.clickOnNumberOnUPI();
			common.clickOnGetOTP();
			honey.enterOTPAndProcced();
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("try now page  ");
		}
		
	//	@Test(priority = 5)
		// To check if bot enter name and Emil ID 
		public void checkBotGiveInputForInvisibleFeildOnRefPage() throws Throwable {
			Thread.sleep(3000);
			driver.get("https://app.misscallpay.com/ref-now.html");
			common.selectActionWhatWantToDO();
			scroll.scrollDown(common.SelectAction);
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			scroll.scrollDown(common.EnterPhoneNumber);
			honey.enterPincodeFeild1(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild1(TestData.honey(0, 5, 2));
			common.clickOnNumberOnUPI();
			scroll.scrollDown(common.GetOTPButton);
			common.clickOnGetOTP();
			scroll.scrollDown(common.EnterOTP);
			honey.enterOTPAndProcced();
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("Ref Page");
}
		
	//	@Test(priority = 7)
		// To check if bot enter name and Email ID 
		public void checkBotGiveInputForInvisibleFeildOnMerchantGenericPage() throws Throwable {
			Thread.sleep(3000);
			driver.get("https://app.misscallpay.com/merchant_generic.html?utm_did=8066741981&utm_extension=1002");
			common.enterAmount(TestData.honey(0, 6, 2));
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			honey.enterPincodeFeild(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild(TestData.honey(0, 5, 2));
			scroll.scrollDown(common.EnterPhoneNumber);
			common.clickOnNumberOnUPI();
			common.clickOnGetOTP();
			scroll.scrollDown(common.EnterOTP);
			honey.enterOTPAndProcced();
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("Merchant Generic Page ");
		
		}
		
	//	@Test(priority=8)
		//To check if bot enter email ID and pincode on invite friend page 
		public void checkBotGiveInputForInvisibleFeildOnInviteFriendPage() throws InterruptedException, Throwable {
			Thread.sleep(3000);
			driver.get("https://app.misscallpay.com/invite_friend.html");
			scroll.scrollDown(common.LandingePage1);
			common.enterPhoneNumber(TestData.honey(0, 2, 2));
			honey.enterPincodeFeild1(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild1(TestData.honey(0, 5, 2));
			common.clickOnGetOTP();
			honey.enterOTPAndProcced();
			Thread.sleep(2000);
			honey.NumberIsBarredErrorMSG("invite friend  ");
			
		}
		
		
		//@Test(priority=9)
		//To check if bot enter email ID and pincode on ajmer page  
		public void checkBotGiveInputForInvisibleFeildOnAjmerLandingPage() throws InterruptedException, Throwable {
			Thread.sleep(3000);
			driver.get("https://app.misscallpay.com/bill-payment/tp-ajmer-distribution-limited-tpadl.html");
			Waits.implicitWait(3000);
			ajmer.enterKNumber();
			scroll.scrollDown(ajmer.KNumberField);
			common.clickOnFetchBillButton1();
			ajmer.UatBillAvailablepayBill();
			scroll.scrollDown(common.EnterYourName);
			common.enterYourName(TestData.ajmer(0, 2, 2));
			common.enterPhoneNumber(TestData.ajmer(0, 3, 2));
			honey.enterPincodeFeild(TestData.honey(0, 4, 2));
			honey.enterEmailHideFeild(TestData.honey(0, 5, 2));
			common.clickOnMobileNumberIsKLinkedToBank();
			common.clickOnDebitCardIsWithMe();
			common.clickOnNumberOnUPI();
			ajmer.payBillAsPerStatusOfUser();
			
		}
}