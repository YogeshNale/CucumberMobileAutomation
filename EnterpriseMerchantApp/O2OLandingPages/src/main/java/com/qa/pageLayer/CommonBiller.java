package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.utility.CompareImage;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class CommonBiller extends TestBase {
	public CommonBiller() {
		PageFactory.initElements(driver, this);
	}

	// check bill available or not
	public boolean BillAvailablepayBill() throws Throwable {
		Thread.sleep(3000);
		boolean billAvailable = commonE.BillDetails.isDisplayed();
		if (billAvailable == true) {
			log.info("Bill available for Enterd Consumer Number  ");

		} else if (billAvailable == false) {

			boolean errormsgAvability = common.FetchBill_errorMsg.isDisplayed();
			if (errormsgAvability == true) {

				String error_msg = common.fetchBillErrorMsg();

				if (error_msg == "Payment received for the billing period - no bill due") {
					log.info("Payment received for the billing period - no bill due");

				} else if (error_msg == "No bill data available") {
					log.info("No bill data available");

				}
			} else {
				fail();
				log.info("no error msg available or Bill not fetched ");
			}
		} else {

			fail();
		}
		return billAvailable;
	}

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
			Thread.sleep(25000);
			common.clickONProceedButton();
			Thread.sleep(1000);
			scroll.scrollDown(common.payThroughMisscallPaytext);
			Thread.sleep(1000);
			commonB.selectAccount();

		}

		else if (did || otp == false) {
			log.info(" DID not get populate or Get OTP button also ");
			fail();
		}

	}

	// To check if liked account get auto then select account from autofetched
	// account
	public void selectAccount() throws Exception, Throwable {
		Thread.sleep(10000);
		boolean account = common.AccountAutofetched.isDisplayed();
		if (account == true) {
			log.info("Linked account to enter Number get autofetched ");
			common.getAutoFetchBankAccountCount();
			Thread.sleep(1000);
			scroll.scrollDown(common.AutoFetchedAccountDetails);
			common.selectAutoFetchedAccount();
			scroll.scrollDown(common.SelectLanguage);
			common.selectLanguage();
			commonB.OnboardUserAsPerUPIStatus();

		}

		else if (account == false) {
			log.info("No account Auto Fetched ");
			Thread.sleep(5000);
			 scroll.scrollDown(common.OtherBankRadioButton);
			common.clickOnOtherBankRadioButton();
			common.enterBankName(TestData.commonBiller(1, 6, 1));
			common.SelectBankAccount();
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

	public void passBillerDetails(int s, int r, int StateColumn, int billerColumn, int Param1st, int Param2nd,
			int Param3rd) throws IOException, Exception {

		String stateName = commonE.enterState(TestData.commonBiller(s, r, StateColumn));
		scroll.scrollDown(commonE.EnterState);
		String billerName = commonE.enterBiller(TestData.commonBiller(s, r, billerColumn));
		if (stateName.equals("Assam") && billerName.equals("Assam Power Distribution Company Ltd (NON-RAPDR)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Rajasthan") && billerName.equals("Ajmer Vidyut Vitran Nigam Limited (AVVNL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Bangalore Electricity Supply Co. Ltd (BESCOM)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Rajasthan") && billerName.equals("Bharatpur Electricity Services Ltd. (BESL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Maharashtra") && billerName.equals("B.E.S.T Mumbai")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Rajasthan") && billerName.equals("Bikaner Electricity Supply Limited (BkESL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Delhi") && billerName.equals("BSES Rajdhani Power Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Delhi") && billerName.equals("BSES Yamuna Power Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("West Bengal") && billerName.equals("CESC Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Chamundeshwari Electricity Supply Corp Ltd (CESCOM)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Odisha") && billerName.equals("TP Central Odisha Distribution Ltd.")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Chhattisgarh")
				&& billerName.equals("Chhattisgarh State Power Distribution Co. Ltd")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Dadra And Nagar Haveli") && billerName
				.equals("Dadra and Nagar Haveli and Daman and Diu Power Distribution Corporation Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat")
				&& billerName.equals("Dakshin Gujarat Vij Company Limited (DGVCL)-Fetch and pay")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals(
				"Dakshinanchal Vidyut Vitran Nigam Limited (DVVNL)(Postpaid and Smart Prepaid Meter Recharge)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Arunachal Pradesh")
				&& billerName.equals("Department of Power, Government of Arunachal Pradesh")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Haryana") && billerName.equals("Dakshin Haryana Bijli Vitran Nigam (DHBVN)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Nagaland") && billerName.equals("Department of Power, Nagaland")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Chandigarh") && billerName.equals("Electricity Department Chandigarh")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Goa") && billerName.equals("Goa Electricity Department")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
		} else if (stateName.equals("Karnataka") && billerName.equals("Gulbarga Electricity Supply Company Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat") && billerName.equals("Gift Power Company Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Puducherry")
				&& billerName.equals("Government of Puducherry Electricity Department")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Hubli Electricity Supply Company Ltd (HESCOM)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Himachal Pradesh")
				&& billerName.equals("Himachal Pradesh State Electricity Board")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Hukkeri Rural Electric CoOperative Society Ltd")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("West Bengal") && billerName.equals("India Power Corporation Limited (IPCL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Jammu And Kashmir")
				&& billerName.equals("Jammu and Kashmir Power Development Department")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Jharkhand") && billerName.equals("Jharkhand Bijli Vitran Nigam Limited (JBVNL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Rajasthan") && billerName.equals("Jodhpur Vidyut Vitran Nigam Limited (JDVVNL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Jharkhand") && billerName.equals("Jamshedpur Utilities")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Rajasthan") && billerName.equals("Jaipur Vidyut Vitran Nigam (JVVNL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Kerala")
				&& billerName.equals("Kanan Devan Hills Plantations Company Private Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Rajasthan") && billerName.equals("Kota Electricity Distribution Limited (KEDL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals("Kanpur Electricity Supply Company")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Kerala") && billerName.equals("Kerala State Electricity Board Ltd. (KSEBL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Lakshadweep") && billerName.equals("Lakshadweep Electricity Department")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat")
				&& billerName.equals("Madhya Gujarat Vij Company Limited (MGVCL)-Fetch and pay")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName
				.equals("Madhyanchal Vidyut Vitran Nigam Limited (MVVNL)(Postpaid and Smart Prepaid Meter Recharge)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Maharashtra")
				&& billerName.equals("Maharashtra State Electricity Distbn Co Ltd")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Mangalore Electricity Supply Co. Ltd (MESCOM) - RAPDR")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Meghalaya") && billerName.equals("MePDCL Smart Prepaid Meter Recharge")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Mangalore Electricity Supply Co. Ltd (MESCOM) - RAPDR")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Mangalore Electricity Supply Co. Ltd (MESCOM) - RAPDR")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Madhya Pradesh")
				&& billerName.equals("M.P. Madhya Kshetra Vidyut Vitaran - URBAN")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Madhya Pradesh")
				&& billerName.equals("M.P. Madhya Kshetra Vidyut Vitaran - RURAL")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Meghalaya") && billerName.equals("Meghalaya Power Dist Corp Ltd")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Madhya Pradesh") && billerName.equals("M.P. Paschim Kshetra Vidyut Vitaran")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Madhya Pradesh")
				&& billerName.equals("M.P. Poorv Kshetra Vidyut Vitaran - RURAL")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Bihar") && billerName.equals("North Bihar Power Distribution Company Ltd.")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Odisa") && billerName.equals("TP Northern Odisha Distribution Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals("Noida Power")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat")
				&& billerName.equals("Paschim Gujarat Vij Company Limited (PGVCL)-Fetch and pay")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals(
				"Paschimanchal Vidyut Vitran Nigam Limited (PVVNL)(Postpaid and Smart Prepaid Meter Recharge)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Mizoram") && billerName.equals("Power and Electricity Department - Mizoram")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Punjab") && billerName.equals("Punjab State Power Corporation Ltd (PSPCL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName
				.equals("Purvanchal Vidyut Vitran Nigam Limited(PUVVNL)(Postpaid and Smart Prepaid Meter Recharge)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Maharashtra") && billerName.equals("Adani Electricity Mumbai Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Bihar") && billerName.equals("South Bihar Power Distribution Company Ltd.")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Sikkim") && billerName.equals("Sikkim Power - RURAL")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Odisha") && billerName.equals("TP Southern Odisha Distribution Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Delhi") && billerName.equals("Tata Power - Delhi")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Maharashtra") && billerName.equals("Tata Power - Mumbai")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Kerala") && billerName.equals("Thrissur Corporation Electricity Department")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));
			commonE.enterBillType(TestData.commonBiller(s, r, Param3rd));
		}

		else if (stateName.equals("Tamil Nadu") && billerName.equals("Tamil Nadu Electricity Board (TNEB)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat") && billerName.equals("Torrent Power")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.selectCity(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Rajasthan") && billerName.equals("TP Ajmer Distribution Ltd (TPADL)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals("TP Renewables Microgrid Ltd.")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Odisha") && billerName.equals("TP Northern Odisha Distribution Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Tripura") && billerName.equals("Tripura Electricity Corp Ltd")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Haryana") && billerName.equals("Uttar Haryana Bijli Vitran Nigam (UHBVN)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Uttar Pradesh")
				&& billerName.equals("Uttar Pradesh Power Corp Ltd (UPPCL) - RURAL")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat")
				&& billerName.equals("Uttar Gujarat Vij Company Limited (UGVCL)-Fetch and pay")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttarakhand") && billerName.equals("Uttarakhand Power Corporation Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Gujarat") && billerName.equals("Vaghani Energy Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Odisha") && billerName.equals("TP Western Odisha Distribution Limited")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("West Bengal") && billerName.equals("West Bengal Electricity")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Maharashtra") && billerName.equals("Torrent Power")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.selectCity(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Odisha")
				&& billerName.equals("TP Southen Odisha Distribution Ltd-Smart Prepaid Meter Recharge")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		} else if (stateName.equals("Uttar Pradesh") && billerName.equals("Torrent Power")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.selectCity(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Pan India") && billerName.equals("Torrent Power")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));
			commonE.selectCity(TestData.commonBiller(s, r, Param2nd));

		} else if (stateName.equals("Karnataka")
				&& billerName.equals("Mangalore Electricity Supply Company LTD (Non RAPDR)")) {

			commonE.enter1stParamater(TestData.commonBiller(s, r, Param1st));

		}

	}

}
