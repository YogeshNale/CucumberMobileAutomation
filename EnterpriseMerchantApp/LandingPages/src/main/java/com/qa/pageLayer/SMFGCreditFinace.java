package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;
import com.qa.utility.Scroll;
import com.qa.utility.Waits;

public class SMFGCreditFinace extends TestBase{
	public SMFGCreditFinace() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Loan Account Number']")
	public WebElement enterLoanNumber;
	
	

	// fetched Bill details block
	@FindBy(xpath = "//div[@id='bill-details-div-2']")
	public WebElement FethedBillDetails;

	public boolean fethedBillDetails() throws Throwable {
		Thread.sleep(1000);
		boolean BillDetails = FethedBillDetails.isDisplayed();

		return BillDetails;
	}

	// if bill not fetch error msg
	@FindBy(xpath = "//div[contains(@id,'fetch-bill-error-msg')]")
	public WebElement FetchBill_errorMsg;

	// after fetch Bill error msg

	@FindBy(xpath = "//div[@id='Loan-Account-Number-error-msg']")
	public WebElement InvalidConsumerNumberError;

	// bill alredy paid error
	@FindBy(xpath = "//div[text()='Woah! Your current bills seems paid,']")
	public WebElement BillAlredyPaidError;

	// Loan account number
	@FindBy(xpath = "//input[@placeholder='Loan Number']")
	public WebElement LoanNumber;

	// To check if bill not fetch then error msg
	public String errorMsgs() throws InterruptedException {
		Thread.sleep(1000);
		String msg = null;
		if (FetchBill_errorMsg.isDisplayed()) {
			msg = FetchBill_errorMsg.getText();
		}

		else if (InvalidConsumerNumberError.isDisplayed()) {
			msg = InvalidConsumerNumberError.getText();

		}

		else if (BillAlredyPaidError.isDisplayed()) {
			msg = BillAlredyPaidError.getText();

		}

		else {
			log.info("not define error msg get");
		}
		return msg;
	}

	// Fetch Bill amount
	@FindBy(xpath = "//p[@id='bill-due-amount-2']")
	public WebElement FetchedBillAmount;

	public String fetchedBillAmount() {
		String amount = FetchedBillAmount.getText();
		log.info("for Entered Consumer Number " + amount + " Amount Bill AVilable");
		return amount;
	}

	

	// To check for entered consumer number Bill available or not

	public boolean billAvailablepayBill() throws Throwable {
		boolean billAvailable = fethedBillDetails();
		if (billAvailable == true) {
			log.info("Bill Available for entered Consumer Number ");

		} else if (billAvailable == false) {
			String error_msg = errorMsgs();

			if (error_msg == "Payment received for the billing period - no bill due") {
				log.info("Payment received for the billing period - no bill due");
			} else if (error_msg == "No bill data available") {
				log.info("No bill data available");
			
			} else if (error_msg.equals("Please enter valid 15 digit numeric Loan Account Number")) {
				log.info("Entered Consumer Number is invalid ");
				fail();

			}

			else if (error_msg.equals(error_msg)) {
				log.info("For Entered Consumer Number Bill Is Alredy Paid ");
			} else {

				log.info(error_msg);
				fail();
			}
		}

		return billAvailable;
	}

	// pay bill process by checking using onboarded status on Misscallpay
	public void payBillAsPerStatusOfUser() throws Throwable {
		Waits.implicitWait(2000);
		boolean autofetchedAccount = common.accountAutofetched();
		boolean otherAccountRadioButton = common.otherBankRadioButton();
		boolean onboardingStatus = autofetchedAccount && otherAccountRadioButton;
		if (autofetchedAccount || otherAccountRadioButton == true) {
			log.info("Pay Bill with new MCP user Flow start ");
			if (autofetchedAccount == true) {
				common.select1stAutofetchedBank();
				Thread.sleep(1000);
				Scroll.ScrollPage(common.SelectLanguage);
				Thread.sleep(1000);
				common.selectLanguage(1);
				OnboardUserAsPerUPIStatus();
			}

			else if (autofetchedAccount == false) {
				Scroll.ScrollPage(common.OtherBankRadioButton);
				Thread.sleep(1000);
				common.clickOnOtherBankRadioButton();
				common.enterBankName("INDUSIND BANK");
				Waits.implicitWait(10000);
				common.selectBankAccount(1);
				Scroll.ScrollPage(common.SelectLanguage);
				Thread.sleep(1000);
				common.selectLanguage(1);
				OnboardUserAsPerUPIStatus();

			}

		}

		else if (onboardingStatus == false) {
			log.info("User is existing Misscall Pay customer ,Pay Bill with Existing MCP user Flow start ");
			Waits.implicitWait(1000);
			Scroll.ScrollPage(common.TermsAndCondition);
			common.clickOnTermsAndCondition();
			Thread.sleep(4000);
			Scroll.ScrollPage(common.QRImage);
			Thread.sleep(1000);
			common.qrImage("Yes");
			Waits.implicitWait(2000);
			common.clickToPayButton();
			Waits.implicitWait(3000);
			common.checkIntenetReceivedTextShowOnUI();

		}

		else {
			log.info("Not Able to idetify user Onboarded or not ");
		}

	}

	// To check selected Account is new UPi account or existing UPI Account
	public void OnboardUserAsPerUPIStatus() throws IOException, Throwable {
		Waits.implicitWait(2000);
		boolean debitCardFeild = common.DebitCardNumber.isDisplayed();
		if (debitCardFeild == false) {
			log.info("Selected Account is existing UPI Account,Onboarding with existing UPI User Start");
			Scroll.ScrollPage(common.TermsAndCondition);
			Thread.sleep(1000);
			common.clickOnTermsAndCondition();
			Thread.sleep(4000);
			common.qrImage("Yes");
			Waits.implicitWait(2000);
			common.clickToPayButton();
			Waits.implicitWait(2000);
			common.checkIntenetReceivedTextShowOnUI();

		}

		else if (debitCardFeild == true) {
			log.info("Selected Bank account is a New UPI Account, oboarding User With Debit Card Details flow start ");
			common.enterDebitCradNumber("123456");
			Scroll.ScrollPage(common.DebitCardNumber);
			common.enterDebitCardExpityMonthYear("1234");
			Scroll.ScrollPage(common.TermsAndCondition);
			common.clickOnElement(common.TermsAndCondition);
			Thread.sleep(5000);
			CheckDebitPinRequiredOrNot();

		}
	}

	// To check for selected account debit pin required or not
	public void CheckDebitPinRequiredOrNot() throws Throwable {
		boolean getUPIOTPButton = common.GetUPIOtp.isDisplayed();
		if (getUPIOTPButton == true) {
			log.info("For selected bank Debit pin is not required ");
			Scroll.ScrollPage(common.GetUPIOtp);
			Thread.sleep(1000);
			common.ClickOnGetUPIOTP();
			Thread.sleep(5000);
			boolean DID = common.clickToPayAvailable();
			if (DID == true) {
				log.info("UPI OTP sended on User Number and calling DID populate");
				Thread.sleep(4000);
				common.qrImage("Yes");
				Waits.implicitWait(2000);
				common.clickToPayButton();
				Waits.implicitWait(2000);
				common.checkIntenetReceivedTextShowOnUI();
			}

			else {
				log.info("User Click on Get UPI OTP Button but DID not Populate on 2nd page  ");
				fail();
			}

		}

		else if (getUPIOTPButton == false) {
			Thread.sleep(1000);
			log.info("For selected bank Debit pin is required Which need to Enter on IVR ");
			boolean DID = common.clickToPayAvailable();
			if (DID == true) {
				log.info("Calling DID populated on UI");
				Thread.sleep(4000);
				common.qrImage("Yes");
				Waits.implicitWait(2000);
				common.clickToPayButton();
				Waits.implicitWait(2000);
				common.checkIntenetReceivedTextShowOnUI();
			} else {
				log.info("DID Not populate on 2nd page ");
				fail();
			}

		}
	}

}
