package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TataMerchantO2OPage extends TestBase {

	public TataMerchantO2OPage() {
		PageFactory.initElements(driver, this);
	}

	// Enter User Number
	public void enterPhoneNumber() throws Throwable {
		common.EnterPhoneNumber.click();
		common.EnterPhoneNumber.sendKeys(TestData.tataMerchant(0, 1, 1));
		log.info("User enter Phone Number ");
	}

	// To check user enter consumer number
	public void enterConsumerNumber() throws Throwable {
		Waits.implicitWait(1000);
		common.EnterConsumerNumber.click();
		common.EnterConsumerNumber.sendKeys(TestData.tataMerchant(0, 2, 1));
		log.info("User enter consumer  Number ");
	}

	// fetch Bill button
	@FindBy(xpath = "//button[@id='fetch-bill-btn-2']")
	private WebElement FetchBillButton;

	// To check uder click on Fetch Bill Button
	public void clickOnFetchBillButton() {
		FetchBillButton.click();
		log.info("User click on fetch Bill button ");

	}

	// After fetch Bill Matched Consumer number
	@FindBy(xpath = "//td[@id='bill-consumer-number']")
	private WebElement MatchConsumerNumber;

	public void matchConsumerNumber() throws Throwable {
		Waits.implicitWait(1000);
		String consumerNumber = MatchConsumerNumber.getText();
		Assert.assertEquals(consumerNumber, TestData.tataMerchant(0, 2, 1));
		log.info("Entered consumer Number and fetched Bill consumer Number Matched ");
	}

	// get consumer Name
	@FindBy(xpath = "//th[contains(@id,'consumer-name-2')]")
	private WebElement GetConsumerName;

	public String getConsumerName() {
		String consumerName = GetConsumerName.getText();
		return consumerName;
	}

	// get fetched bill amount
	@FindBy(xpath = "//span[contains(@id,'bill-due-amount-2')]")
	private WebElement GetBillAmount;

	public String getBillAmount() {
		String billAmount = GetBillAmount.getText();
		return billAmount;
	}

	// Enter Bank name
	public void enterBankName() {
		Waits.implicitWait(500);
		try {
			common.EnterBankName.click();
			common.EnterBankName.sendKeys("Bank of Maharashtra ");
			log.info("User enter bank name ");
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
	}

	// check select select language feild available or not
	public boolean checkSelectLanguageFeild() {
		Waits.implicitWait(1000);
		boolean languageFeild = common.SelectLanguage.isDisplayed();
		return languageFeild;
	}

	// Add consumer Number radio button
	@FindBy(xpath = "//input[@value='other']")
	public WebElement AddConsumerRadioButton;

	public void clickOnAddConsumerradioButton() {
		Waits.implicitWait(1000);
		AddConsumerRadioButton.click();
	}

	// Additional amount feild
	@FindBy(xpath = "//input[@id='additional-amount-input']")
	public WebElement EnterAdditionalAmount;

	public void enterAdditionalAmount(String additionalAmount) throws Throwable {
		Waits.implicitWait(1000);
		EnterAdditionalAmount.click();
		EnterAdditionalAmount.sendKeys(additionalAmount);
		log.info("User enter Additional Amount of Rs " + additionalAmount);
	}

	// To check for entered consumer number Bill available or not

	public boolean billAvailablepayBill() throws Throwable {
		Thread.sleep(7000);
		boolean billAvailable = common.fetchedBillDetails();
		if (billAvailable == true) {
			log.info("Bill Available for entered Consumer Number ");
			scroll.scrollDown(common.FetchedBillDetails);

		} else if (billAvailable == false) {
			String error_msg = common.fetchBillErrorMsg();

			if (error_msg == "Payment received for the billing period - no bill due") {
				log.info("Payment received for the billing period - no bill due");
				fail();
			} else if (error_msg == "No bill data available") {
				log.info("No bill data available");
				fail();
			} else {
				log.info(error_msg);
				fail();
			}
		}

		return billAvailable;
	}

	// pay bill of user as per status of user

	public void payBillAsPerStatusOfUser() throws Throwable {
		boolean autofetchedAccount = common.AccountAutofetched.isDisplayed();
		boolean otherAccountRadioButton = common.OtherBankRadioButton.isDisplayed();
		Thread.sleep(2000);
		if (autofetchedAccount || otherAccountRadioButton == true) {
			log.info("Pay Bill with new MCP user Flow start ");
			merchant.selectAccount();

		}

		else if (autofetchedAccount && otherAccountRadioButton == false) {
			Thread.sleep(1000);
			log.info("Pay Bill with Existing MCP user Flow start ");

		}

	}

	// To check if liked account get auto then select account from autofetched
	// account
	public void selectAccount() throws Exception, Throwable {
		Thread.sleep(3000);
		boolean account = common.AccountAutofetched.isDisplayed();
		if (account == true) {
			log.info("Linked account to enter Number get autofetched ");
			common.getAutoFetchBankAccountCount();
			Thread.sleep(2000);
		//	scroll.scrollDown(common.AutoFetchedAccountDetails);
			common.selectAutoFetchedAccount();
			merchant.enterAdditionalAmount(TestData.tataMerchant(0, 7, 2));
			scroll.scrollDown(common.SelectLanguage);
			common.selectLanguage();
			commonB.OnboardUserAsPerUPIStatus();

		}

		else if (account == false) {
			log.info("No account Auto Fetched ");
			Thread.sleep(1000);
		//	scroll.scrollDown(common.OtherBankRadioButton);
			common.clickOnOtherBankRadioButton();
			common.enterBankName(TestData.tataMerchant(0, 4, 2));
			common.SelectBankAccount();
			Thread.sleep(1000);
			merchant.enterAdditionalAmount(TestData.tataMerchant(0, 7, 2));
			scroll.scrollDown(common.SelectLanguage);
			common.selectLanguage();
			commonB.OnboardUserAsPerUPIStatus();

		}
	}
	
	// To check selected Account is new UPi account or existing UPI Account
		public void OnboardUserAsPerUPIStatus() throws IOException, Throwable {
			Waits.implicitWait(2000);
			boolean debitCardFeild = common.DebitCardNumber.isDisplayed();
			if (debitCardFeild == false) {
				log.info("Selected Account is existing UPI Account ");
				scroll.scrollDown(common.TermsAndConditionCheckBox);
				common.clickonTermsAndCondtionCheckBox();
				Thread.sleep(2000);
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				scroll.scrollDown(common.QRCode);
				common.qrCodeAvialavle();
				Thread.sleep(30000);
				common.receivedCallBackAction();
				Thread.sleep(1000);
				common.concernAction();
				Thread.sleep(1000);
				common.onboardSucessfullyAction();
				Thread.sleep(1000);
				common.verifyAmountAction();
				// Thread.sleep(1000);
				// common.enterUPIPinAction();

			}

			else if (debitCardFeild == true) {
				log.info("Selected Bank account is a New UPI Account ");
				common.enterDebitCardNumber(TestData.commonBiller(1, 4, 1));
				common.enterDebitCardExpiryDate(TestData.commonBiller(1, 5, 1));
				common.DebitCardNumber.click();
				scroll.scrollDown(common.TermsAndConditionCheckBox);
				common.clickonTermsAndCondtionCheckBox();
				Thread.sleep(10000);
				commonB.CheckDebitPinRequiredOrNot();

			}
		}

		// To check for selected account debit pin required or not
		public void CheckDebitPinRequiredOrNot() throws Throwable {
			boolean getOTPButton = common.GetUPIOTP.isDisplayed();
			if (getOTPButton == true) {
				log.info("For selected bank Debit pin is not required ");
				common.clickOnGetUPIOTP();
				Thread.sleep(1000);
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				scroll.scrollDown(common.QRCode);
				common.qrCodeAvialavle();
				Thread.sleep(10000);
				common.receivedCallBackAction();
				Thread.sleep(2000);
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
				// Thread.sleep(1000);
				// common.enterUPIPinAction();
			}

			else if (getOTPButton == false) {
				Thread.sleep(1000);
				log.info("For selected bank Debit pin is required ");
				common.dIDPopulateOn2ndpage();
				Thread.sleep(10000);
				scroll.scrollDown(common.QRCode);
				common.qrCodeAvialavle();
				Thread.sleep(30000);
				common.receivedCallBackAction();
				Thread.sleep(15000);
				common.concernAction();
				Thread.sleep(15000);
				common.verifyEnterOTPAction();
				Thread.sleep(7000);
				common.verifySetUPIPinAction();
				Thread.sleep(7000);
				common.verifyReEnterUPIPinAction();
				Thread.sleep(7000);
				common.onboardSucessfullyAction();
				Thread.sleep(5000);
				common.verifyAmountAction();
				// Thread.sleep(1000);
				// common.enterUPIPinAction();
			}
		}

}
