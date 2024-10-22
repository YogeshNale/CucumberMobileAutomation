package com.qa.pageLayer;

import static org.testng.Assert.fail;

import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class JharkhandO2OLandingePage extends TestBase {

	public JharkhandO2OLandingePage() {
		PageFactory.initElements(driver, this);
	}
	
	// To check for entered consumer number Bill available or not

		public boolean billAvailablepayBill() throws Throwable {
			Thread.sleep(5000);
			boolean billAvailable = common.fetchedBillDetails1();
			if (billAvailable == true) {
				log.info("Bill Available for entered Consumer Number ");
				common.checkConsumerNumberinFetchedBill1(TestData.Jharkhand(0, 1, 2));
				common.CheckSubDivisionNumberinFetchedBill(TestData.Jharkhand(0, 2, 2));
                common.getConsumerName1();
			
			} 
			else if (billAvailable == false) {
				String error_msg = common.fetchBillErrorMsg();

				if (error_msg == "Payment received for the billing period - no bill due") {
					log.info("Payment received for the billing period - no bill due");
					fail();
				} 
				else if (error_msg == "No bill data available") {
					log.info("No bill data available");
					fail();
				} else {
					log.info(error_msg);
					fail();
				}
			}

			return billAvailable;
		}
		
		//pay Bill as status of user 
		public void payBillAsPerStatusOfUser() throws Throwable {
			Waits.implicitWait(1000);
			boolean DIDPopulate = common.dIDPopulateOn1stPage();
			boolean getOTP = common.getOTPButton();
			
			if(DIDPopulate == true) {
				log.info("User is existing MCP user pay Bill with existing MCP user flow start ");
				Thread.sleep(10000);
				scroll.scrollDown(common.QRCode);
				common.qrCodeAvialavle();
				Thread.sleep(6000);
				common.checkUserRedirectOn3rdPage();
				common.checkEnteredName(TestData.Jharkhand(0, 3, 2));
				scroll.scrollDown(common.getName);
				Thread.sleep(1000);
				common.receivedCallBackAction();
				Thread.sleep(1000);
				common.verifyAmountAction();
				
			}
			
			else if (getOTP == true ) {
				log.info(" User is new MCP User pay bill with new MCp user start  ");
				common.clickOnGetOTP();
				common.enterOTP();
				Thread.sleep(16000);
				common.clickONProceedButton();
				
			}
		}
	
}
