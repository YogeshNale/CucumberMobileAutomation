package com.qa.pageLayer;

import static org.testng.Assert.fail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.testBase.TestBase;
import com.qa.utility.Scroll;
import com.qa.utility.Waits;

public class CommonElements extends TestBase {

	public CommonElements() {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor executor = (JavascriptExecutor) driver;
	// enter Name
	@FindBy(xpath = "//input[@id='user-name-input']")
	public WebElement EnterName;

	public void enterName(String Name) {
		EnterName.sendKeys(Name);
	}

	// Enter Mobile Number
	@FindBy(xpath = "//input[@id='phone-number-input']")
	public WebElement EnterMobileNumber;

	public void enterMobileNumber(String MobileNumber) {
		EnterMobileNumber.click();
		EnterMobileNumber.sendKeys(MobileNumber);
		log.info("User Enter Mobile Number " + MobileNumber);
	}

	// enter amount placeholder
	@FindBy(xpath = "//input[@placeholder='Enter transaction amount.']")
	public WebElement enterAmount;

	public void enterAmount(String amount) {
		enterAmount.click();
		enterAmount.clear();
		enterAmount.sendKeys(amount);
		log.info("User Enter Amount " + amount);
	}

	// click on number on UPI toggles
	@FindBy(xpath = "//input[@id='number-is-on-upi']")
	public WebElement NoOnUPIToggle;

	public void clickNoOnUPIToogle() {

		NoOnUPIToggle.click();
		log.info("User click on My Mobile Number Linked to UPI checkbox.");

	}

	@FindBy(xpath = "number-is-linked-to-bank")
	public WebElement NumberLinkedOnUPI;

	// click on debit card handy with me toggles
	@FindBy(xpath = "//input[@id='atm-debit-handy']")
	public WebElement DebitCardWithMeToggel;

	public void clickDebitCardWithMeToogle() {

		DebitCardWithMeToggel.click();
		log.info("User click on Debit Card With Me Toggel.");

	}

	// click on get OTP button
	@FindBy(xpath = "//button[@id='get-otp-btn']")
	
	public WebElement GetOTP;

	public void clickOnGetOTP() {
		GetOTP.click();
		log.info("User Click on get OTP Button.");

	}

	// click on enter OTP feild
	@FindBy(xpath = "//input[@id='otp-input']")
	public WebElement EnterOTP;

	public void enterOTP() {
		EnterOTP.click();
		log.info("User Click on Enter OTP Text Feild ");
	}

	// error msg for no input , invalid input for OTP
	@FindBy(xpath = "//div[@id='resend-otp-error-msg']")
	public WebElement OTPErrorMsg;

	public String getErrorMSGForOTP() {
		String text = OTPErrorMsg.getText();
		System.out.println(text);
		return text;
	}

	// OTP verify sucessfully
	@FindBy(xpath = "//p[@id='otp-verification-successfully']")
	public WebElement OTPVerified;

	// click on proceed Button after enter OTP
	@FindBy(xpath = "//button[@id='proceed-btn']")
	public WebElement ProceedButton;

	public void clickOnProceedButton() throws InterruptedException {
		Thread.sleep(1000);
		EnterOTP.click();
		Thread.sleep(15000);
		ProceedButton.click();
		Thread.sleep(2000);
		if (OTPErrorMsg.isDisplayed() == true) {
			log.info("User not enter Verification Code  Or Not Enter Valid Verification Code Please try again.");
			EnterOTP.click();
			EnterOTP.clear();
			Thread.sleep(10000);
			ProceedButton.click();
			Thread.sleep(2000);
			if (OTPErrorMsg.isDisplayed() == true) {
				log.info("Again User not enter Verification Code  Or Not Enter Valid Verification Code.");
				fail();
			} else {
				log.info("User enter verification code and Number get Validate Sucessfully.");

			}
		} else {
			log.info("User Enter verification code and Number get validate Sucessfully.");
		}

	}

	// consumer number feild
	@FindBy(xpath = "//input[@placeholder='Consumer Number']")
	public WebElement ConsumerNumber;

	public void enterConsumerNumber(String consumerNumber) {
		ConsumerNumber.click();
		ConsumerNumber.clear();
		ConsumerNumber.sendKeys(consumerNumber);
	}

	// click on Fetch Bill Button
	@FindBy(xpath = "//button[@id='fetch-bill-btn-2']")
	public WebElement FetchBillButton;

	public void clickOnFetchBillButton() {

		executor.executeScript("arguments[0].click()", FetchBillButton);
	}

	// Terms and condition check Box
	@FindBy(xpath = "//input[@id='terms-conditions-input']")
	public WebElement TermsAndCondition;

	public void clickOnTermsAndCondition() {
		TermsAndCondition.click();
	}

	// DID button
	@FindBy(xpath = "//button[text()='Click here ']")
	public WebElement CallOnDID;

	public boolean ClickHerecallOnDID() throws InterruptedException {
		Thread.sleep(2000);
		boolean DID = CallOnDID.isDisplayed();
		return DID;

	}

	// Calling DID
	@FindBy(xpath = "//button[@id='miss-call-btn-0']")
	public WebElement CallOnDIDButton;

	public boolean callOnDIDButton() throws InterruptedException {
		Thread.sleep(2000);
		boolean callOnDID = CallOnDIDButton.isDisplayed();
		return callOnDID;
	}

	// QR Image
	@FindBy(xpath = "//img[@id='d-qr-image']")
	public WebElement QRImage;

	// Generate QR
	@FindBy(xpath = "//button[@id='refresh-qr-btn']")
	public WebElement GenerateQR;

	// QR generate Time
	@FindBy(xpath = "//div[@id='qr-minutes']")
	public WebElement QRValidTime;

	public boolean qrValidTime() {
		executor.executeScript("arguments[0].click()", QRValidTime);
		boolean time = QRValidTime.isDisplayed();
		if (time == true) {

			log.info("Afetr Click on Generate QR , QR get genrate ");
		}

		else {
			log.info("After Click on Generate QR , Qr not get Generate ");
			fail();
		}
		return time;
	}

	public void qrImage(String action) throws InterruptedException {
		boolean QR = QRImage.isDisplayed();
		Waits.explicitWait(common.QRImage);
		if (QR == true) {
			log.info("Qr Populate on UI");
			if (action.equalsIgnoreCase("Yes")) {

				executor.executeScript("arguments[0].click()", GenerateQR);
				log.info("User Click On generate QR button to create token  ");
				Scroll.ScrollPage(QRValidTime);
				Thread.sleep(2000);
				qrValidTime();

			} else if (action.equalsIgnoreCase("No")) {
				log.info("QR Populate on UI but User dont createdThe QR token ");
			}
		} else if (QR == false) {
			log.info("Qr Not populate on UI");
			fail();
		}
	}

	@FindBy(xpath = "//img[@id='d-qr-image-1']")
	public WebElement QRImageOn2ndPage;

	// Generate QR
	@FindBy(xpath = "//button[@id='refresh-qr-btn-1']")
	public WebElement GenerateQROn2ndpage;

	public void qrImageOn2ndPage(String action) throws InterruptedException {
		boolean QR = QRImageOn2ndPage.isDisplayed();
		if (QR == true) {
			log.info("Qr Populate on UI");
			if (action.equalsIgnoreCase("Yes")) {
				GenerateQROn2ndpage.click();
				log.info("User Click On generate QR button to create token  ");
				Thread.sleep(1000);
				Scroll.ScrollPage(QRValidTimeOn2ndpage);
				Thread.sleep(2000);
				qRValidTimeOn2ndpage();

			} else if (action.equalsIgnoreCase("No")) {
				log.info("QR Populate on UI but User ot createdThe QR token ");
			}
		} else if (QR == false) {
			log.info("Qr Not populate on UI");
			fail();
		}
	}

	// QR generate on 2nd page Time
	@FindBy(xpath = "//span[@id='upi-timeout-1']")
	public WebElement QRValidTimeOn2ndpage;

	public boolean qRValidTimeOn2ndpage() {

		boolean time = QRValidTimeOn2ndpage.isDisplayed();
		if (time == true) {

			log.info("Afetr Click on Generate QR , QR get genrate ");
		}

		else if (time == false) {
			log.info("After Click on Generate QR , Qr Not get Generate ");

		}
		return time;
	}

	// select more payment Method text

	@FindBy(xpath = "//p[text()='Select Payment Method']")
	public WebElement SelectMorePaymentMethodText;

	// To check account auto fetched or not
	@FindBy(xpath = "//span[text()='We found ']")
	public WebElement AccountAutofetched;

	public boolean accountAutofetched() throws InterruptedException {
		Thread.sleep(1000);
		boolean accountDetails = AccountAutofetched.isDisplayed();
		return accountDetails;
	}

	// Other Bank radio Button
	@FindBy(xpath = "//input[@id='bank-other']")
	public WebElement OtherBankRadioButton;

	public boolean otherBankRadioButton() {
		boolean otherbankOption = OtherBankRadioButton.isDisplayed();

		return otherbankOption;
	}

	public void clickOnOtherBankRadioButton() throws InterruptedException {
		Thread.sleep(1000);
		log.info("User click on Other Radio Button to enter Bank Name");
		OtherBankRadioButton.click();
	}

	// select 1st Bank of autofetched Account
	@FindBy(xpath = "(//input[@name='radio-bank'])[1]")
	public WebElement Select1stAutofetchedBank;

	public void select1stAutofetchedBank() {
		Select1stAutofetchedBank.click();
		log.info("User Select Linked Bank Account ");
	}

	// select language
	@FindBy(xpath = "//select[@id='language-input']")
	public WebElement SelectLanguage;

	public void selectLanguage(int langageIndex) {
		Select lang = new Select(SelectLanguage);
		lang.selectByIndex(langageIndex);

	}

	// Enter Debit card number feild
	@FindBy(xpath = "//input[@id='last-six-digit-input']")
	public WebElement DebitCardNumber;

	public void enterDebitCradNumber(String debitCardNumber) {
		DebitCardNumber.click();
		DebitCardNumber.clear();
		DebitCardNumber.sendKeys(debitCardNumber);
	}

	// Enter Debit card Expiry month year feild
	@FindBy(xpath = "//input[@id='expiry-month-year-input']")
	public WebElement DebitCardExpityMonthYear;

	public void enterDebitCardExpityMonthYear(String DebitCardNumber) {
		DebitCardExpityMonthYear.click();
		DebitCardExpityMonthYear.clear();
		DebitCardExpityMonthYear.sendKeys(DebitCardNumber);
	}

	// GET UPI OTP
	@FindBy(xpath = "//button[@id='atm-pin-length-btn']")
	public WebElement GetUPIOtp;

	public void ClickOnGetUPIOTP() {
		GetUPIOtp.click();
	}

	// enter Bank Name
	@FindBy(xpath = "//input[@id='bank-input-text']")
	public WebElement EnterBankName;

	public void enterBankName(String BankName) {
		EnterBankName.click();
		EnterBankName.clear();
		EnterBankName.sendKeys(BankName);
		log.info("User Enter Bank Name " + BankName);
	}

	// select bank Account
	@FindBy(xpath = "//select[@id='bank-acc-input']")
	public WebElement SelectBankAccount;

	public void selectBankAccount(int index) throws InterruptedException {
		SelectBankAccount.click();
		Thread.sleep(1000);
		Select selectBank = new Select(SelectBankAccount);
		selectBank.selectByIndex(index);
		log.info("User  select linked Bank Account.");
	}

	@FindBy(xpath = "//div[@id='misscall-step']")
	public WebElement UserMisscallOnDID;

	public boolean checkUserMisscallOnDID() {
		boolean call = UserMisscallOnDID.isDisplayed();
		if (call == true) {
			log.info("User Call on DID and redirect on 3rd page ");
		}
		return call;

	}

	@FindBy(xpath = "//div[@id='get-call-step']")
	public WebElement UserReceivedCallBack;

	public boolean checkUserReceivedCallBack() {
		boolean callBackAction = UserReceivedCallBack.isDisplayed();
		if (callBackAction == true) {
			log.info("User Received Call Back and Received call back action get marked");
		} else {
			log.info("User Not received Call Back  OR Call Back Action Not get marked as Ok");
		}
		return callBackAction;
	}

	// Accept terms and condition
	@FindBy(xpath = "//div[@id='accept-term-step']")
	public WebElement UserAcceptTermsAndCondition;

	public boolean UserAcceptTermsAndConditionAction() {
		boolean AcceptTermsAndConditionCheckBox = UserAcceptTermsAndCondition.isDisplayed();
		if (AcceptTermsAndConditionCheckBox == true) {
			log.info(
					"User Accept terms and Condition Over IVR and Accept terms and condition action get marked as Ok ");
		} else {
			log.info(
					"User Not Accept terms and Condition Over IVR or Accept terms and Condition Action Not get marked as Ok");
		}
		return AcceptTermsAndConditionCheckBox;
	}

	// User Onboarded Sucessfully Action

	@FindBy(xpath = "//div[@id='onboarded-step']")
	public WebElement OnboardedAction;

	public boolean onboardedAction() {
		boolean chekonboardedAction = OnboardedAction.isDisplayed();
		if (chekonboardedAction == true) {
			log.info("User onboarded Sucessfully And onboarded sucessfully action get marked as ok. ");
		}

		else {
			log.info("User not onboarded Sucessfully or onboarded Action not get marked as ok.");
		}
		return chekonboardedAction;
	}

	// verify Amount Action
	@FindBy(xpath = "//div[@id='verifying-amount-step']")
	public WebElement VerifyAmountAction;

	public boolean verifyAmountAction() {
		boolean CheckverifyAmountAction = VerifyAmountAction.isDisplayed();
		if (CheckverifyAmountAction == true) {
			log.info("User Verify amount and Verify Amount Action Get Marked as Ok");
		} else {
			log.info("User Not Verify amount  or Verify Amount Action Not get Marked As Ok ");
		}
		return CheckverifyAmountAction;
	}

	// verify Amount Action
	@FindBy(xpath = "//div[@id='enter-pin-step']")
	public WebElement EnterUPIPinAction;

	public boolean enterUPIPinAction() {
		boolean enterUPIPinAction = EnterUPIPinAction.isDisplayed();
		if (enterUPIPinAction == true) {
			log.info("Enter UPi pin action get Merked as  Ok");
		} else {
			log.info("User Not Enter UPI pin  info or Enter UPI pin Action Not get Marked As Ok ");
		}
		return enterUPIPinAction;
	}

	// click to call back button
	@FindBy(xpath = "//button[@id='miss-call-btn']")
	public WebElement clickToPayButton;

	public void clickToPayButton() {
		executor.executeScript("arguments[0].click()", clickToPayButton);
		log.info("User click on Click To pay button.");
	}
	
	public boolean clickToPayAvailable() {
		boolean clickToPay =clickToPayButton.isDisplayed();
		return clickToPay;
	}

	// method to click on send key
	public void clickOnElement(WebElement element) {
		executor.executeScript("arguments[0].click()", element);
		
	}
	
	public void clickOnElement(WebElement element,String Statment) {
		executor.executeScript("arguments[0].click()", element);
		log.info(Statment);
	}

	// method to click on send key
	public void sendData( WebElement element, String data , String statment) {
		element.sendKeys(data);
		log.info(statment);
	}
	
	
	
	
	//Intenet received Text on 3rd page
	@FindBy(xpath="//p[text()='  Intent Received  ']")
	public WebElement IntentReceivedText;
	
	public boolean checkIntenetReceivedTextShowOnUI() {
		boolean text=IntentReceivedText.isDisplayed();
		if(text== true) {
			log.info("After click on call 2 pay Button user redirect on 3rd page.");
		}
		else if(text == false ) {
			log.info("After click on call 2 pay Button user not redirect on 3rd page or call not get initiate.");
		fail();
		}
		return text;
		
	}
	
	//add another consumer radio button 
	
		@FindBy(xpath="//input[@value='other']")
		public WebElement addAnotherConsumerNumber;
		
		@FindBy(xpath="//select[@onchange='handleConsumers(this)']")
		public WebElement selectAnotherDropDown;
		
		public boolean enterConsumerNumber() throws InterruptedException {
			Thread.sleep(3000);
			boolean anotherradioButton=addAnotherConsumerNumber.isDisplayed();
			boolean SelectAnotherOptionFromDropDown =selectAnotherDropDown.isDisplayed();
			System.out.println(anotherradioButton);
			System.out.println(SelectAnotherOptionFromDropDown);
			
			if(anotherradioButton == true) {
				common.clickOnElement(addAnotherConsumerNumber);
			}
			
			else if(SelectAnotherOptionFromDropDown== true) {
				common.clickOnElement(selectAnotherDropDown);
				Select obj = new Select(selectAnotherDropDown);
				obj.selectByVisibleText("Add other Loan Number");
				
			}
			
			else {
				log.info("add another consumer number not get selected");
				fail();
			}
			
			return anotherradioButton;
				
		}
}


