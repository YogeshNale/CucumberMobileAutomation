package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class TataPowerLandingPage extends TestBase {

	public TataPowerLandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Bill details available table
	@FindBy(xpath = "(//div[contains(@id,'bill-details')])[1]")
	public WebElement BillDetails;

	// To check if user enter existing MCP user phone Number
	public void enterUserPhoneNumber() throws Exception {
		Thread.sleep(1000);
		common.EnterPhoneNumber.click();
		common.EnterPhoneNumber.sendKeys(TestData.TataPower(0, 1, 1));
		log.info("User enter mobile umber " + TestData.TataPower(0, 1, 1));

	}

	// scroll on enter your name feild
	public void scrollOnEnterYourName() {
		Waits.implicitWait(1000);
		scroll.scrollDown(common.EnterYourName);
	}

	// To check if user enter consumer number on which Bill is available
	public void enterConsumerNumber() throws IOException, InterruptedException {

		common.EnterConsumerNumber.click();
		common.EnterConsumerNumber.sendKeys(TestData.TataPower(0, 2, 1));
		log.info("User enter consumer Number " + TestData.TataPower(0, 2, 1));
		Thread.sleep(1000);

	}

	// scroll on consumer number feild
	public void scrollOnconsumerNumberFeild() throws InterruptedException {
		scroll.scrollDown(common.EnterConsumerNumber);
		Thread.sleep(1000);

	}

	// check Bill type after fetc bill
	@FindBy(xpath = "//span[text()='Electricity Bill']")
	private WebElement checkBillType;

	public String checkBillType() {
		Waits.implicitWait(1000);
		String BillType = checkBillType.getText();
		Assert.assertEquals(BillType, "Electricity Bill");
		return BillType;
	}

	// check cunsumer number in fetched bill
	@FindBy(xpath = "(//span[@id='bill-consumer-number'])[1]")
	private WebElement CheckConsumerNumberinFetchedBill;

	public String checkConsumerNumberinFetchedBill() throws Throwable {
		Waits.implicitWait(1000);
		String consumerNumber = CheckConsumerNumberinFetchedBill.getText();
		Assert.assertEquals(consumerNumber, TestData.TataPower(0, 2, 1));
		log.info("Entered consumer number and consumer number in fetched bill matched ");
		return consumerNumber;
	}

	// get consumer name of fetched bill
	@FindBy(xpath = "//span[@id='consumer-name']")
	private WebElement GetConsumerName;
	String consumerName;

	public String getConsumerName() {
		Waits.implicitWait(1000);
		consumerName = GetConsumerName.getText();
		return consumerName;
	}

	// get fetched bill amount
	@FindBy(xpath = "(//span[@id='bill-due-amount'])[1]")
	private WebElement GetBillAmont;

	public String getBillAmount() {
		Waits.implicitWait(1000);
		String billAmount = GetBillAmont.getText();
		return billAmount;
	}

	// check consumer number for fetched bill
	@FindBy(xpath = "(//span[@id='consumer-name'])[1]")
	private WebElement GetConsumerNameOfFetchedBill;

	public String getConsumerNameOfFetchedBill() {
		Waits.implicitWait(1000);
		String consumerName = GetConsumerNameOfFetchedBill.getText();
		return consumerName;
	}

	// Matched enterd user name on 3rd page
	@FindBy(xpath = "//span[@id='user-name-2']")
	private WebElement CheckEnteredUserName;

	public String checkEnteredUserName() throws Throwable {
		Waits.implicitWait(1000);
		String enteredUserName = CheckEnteredUserName.getText();
		Assert.assertEquals(enteredUserName, TestData.TataPower(0, 3, 1));
		log.info("Enter user name Matched ");
		return enteredUserName;
	}

	// check consumer name on 3rd page
	@FindBy(xpath = "//h5[@id='account-holder-name-2']")
	private WebElement CheckConsumerName;

	public String checkConsumerName() {
		Waits.implicitWait(1000);
		String checkConsumerName = CheckConsumerName.getText();
		Assert.assertEquals(checkConsumerName, consumerName);
		log.info("Display consumer number matched to consumer number available in bill ");
		return checkConsumerName;

	}

	// get bill amount of fetched bill
	@FindBy(xpath = "//span[@id='bill-amount']")
	public WebElement GetAmount;

	public String getAmount() {
		Waits.implicitWait(1000);
		String getAmount = GetAmount.getText();
		System.out.println(getAmount);
		return getAmount;
	}

	// scroll on consumer name
	public void scrollOnConsumerName() {
		Waits.implicitWait(1000);
		scroll.scrollDown(CheckConsumerName);
	}

	// scroll on verify Bill amount action
	public void scrollOnBillAmountAction() {
		Waits.implicitWait(1000);
		scroll.scrollDown(common.VerifyAmountAction);
	}

	// scroll on bill name
	@FindBy(xpath = "//select[@id='billername-input']")
	public WebElement BillerName;

	public void scollOnBillerName() {
		Waits.implicitWait(1000);
		scroll.scrollDown(BillerName);
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

	// To check for entered consumer number Bill available or not

	public boolean UatBillAvailablepayBill() throws Throwable {
		Thread.sleep(3000);
		boolean billAvailable = BillDetails.isDisplayed();
		if (billAvailable == true) {
			scroll.scrollDown(BillDetails);
			common.checkConsumerNumberinFetchedBill(TestData.TataPower(0, 1, 2));
			common.getConsumerName();
			common.getBillAmount();
			Waits.implicitWait(2000);
			scroll.scrollDownFalse(common.ClickOnPayBillButton);
			common.clickOnPayBillButton();
			common.enterPhoneNumber(TestData.TataPower(0, 2, 2));
			scroll.scrollDown(common.EnterPhoneNumber);
			common.clickOnNumberOnUPI();
			common.clickOnDebitCardIsWithMe();

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
			} 
			else {
				log.info(error_msg);
				fail();
			}
		}

		return billAvailable;
	}

	// pay bill of user as per status of user

	public void UatPayBillAsPerStatusOfUser() throws Throwable {
		Thread.sleep(3000);
		boolean did = common.dIDPopulateOn1stPage();
		boolean otp = common.getOTPButton();

		if (did == true) {
			scroll.scrollDown(common.DIDPopulate1stPage);
			log.info("DID Populate & Pay Bill with Existing MCP user Flow start ");
			Thread.sleep(10000);
			scroll.scrollDown(common.DIDPopulate1stPage);
			common.qrCodeAvialavle();
			Thread.sleep(17000);
			common.receivedCallBackAction();
			Thread.sleep(25000);
			common.verifyAmountAction();
			tata.scrollOnBillAmountAction();

		}

		else if (otp == true) {
			common.clickOnGetOTP();
			log.info("Pay bill with new MCP User flow start ");
			common.enterOTP();
			Thread.sleep(15000);
			common.clickONProceedButton();
			Waits.implicitWait(5000);
			scroll.scrollDownFalse(common.EnterBankName);
			common.selectLanguage();
			tata.enterBankName();
			common.SelectBankAccount();
			common.clickonTermsAndCondtionCheckBox();
			scroll.scrollDown(common.TermsAndConditionCheckBox);
			common.dIDPopulateOn2ndpage();
			common.qrCodeAvialavle();
			Thread.sleep(10000);
			common.checkUserRedirectOn3rdPage();
			tata.checkEnteredUserName();
			tata.checkConsumerName();
			tata.scrollOnConsumerName();
			common.receivedCallBackAction();
			common.concernAction();
			common.onboardSucessfullyAction();
			Thread.sleep(10000);
			common.verifyAmountAction();
			tata.scrollOnBillAmountAction();
			common.qrCodeAvialavle();

		}

		else if (did || otp == false) {
			log.info(" DID not get populate or Get OTP button also ");
			fail();
		}

	}

	// To check for entered consumer number Bill available or not

	public boolean billAvailablepayBill() throws Throwable {
		Thread.sleep(10000);
		boolean billAvailable = BillDetails.isDisplayed();
		if (billAvailable == true) {
			Thread.sleep(1000);
		//	tata.checkConsumerNumberinFetchedBill();
			//tata.getConsumerName();
			//tata.getBillAmount();
			scroll.scrollDown(BillDetails);
			common.clickOnPayBillButton();
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
		boolean did = common.dIDPopulateOn1stPage();
		boolean otp = common.getOTPButton();

		if (did == true) {
			scroll.scrollDown(common.DIDPopulate1stPage);
			log.info("Pay Bill with Existing MCP user Flow start ");
			Thread.sleep(12000);
			scroll.scrollDown(common.DIDPopulate1stPage);
			//common.qrCodeAvialavle();
			Thread.sleep(12000);
			//common.checkUserRedirectOn3rdPage();
			//tata.checkEnteredUserName();
			//tata.checkConsumerName();
			//tata.scrollOnConsumerName();
			common.receivedCallBackAction();
			Thread.sleep(25000);
			common.verifyAmountAction();
			tata.scrollOnBillAmountAction();
			//common.qrCodeAvialavle();

		}

		else if (otp == true) {
			common.clickOnGetOTP();
			log.info("Pay bill with new MCP User flow start ");
			Thread.sleep(15000);
			common.clickONProceedButton();
			common.checkUserRedirectOn2rdPage();
			scroll.scrollDown(common.BillDetails2ndPage);
			common.selectLanguage();
			tata.enterBankName();

			common.SelectBankAccount();
			common.clickonTermsAndCondtionCheckBox();
			scroll.scrollDown(common.TermsAndConditionCheckBox);
			common.dIDPopulateOn2ndpage();
			common.qrCodeAvialavle();
			Thread.sleep(10000);
			common.checkUserRedirectOn3rdPage();
			tata.checkEnteredUserName();
			tata.checkConsumerName();
			tata.scrollOnConsumerName();
			common.receivedCallBackAction();
			common.concernAction();
			common.onboardSucessfullyAction();
			Thread.sleep(10000);
			common.verifyAmountAction();
			tata.scrollOnBillAmountAction();
			common.qrCodeAvialavle();

		}

		else if (did || otp == false) {
			log.info(" DID not get populate or Get OTP button also ");
			fail();
		}

	}

}
