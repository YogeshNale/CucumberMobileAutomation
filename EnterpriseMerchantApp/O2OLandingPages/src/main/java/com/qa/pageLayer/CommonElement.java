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

public class CommonElement extends TestBase {

	public CommonElement() {
		PageFactory.initElements(driver, this);
	}

	// enter Phone Number (Tata power , agent , try ,ref , kashtBhanjan)
	@FindBy(xpath = "//input[@id='phone-number-input']")
	public WebElement EnterPhoneNumber;

	public void enterPhoneNumber(String a) {
		Waits.implicitWait(1000);
		EnterPhoneNumber.click();
		EnterPhoneNumber.sendKeys(a);
	}

	// Enter your Name (tata Power , KashtBhanjan )
	@FindBy(xpath = "//input[@id='user-name-input']")
	public WebElement EnterYourName;

	public void enterYourName(String a) throws IOException, InterruptedException {
		Thread.sleep(1000);
		EnterYourName.click();
		EnterYourName.sendKeys(a);

	}

	// Enter Consumer Number
	@FindBy(xpath = "//input[@id='Consumer-Number-input']")
	public WebElement EnterConsumerNumber;

	public void enterConsumerNumber(String a) {
		Waits.implicitWait(1000);
		EnterConsumerNumber.click();
		EnterConsumerNumber.sendKeys(a);
	}

	// Bill details available table
	@FindBy(xpath = "(//div[contains(@id,'bill-details')])[1]")
	public WebElement BillDetails;

	// Allow permission number is on UPI platform (Tata power , agent , try ,ref ,
	// kashtBhanjan)
	@FindBy(xpath = "//input[@id='number-is-on-upi']")
	public WebElement ClickNumberOnUPI;

	public void clickOnNumberOnUPI() throws InterruptedException {
		Thread.sleep(1000);
		ClickNumberOnUPI.click();
		log.info("user click on Number on UPI checkbox ");
	}

	// check cunsumer number in fetched bill
	@FindBy(xpath = "//input[@id='Consumer-Number-input']")
	private WebElement CheckConsumerNumberinFetchedBill;

	public String checkConsumerNumberinFetchedBill(String a) throws Throwable {
		Waits.implicitWait(1000);
		String consumerNumber = CheckConsumerNumberinFetchedBill.getText();
		Assert.assertEquals(consumerNumber, a);
		log.info("Entered consumer number and consumer number in fetched bill matched ");
		return consumerNumber;
	}

	// Consumer Number in fetched Bill
	@FindBy(xpath = "(//span[@id='bill-consumer-number'])[1]")
	public WebElement CheckConsumerNumberinFetchedBill1;

	public String checkConsumerNumberinFetchedBill1(String a) {
		Waits.implicitWait(1000);
		String consumerNumber = CheckConsumerNumberinFetchedBill1.getText();
		Assert.assertEquals(consumerNumber, a);
		log.info("Entered consumer number and consumer number in fetched bill matched ");
		return consumerNumber;
	}

	// Consumer Number in fetched Bill for common biller
	@FindBy(xpath = "(//td[@id='bill-consumer-number'])[1]")
	public WebElement CheckConsumerNumberinFetchedBill2;

	public String checkConsumerNumberinFetchedBill2(String a) {
		Waits.implicitWait(1000);
		String consumerNumber = CheckConsumerNumberinFetchedBill1.getText();
		Assert.assertEquals(consumerNumber, a);
		log.info("Entered consumer number and consumer number in fetched bill matched ");
		return consumerNumber;
	}

	// sub division Number in fetched Bill
	@FindBy(xpath = "(//span[@id='bill-consumer-number'])[2]")
	public WebElement CheckSubDivisionNumberinFetchedBill;

	public String CheckSubDivisionNumberinFetchedBill(String a) {
		Waits.implicitWait(1000);
		String subDivisionNumber = CheckSubDivisionNumberinFetchedBill.getText();
		Assert.assertEquals(subDivisionNumber, a);
		log.info("Entered sub division  number and sub division  number in fetched bill matched ");
		return subDivisionNumber;
	}

	// get consumer name of fetched bill
	@FindBy(xpath = "//th[@id='consumer-name']")
	private WebElement GetConsumerName;
	String consumerName;

	public String getConsumerName() {
		Waits.implicitWait(1000);
		consumerName = GetConsumerName.getText();
		return consumerName;
	}

	// get consumer name of fetched bill
	@FindBy(xpath = "//input[@placeholder='Enter your name']")
	private WebElement GetConsumerName1;
	String consumerName1;

	public String getConsumerName1() {
		consumerName1 = GetConsumerName1.getText();
		return consumerName1;
	}

	// get fetched bill amount
	@FindBy(xpath = "(//span[@id='bill-due-amount'])[1]")
	public WebElement GetBillAmont;

	public String getBillAmount() {
		Waits.implicitWait(1000);
		String billAmount = GetBillAmont.getText();
		return billAmount;
	}

	// Allow permission Mobile Number is linked to Bank account (Tata power , agent
	// , try ,ref ,
	// kashtBhanjan)
	@FindBy(xpath = "//input[@id='number-is-linked-to-bank']")
	public WebElement ClickOnMobileNumberIsKLinkedToBank;

	public void clickOnMobileNumberIsKLinkedToBank() throws InterruptedException {
		Thread.sleep(2000);
		ClickOnMobileNumberIsKLinkedToBank.click();
		log.info("user click on Mobile number linked to bank checkbox ");

	}

	// Allow permission My Debit card is with me (Tata power , agent , try ,ref ,
	// kashtBhanjan)
	@FindBy(xpath = "//input[@id='atm-debit-handy']")
	public WebElement ClickOnDebitCardIsWithMe;

	public void clickOnDebitCardIsWithMe() throws InterruptedException {
		Thread.sleep(1000);
		scroll.scrollDown(ClickOnDebitCardIsWithMe);
		ClickOnDebitCardIsWithMe.click();
		log.info("user click on debit card with me checkbox");
	}

	// To check DID get Populate or not
	@FindBy(xpath = "//button[@id='miss-call-btn-0']")
	public WebElement DIDPopulate1stPage;

	public boolean dIDPopulateOn1stPage() throws InterruptedException {
		Thread.sleep(1000);
		boolean CalleeDID = DIDPopulate1stPage.isDisplayed();
		return CalleeDID;

	}

	// biller name dropdown
	@FindBy(xpath = "//select[@id='billername-input']")
	public WebElement BillerNameDropDown;

	// To check after select bank details and click on Terms and condition DID get
	// populate to onboard
	@FindBy(xpath = "//button[@id='miss-call-btn']")
	public WebElement DIDPopulateOn2ndpage;

	public boolean dIDPopulateOn2ndpage() throws InterruptedException {
		Thread.sleep(1000);
		boolean calleeDID2nd = DIDPopulateOn2ndpage.isDisplayed();

		if (calleeDID2nd == true) {
			log.info("DID is populate on 2nd page ");
		} else if (calleeDID2nd == false) {
			log.info("DID not populate on 2nd page ");
			fail();
		}

		return calleeDID2nd;
	}

	// Receive call back Action
	@FindBy(xpath = "//div[@id='get-call-step']")
	public WebElement ReceivedCallBackAction;

	public boolean receivedCallBackAction() throws InterruptedException {
		boolean CallBackAction = ReceivedCallBackAction.isDisplayed();
		if (CallBackAction == true) {
			log.info("user received call back ");

		} else if (CallBackAction == false) {
			Thread.sleep(1000);
			log.info("user not received call back or Received call back action not marked as ok ");
			fail();
		}

		return CallBackAction;
	}

	// Verify Amount Action
	@FindBy(xpath = "//div[@id='verifying-amount-step']")
	public WebElement VerifyAmountAction;

	public boolean verifyAmountAction() throws Throwable {
		Thread.sleep(7000);
		boolean AmountAction = VerifyAmountAction.isDisplayed();

		if (AmountAction == true) {
			log.info("amount action marked as ok  ");

		}

		else if (AmountAction == false) {
			Thread.sleep(1000);
			log.info(" Amount action not marked as ok ");
			fail();

		}

		return AmountAction;
	}

	// Enter OTP Action
	@FindBy(xpath = "//div[@id='enter-otp-step']")
	public WebElement EnterOTPAction;

	public boolean verifyEnterOTPAction() throws Throwable {
		boolean enterOTP = EnterOTPAction.isDisplayed();

		if (enterOTP == true) {
			log.info("enter OTP action marked as ok  ");

		}

		else if (enterOTP == false) {
			Thread.sleep(1000);
			log.info(" enter OTP action not marked as ok ");
			fail();

		}

		return enterOTP;
	}

	// set UPI pin Action
	@FindBy(xpath = "//div[@id='ob-enter-pin-step']")
	public WebElement SetUPIPinAction;

	public boolean verifySetUPIPinAction() throws Throwable {
		boolean setUPIPin = SetUPIPinAction.isDisplayed();

		if (setUPIPin == true) {
			log.info("Set UPI pin  action marked as ok  ");

		}

		else if (setUPIPin == false) {
			Thread.sleep(1000);
			log.info(" Set UPI action not marked as ok ");
			fail();

		}

		return setUPIPin;
	}

	// Re-Enter UPI pin Action
	@FindBy(xpath = "//div[@id='re-enter-pin-step']")
	public WebElement ReEnterUPIPinAction;

	public boolean verifyReEnterUPIPinAction() throws Throwable {
		boolean reEnterUPIPin = ReEnterUPIPinAction.isDisplayed();

		if (reEnterUPIPin == true) {
			log.info("re-enter UPi pin action marked as ok  ");

		}

		else if (reEnterUPIPin == false) {
			Thread.sleep(1000);
			log.info(" re-enter UPI pin  action not marked as ok ");
			fail();

		}

		return reEnterUPIPin;
	}

	// accept terms and condition action
	@FindBy(xpath = "//div[@id='accept-term-step']")
	public WebElement AcceptTermsAndConitionAction;

	public boolean concernAction() throws InterruptedException {
		Thread.sleep(20000);
		boolean termsAndCondtion = AcceptTermsAndConitionAction.isDisplayed();
		if (termsAndCondtion == true) {
			log.info("Concern action marked as ok ");
		}

		else if (termsAndCondtion == false) {
			log.info("concern marked as not marked as ok ");
			fail();
		}

		return termsAndCondtion;
	}

	// onboard sucessfully action
	@FindBy(xpath = "//div[@id='onboarded-step']")
	public WebElement OnboardSucessfullyAction;

	public boolean onboardSucessfullyAction() throws InterruptedException {

		Thread.sleep(10000);
		boolean onboardedAction = OnboardSucessfullyAction.isDisplayed();

		if (onboardedAction == true) {
			log.info("onboarded action marked as ok ");
		} else if (onboardedAction == false) {
			log.info("onboarded action not marked as ok ");
			fail();
		}

		return onboardedAction;
	}

	// Enter UPI pin Action
	@FindBy(xpath = "//div[contains(@id,'enter-pin-step')]")
	public WebElement EnterUPIPinAction;

	public boolean enterUPIPinAction() throws Throwable {
		Thread.sleep(1000);
		boolean UPIPinAction = EnterUPIPinAction.isDisplayed();

		if (UPIPinAction == true) {
			log.info("Enter UPI pin action marked as ok ");
		} else if (UPIPinAction == false) {
			log.info("Enter UPI pin action not marked as ok ");
			fail();
		}

		return UPIPinAction;
	}

	// Fetch Bill Button for a bill pay pages which fetch on 1st page
	@FindBy(xpath = "//button[@id='fetch-bill-btn']")
	public WebElement FetchBillButton1;

	public void clickOnFetchBillButton1() throws Throwable {
		Thread.sleep(1000);
		FetchBillButton1.click();
		log.info("User click on fetch Bill button ");

	}
	
	// Fetch Bill Button for a bill pay pages which billpay on 2nd page 
	@FindBy(xpath = "//button[@id='fetch-bill-btn-2']")
	public WebElement FetchBillButton2;

	public void clickOnFetchBillButton2() throws Throwable {
		Thread.sleep(1000);
		FetchBillButton2.click();
		log.info("User click on fetch Bill button ");

	}

	// Pay Bill now Button

	@FindBy(xpath = "//button[contains(text(),'Pay bill now')]")
	public WebElement ClickOnPayBillButton;

	public void clickOnPayBillButton() throws InterruptedException {

		Thread.sleep(1000);
		ClickOnPayBillButton.click();
		log.info("User click on pay Bill Button ");
	}

	// Landing page3
	@FindBy(xpath = "(//div[@class='step-number-inner text-light bg-success'])[3]")
	public WebElement LandingePage3;

	public boolean checkUserRedirectOn3rdPage() throws InterruptedException {
		Thread.sleep(20000);
		boolean PageNo3 = LandingePage3.isDisplayed();
		if (PageNo3 == true) {
			log.info("user call on DID and user Redirect on 3rd page ");
		} else if (PageNo3 == false) {
			log.info("user call on DID but user not  Redirect on 3rd page ");
			fail();
		}

		return PageNo3;
	}

	// Landing page2
	@FindBy(xpath = "(//div[@class='step-number-inner text-light bg-success'])[2]")
	public WebElement LandingePage2;

	public boolean checkUserRedirectOn2rdPage() throws InterruptedException {
		Thread.sleep(2000);
		boolean PageNo2 = LandingePage2.isDisplayed();

		if (PageNo2 == true) {
			log.info("user redirect on 2nd page ");

			Thread.sleep(1000);
		} else if (PageNo2 == false) {
			log.info("user not redirect on 2nd page ");
			fail();
		}

		return PageNo2;
	}

	// Landing page2
	@FindBy(xpath = "(//div[@class='step-number-inner text-light bg-success'])[1]")
	public WebElement LandingePage1;

	public boolean checkUserRedirectOn1stPage() throws InterruptedException {
		Thread.sleep(2000);
		boolean PageNo1 = LandingePage1.isDisplayed();

		if (PageNo1 == true) {
			log.info("user redirect on 1st page ");

			Thread.sleep(1000);
		} else if (PageNo1 == false) {
			log.info("user not redirect on 1st page ");
			fail();
		}

		return PageNo1;
	}
	// get OTP option if user not existing MCP user

	@FindBy(xpath = "//button[@id='get-otp-btn']")
	public WebElement GetOTPButton;

	public boolean getOTPButton() throws InterruptedException {
		Thread.sleep(500);
		boolean getOTP = GetOTPButton.isDisplayed();

		return getOTP;
	}

	// click on get OTP Button
	public void clickOnGetOTP() throws InterruptedException {

		GetOTPButton.click();
		log.info("User click on get OTP Button ");
	}

	// click on enter OTP feild
	@FindBy(xpath = "//input[@id='otp-input']")
	public WebElement EnterOTP;

	public void enterOTP() throws InterruptedException {
		Thread.sleep(500);
		EnterOTP.click();

	}

	// if user not enter OTP or enter invalid OTP check error msg
	@FindBy(xpath = "//div[@id='resend-otp-error-msg']")
	public WebElement ErroMsgForOTP;

	public boolean erroMsgForOTP() {
		Waits.implicitWait(5000);
		boolean error_msg = ErroMsgForOTP.isDisplayed();
		return error_msg;
	}

	// click on proced button
	@FindBy(xpath = "//button[@id='proceed-btn']")
	public WebElement ProccedButton;

	public void clickONProceedButton() throws InterruptedException {
		ProccedButton.click();

	}

	// if bill not fetch error msg
	@FindBy(xpath = "//div[contains(@id,'fetch-bill-error-msg')]")
	public WebElement FetchBill_errorMsg;

	// To check if bill not fetch then error msg
	public String fetchBillErrorMsg() {
		Waits.explicitWait(common.FetchBill_errorMsg);
		String msg = common.FetchBill_errorMsg.getText();
		return msg;
	}

	// bill details on 2nd page
	@FindBy(xpath = "(//div[contains(@id,'bill-details')])[2]")
	public WebElement BillDetails2ndPage;

	// Bill details after fetch Bill on same page
	@FindBy(xpath = "//div[@id='bill-details-div-2']")
	public WebElement FetchedBillDetails;

	public boolean fetchedBillDetails() {
		Waits.implicitWait(1000);
		boolean billAvailable = FetchedBillDetails.isDisplayed();
		return billAvailable;

	}

	// Bill details after fetch Bill on same page
	@FindBy(xpath = "//div[@id='bill-details']")
	public WebElement FetchedBillDetails1;

	public boolean fetchedBillDetails1() {
		Waits.implicitWait(1000);
		boolean billAvailable = FetchedBillDetails1.isDisplayed();
		return billAvailable;

	}

	// Bill details after fetch Bill on same page
	@FindBy(xpath = "//div[@id='bill-details-div']")
	public WebElement FetchedBillDetails2;

	public boolean fetchedBillDetails2() {
		Waits.implicitWait(1000);
		boolean billAvailable = FetchedBillDetails2.isDisplayed();
		return billAvailable;

	}
	// select language dropdown

	@FindBy(xpath = "//select[@id='language-input']")
	public WebElement SelectLanguage;

	public void selectLanguage() throws InterruptedException {
		try {
			Thread.sleep(1000);
			SelectLanguage.click();
			Select lang = new Select(SelectLanguage);
			lang.selectByIndex(1);

		} catch (Exception e) {
			log.info("user not able to select language ");
			fail();
		}

	}

	// enter bank name
	@FindBy(xpath = "//input[@id='bank-input-text']")
	public WebElement EnterBankName;

	public void enterBankName(String a) {
		Waits.implicitWait(1000);
		EnterBankName.click();
		EnterBankName.sendKeys(a);

		log.info("User enter Bank Name " + a);
	}
	// select bank account

	@FindBy(xpath = "//select[@id='bank-acc-input']")
	public WebElement SelectBankAccount;

	public void SelectBankAccount() throws InterruptedException {
		Thread.sleep(4000);
		SelectBankAccount.click();
		Thread.sleep(4000);
		Select Account = new Select(SelectBankAccount);
		Account.selectByIndex(1);
		log.info("User select bank account ");

	}

	// Debit card Number
	@FindBy(xpath = "//input[@id='last-six-digit-input']")
	public WebElement DebitCardNumber;

	public boolean enterDebitCardNumber(String a) {
		Waits.implicitWait(1000);
		boolean debitCardFeild = DebitCardNumber.isDisplayed();
		if (debitCardFeild == true) {
			DebitCardNumber.click();
			DebitCardNumber.sendKeys(a);
			log.info("User enter debit card number ");

		} else if (debitCardFeild == false) {
			log.info("Debit card number feild not get populate ");
			fail();
		}
		return debitCardFeild;

	}

	// Debit card Number
	@FindBy(xpath = "//input[@id='expiry-month-year-input']")
	public WebElement DebitCardExpiryDate;

	public boolean enterDebitCardExpiryDate(String a) {
		Waits.implicitWait(1000);
		boolean debitCardExpiry = DebitCardExpiryDate.isDisplayed();
		if (debitCardExpiry == true) {
			DebitCardExpiryDate.click();
			DebitCardExpiryDate.sendKeys(a);
			log.info("User enter Debit Card Expiry month and year ");

		} else if (debitCardExpiry == false) {
			log.info("Debit card number feild not get populate ");
			fail();
		}
		return debitCardExpiry;

	}

	// get UPI OTP to onboard button
	@FindBy(xpath = "//button[@id='atm-pin-length-btn']")
	public WebElement GetUPIOTP;

	public boolean clickOnGetUPIOTP() {
		boolean GETUPIOTP = GetUPIOTP.isDisplayed();
		if (GETUPIOTP == true) {
			GetUPIOTP.click();
			log.info("Get UPI OTP button  populate  and user click on get UPI OTP ");
		} else if (GETUPIOTP == false) {
			log.info("Get UPI OTP button not populate ");
		}
		return GETUPIOTP;
	}

	// click on terms and condition check box
	@FindBy(xpath = "//input[@id='terms-conditions-input']")
	public WebElement TermsAndConditionCheckBox;

	public void clickonTermsAndCondtionCheckBox() throws InterruptedException {
		try {
			Thread.sleep(1000);
			TermsAndConditionCheckBox.click();
			log.info("User click on Terms and condition check Box ");
		} catch (Exception e) {
			log.info("User not click on terms and condition checkbox");
			fail();
		}
	}

	// To check populated QR code
	@FindBy(xpath = "//img[@id='d-qr-image']")
	public WebElement QRCode;

	public boolean qrCodeAvialavle() throws Throwable {
		boolean qrAvailable = QRCode.isDisplayed();
		Thread.sleep(1000);
		if (qrAvailable == true) {
			log.info("Qr is available ");
		} else if (qrAvailable == false) {
			log.info("QR code is not available ");
			fail();
		}
		return qrAvailable;

	}

	// select action
	@FindBy(xpath = "//select[@id='what-you-want-input']")
	public WebElement SelectAction;

	public void selectActionWhatWantToDO() {
		Waits.implicitWait(1000);
		Select action = new Select(SelectAction);
		action.selectByIndex(1);
		log.info("User select Action ");
	}

	// Click on add another payment method links
	@FindBy(xpath = "//a[@id='add_more_payment_methods']")
	private WebElement AddMorePaymentMehodURL;

	public void clickAddMorePaymentMehodURL() {
		Waits.implicitWait(1000);
		AddMorePaymentMehodURL.click();
		log.info("User click on Add More payment Method URL");
	}

	// To check if user enter amount
	@FindBy(xpath = "//input[@id='donate-amount-input']")
	public WebElement EnterAmount;

	public void enterAmount(String a) throws Throwable {
		Waits.implicitWait(1000);
		EnterAmount.click();
		EnterAmount.sendKeys(a);
		log.info("User enter  amount " + a);

	}

	// Enter subdivision Code
	@FindBy(xpath = "//input[@id='Subdivision-Code-input']")
	public WebElement SubDivisionCode;

	public void enterSubDivisionCode(String a) {
		SubDivisionCode.click();
		SubDivisionCode.sendKeys(a);
	}

	// check entered name on 3rd page
	@FindBy(xpath = "//span[@id='user-name-2']")
	public WebElement getName;

	public String checkEnteredName(String a) throws Throwable {
		String enteredName = getName.getText();
		Assert.assertEquals(enteredName, a);
		log.info("Entered Name match");
		return enteredName;
	}

	// user not onboarded error msg
	@FindBy(xpath = "//div[@id='customer-onboard-failure']")
	public WebElement NotOnbordedErrorMSG;

	public boolean notOnbordedErrorMSG() {
		Waits.implicitWait(1000);
		boolean error_MSG = NotOnbordedErrorMSG.isDisplayed();
		return error_MSG;
	}

	// To check Mobile verification icon marked as ok
	@FindBy(xpath = "(//div[@class='circlestep2 d-flex justify-content-center align-items-center mb-3'])[1]")
	private WebElement MobileVerificationIcon;

	public boolean mobileVerificationIcon() {
		Waits.implicitWait(5000);
		boolean mobileVerificationIcon = MobileVerificationIcon.isDisplayed();
		if (mobileVerificationIcon == true) {
			log.info("After OTP verify sucessfully Mobile verification action marked as ok ");
		} else if (mobileVerificationIcon == false) {
			log.info("After OTP verify sucessfully Mobile verification action not marked as ok ");
			fail();
		}

		return mobileVerificationIcon;
	}

	// To check user details verification icon marked as ok
	@FindBy(xpath = "(//div[@class='circlestep2 d-flex justify-content-center align-items-center mb-3'])[2]")
	private WebElement UserdetailsVerificationIcon;

	public boolean userdetailsVerificationIcon() {
		Waits.implicitWait(5000);
		boolean userDetailsVerificationIcon = UserdetailsVerificationIcon.isDisplayed();
		if (userDetailsVerificationIcon == true) {
			log.info("After call on DID user details verification action marked as ok  ");
		} else if (userDetailsVerificationIcon == false) {
			log.info("After call on DID user details verification action not marked as ok");
			fail();
		}

		return userDetailsVerificationIcon;
	}

	// In fetched bill bill amount on 2nd page WebElement
	// @FindBy(xpath="//span[@id='bill-due-amount-2']")
	// public WebElement BillAmountOn2ndPage;

	// Genereate QR code Button
	@FindBy(xpath = "//button[@id='refresh-qr-btn']")
	public WebElement GenerateQRButton;

	public void clickOnGenerateQRButton() {
		GenerateQRButton.click();

		// span[@id='upi-timeout']
	}

	// select Autofetched Account
	@FindBy(xpath = "(//input[@name='radio-bank'])[1]")
	public WebElement SelectAutoFetchedAccount;

	public void selectAutoFetchedAccount() {
		SelectAutoFetchedAccount.click();
	}
	
	//Enter another consumer Radio Button 
	@FindBy(xpath="//input[@value='other']")
	public WebElement AnotherConsumerNumberRadioButton;
	public void clickOnAnotherConsumerNumberRadioButton() throws InterruptedException {
		Thread.sleep(1000);
		AnotherConsumerNumberRadioButton.click();
		log.info("User Clicked on Add another consumer number radio Button");
	}

	// QR code visible time
	@FindBy(xpath = "//span[@id='upi-timeout']")
	public WebElement TimeOutStopWatch;

	public boolean checkTimeoutStopWatch() throws InterruptedException {
		Thread.sleep(500);
		boolean timer = TimeOutStopWatch.isDisplayed();
		if (timer == true) {
			log.info("Qr Code Toke Generated valiUpto 15 min in transaction report ");
		} else {
			log.info("Timer is not availabel on UI");
			fail();
		}
		return timer;
	}

	// To check account auto fetched or not
	@FindBy(xpath = "//span[text()='We found ']")
	public WebElement AccountAutofetched;

	// Autofetch Bank table
	@FindBy(xpath = "(//input[@name='radio-bank'])[1]")
	public WebElement AutoFetchedBank1st;

	// Other Bank radio Button
	@FindBy(xpath = "//input[@id='bank-other']")
	public WebElement OtherBankRadioButton;

	public void clickOnOtherBankRadioButton() throws InterruptedException {
		Thread.sleep(1000);
		OtherBankRadioButton.click();
	}

	// Biller logo on Web page
	@FindBy(xpath = "(//a[@class='d-flex justify-content-center align-items-center'])[3]")
	public WebElement billerLogoImage;

//Auto fetched Bank account count 
	@FindBy(xpath = "//span[@id='usernum_banks']")
	public WebElement AutoFetchBankAccountCount;

	//get count for auto fetched bank and print 
	public void getAutoFetchBankAccountCount() throws InterruptedException {
		Thread.sleep(1000);
		String count = AutoFetchBankAccountCount.getText();
		log.info("There are " + count + " bank get AutoFetched for User Number ");
	}

	
	
	@FindBy(xpath="//tbody[@id='bank-acc-input-1']")
	public WebElement AutoFetchedAccountDetails;
	public void details() {
		String name =AutoFetchedAccountDetails.getText();
		System.out.println(name);
	}
	
 //pay Through miss call pay text
	@FindBy(xpath="//p[text()='Pay via ']")
	public WebElement payThroughMisscallPaytext;
	
//select payment method text 
	@FindBy(xpath="//p[text()='Select Payment Method']")
	public WebElement SelectPaymentMethodText;
	
}
