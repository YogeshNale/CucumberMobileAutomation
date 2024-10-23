package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class KashtBhanjanTrust extends TestBase {

	public KashtBhanjanTrust() {
		PageFactory.initElements(driver, this);
	}

	// select donation amount
	@FindBy(xpath = "//select[@id='donate-amount-select']")
	private WebElement SelectAmount;

	public void selectAmount() {
		Waits.implicitWait(1000);
		SelectAmount.click();
		Select amount = new Select(SelectAmount);
		amount.selectByIndex(3);
		log.info("User select other amount option to select ");
	}

	
	// check entered amount on 3rd page
	@FindBy(xpath = "//span[@id='bill-amount']")
	private WebElement getAmount;

	public String checkEnteredAmount() throws Throwable {
		Waits.implicitWait(1000);
		String enterdAmount = getAmount.getText();
		Assert.assertEquals(enterdAmount, TestData.sarangpur(0, 1, 1));
		log.info("Entered amount match");
		return enterdAmount;
	}

	

	// Enter Bank name
	public void enterBankName() {
		Waits.implicitWait(500);
		try {
			common.EnterBankName.click();
			common.EnterBankName.sendKeys(TestData.sarangpur(0, 4, 1));
			log.info("User enter bank name ");
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}

	// Enter Bank name
	public void UATEnterBankName() {
		Waits.implicitWait(500);
		try {
			common.EnterBankName.click();
			common.EnterBankName.sendKeys(TestData.sarangpur(0, 4, 2));
			log.info("User enter bank name ");
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}

	// scroll on select language drop down
	public void scrollOnselectLang() {
		Waits.implicitWait(1000);
		scroll.scrollDown(common.SelectLanguage);
	}

	

	
	

	// uat kasht bhanajan trust
	public void UATDonateAmountPerStatusOfUser() throws Throwable {
		Thread.sleep(10000);
		boolean did = common.dIDPopulateOn1stPage();
		boolean otp = common.getOTPButton();

		if (did == true) {
			log.info("Donate Amount with Existing MCP user flow start ");
			Thread.sleep(5000);
			common.checkUserRedirectOn3rdPage();
			common.checkEnteredName(TestData.sarangpur(0, 2, 2));
			scroll.scrollDown(common.getName);
			Thread.sleep(5000);
			common.receivedCallBackAction();
			common.verifyAmountAction();
			// Thread.sleep(12000);
			// common.enterUPIPinAction();

		}

		else if (otp == true) {
			log.info("Donate Amount with new MCP with existing UPI account  user flow start ");
			common.clickOnGetOTP();
			Thread.sleep(500);
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			common.checkUserRedirectOn2rdPage();
			common.selectLanguage();
		    common.enterBankName(TestData.sarangpur(0, 4, 2));
			scroll.scrollDown(common.SelectLanguage);
			Thread.sleep(1000);
			common.SelectBankAccount();
			sarangpur.uatOnboardUserAsPerUPIStatus();

		}

		else if (did || otp == false) {
			log.info("DID OR Get OTP Button both not get populate ");
			fail();

		}

	}
	
	
	// To check selected Account is new UPi account or existing UPI Account
		public void uatOnboardUserAsPerUPIStatus() throws IOException, Throwable {
			Waits.implicitWait(2000);
			boolean debitCardFeild = common.DebitCardNumber.isDisplayed();
			if (debitCardFeild == false) {
				log.info("Selected Account is existing UPI Account ");
				common.clickonTermsAndCondtionCheckBox();
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				common.checkUserRedirectOn3rdPage();
				common.checkEnteredName(TestData.sarangpur(0, 2, 2));
				scroll.scrollDown(common.getName);
				Thread.sleep(5000);
				common.receivedCallBackAction();
				common.concernAction();
				common.onboardSucessfullyAction();
				Thread.sleep(1000);
				common.verifyAmountAction();
			//	Thread.sleep(1000);
			//	common.enterUPIPinAction();

			}

			else if (debitCardFeild == true) {
				log.info("Selected Bank account is a New UPI Account ");
				common.clickonTermsAndCondtionCheckBox();
				common.enterDebitCardNumber(TestData.sarangpur(0, 5, 2));
				common.enterDebitCardExpiryDate(TestData.sarangpur(0, 6, 2));
				common.DebitCardNumber.click();
				sarangpur.uatCheckDebitPinRequiredOrNot();
				
				
			}
		}
		
		
		// To check for selected account debit pin required or not
		public void uatCheckDebitPinRequiredOrNot() throws Throwable {
			boolean getOTPButton = common.GetUPIOTP.isDisplayed();
			if (getOTPButton == true) {
				log.info("For selected bank Debit pin is not required ");
				common.clickOnGetUPIOTP();
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				common.checkUserRedirectOn3rdPage();
				common.checkEnteredName(TestData.sarangpur(0, 2, 2));
				scroll.scrollDown(common.getName);
				Thread.sleep(5000);
				common.receivedCallBackAction();
				Thread.sleep(1000);
				common.concernAction();
				Thread.sleep(2000);
				common.verifyEnterOTPAction();
				Thread.sleep(1000);
				common.verifySetUPIPinAction();
				Thread.sleep(1000);
				common.verifyReEnterUPIPinAction();
				Thread.sleep(1000);
				common.onboardSucessfullyAction();
				Thread.sleep(1000);
				common.verifyAmountAction();
				//Thread.sleep(1000);
				//common.enterUPIPinAction();
			} 
			
			else if (getOTPButton == false) {
				Thread.sleep(1000);
				log.info("For selected bank Debit pin is required ");
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				common.checkUserRedirectOn3rdPage();
				common.checkEnteredName(TestData.sarangpur(0, 2, 2));
				scroll.scrollDown(common.getName);
				Thread.sleep(30000);
				common.receivedCallBackAction();
				common.concernAction();
				Thread.sleep(5000);
				common.verifyEnterOTPAction();
				Thread.sleep(5000);
				common.verifySetUPIPinAction();
				Thread.sleep(5000);
				common.verifyReEnterUPIPinAction();
				Thread.sleep(5000);
				common.onboardSucessfullyAction();
				Thread.sleep(5000);
				common.verifyAmountAction();
			//	Thread.sleep(1000);
			//	common.enterUPIPinAction();
			}
		}
		// uat kasht bhanajan trust
		public void donateAmountPerStatusOfUser() throws Throwable {
			Thread.sleep(5000);
			boolean did = common.dIDPopulateOn1stPage();
			boolean otp = common.getOTPButton();

			if (did == true) {
				log.info("Donate Amount with Existing MCP user flow start ");
				Thread.sleep(5000);
				common.checkUserRedirectOn3rdPage();
				common.checkEnteredName(TestData.sarangpur(0, 2, 1));
				scroll.scrollDown(common.getName);
				Thread.sleep(5000);
				common.receivedCallBackAction();
				common.verifyAmountAction();
				// Thread.sleep(12000);
				// common.enterUPIPinAction();

			}

			else if (otp == true) {
				log.info("Donate Amount with new MCP with existing UPI account  user flow start ");
				common.clickOnGetOTP();
				Thread.sleep(500);
				common.enterOTP();
				Thread.sleep(15000);
				common.clickONProceedButton();
				common.checkUserRedirectOn2rdPage();
				common.selectLanguage();
			    common.enterBankName(TestData.sarangpur(0, 4, 1));
				scroll.scrollDown(common.SelectLanguage);
				Thread.sleep(1000);
				common.SelectBankAccount();
				sarangpur.productionOnboardUserAsPerUPIStatus();

			}

			else if (did || otp == false) {
				log.info("DID OR Get OTP Button both not get populate ");
				fail();

			}

		}
		
		
		// To check selected Account is new UPi account or existing UPI Account
			public void productionOnboardUserAsPerUPIStatus() throws IOException, Throwable {
				Waits.implicitWait(2000);
				boolean debitCardFeild = common.DebitCardNumber.isDisplayed();
				if (debitCardFeild == false) {
					log.info("Selected Account is existing UPI Account ");
					common.clickonTermsAndCondtionCheckBox();
					Thread.sleep(3000);
					common.dIDPopulateOn2ndpage();
					Thread.sleep(10000);
					common.checkUserRedirectOn3rdPage();
					common.checkEnteredName(TestData.sarangpur(0, 2, 1));
					scroll.scrollDown(common.getName);
					Thread.sleep(5000);
					common.receivedCallBackAction();
					common.concernAction();
					common.onboardSucessfullyAction();
					Thread.sleep(1000);
					common.verifyAmountAction();
				//	Thread.sleep(1000);
				//	common.enterUPIPinAction();

				}

				else if (debitCardFeild == true) {
					log.info("Selected Bank account is a New UPI Account ");
					common.clickonTermsAndCondtionCheckBox();
					common.enterDebitCardNumber(TestData.sarangpur(0, 5, 1));
					common.enterDebitCardExpiryDate(TestData.sarangpur(0, 6, 1));
					common.DebitCardNumber.click();
					sarangpur.productionCheckDebitPinRequiredOrNot();
					
					
				}
			}
			
			
			// To check for selected account debit pin required or not
			public void productionCheckDebitPinRequiredOrNot() throws Throwable {
				boolean getOTPButton = common.GetUPIOTP.isDisplayed();
				if (getOTPButton == true) {
					log.info("For selected bank Debit pin is not required ");
					common.clickOnGetUPIOTP();
					common.dIDPopulateOn2ndpage();
					Thread.sleep(10000);
					common.checkUserRedirectOn3rdPage();
					common.checkEnteredName(TestData.sarangpur(0, 2, 2));
					scroll.scrollDown(common.getName);
					Thread.sleep(5000);
					common.receivedCallBackAction();
					Thread.sleep(1000);
					common.concernAction();
					Thread.sleep(2000);
					common.verifyEnterOTPAction();
					Thread.sleep(1000);
					common.verifySetUPIPinAction();
					Thread.sleep(1000);
					common.verifyReEnterUPIPinAction();
					Thread.sleep(1000);
					common.onboardSucessfullyAction();
					Thread.sleep(1000);
					common.verifyAmountAction();
					//Thread.sleep(1000);
					//common.enterUPIPinAction();
				} 
				
				else if (getOTPButton == false) {
					Thread.sleep(1000);
					log.info("For selected bank Debit pin is required ");
					common.dIDPopulateOn2ndpage();
					Thread.sleep(10000);
					common.checkUserRedirectOn3rdPage();
					common.checkEnteredName(TestData.sarangpur(0, 2, 2));
					scroll.scrollDown(common.getName);
					Thread.sleep(30000);
					common.receivedCallBackAction();
					common.concernAction();
					Thread.sleep(5000);
					common.verifyEnterOTPAction();
					Thread.sleep(5000);
					common.verifySetUPIPinAction();
					Thread.sleep(5000);
					common.verifyReEnterUPIPinAction();
					Thread.sleep(5000);
					common.onboardSucessfullyAction();
					Thread.sleep(5000);
					common.verifyAmountAction();
				//	Thread.sleep(1000);
				//	common.enterUPIPinAction();
				}
			}

	

}
