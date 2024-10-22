package com.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utility.GetUrl;
import com.qa.utility.Scroll;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class MerchantGenericNewTestClass extends TestBase {

	
	public MerchantGenericNewTestClass() {
		PageFactory.initElements(driver, this);
	}
	
	// To launch merchant page URL on browser
@Test(priority=0)
public void launchURL() throws IOException {
	driver.get(GetUrl.getURL("MerchantGenericPageNew"));
	log.info("User Launch URL on browser "+GetUrl.getURL("MerchantGenericPageNew"));
	driver.switchTo().frame(0);
	
}

//As per user status on MCP pay amount to merchant Positive Flow 
@Test(priority=1)
public void payAmountToMerchant() throws InterruptedException, IOException {
	Waits.implicitWait(3000);
	common.clickOnElement(merchantNew.enterAmount);
	common.sendData(merchantNew.enterAmount, TestData.MerchantGenerciPageNew(0,2,1) , "User enter amount "+TestData.MerchantGenerciPageNew(0,2,1) +".");
	common.sendData(merchantNew.EnterMobileNumber, TestData.MerchantGenerciPageNew(0, 1, 1) ,"User enter Mobile Number "+ TestData.MerchantGenerciPageNew(0, 1, 1)+".");
	common.sendData(merchantNew.invoiceNumber, TestData.MerchantGenerciPageNew(0, 7, 1), "User Enter Invoice Number "+ TestData.MerchantGenerciPageNew(0, 7, 1)+".");
	Thread.sleep(2000);
    Waits.explicitWait(common.NoOnUPIToggle);
    common.clickOnElement(common.NoOnUPIToggle, "User checked Number on UPI toggel.");
    common.clickOnElement(common.DebitCardWithMeToggel ,"User checked debit.card handy with me toggel.");
    Waits.implicitWait(2000);
    Scroll.ScrollPage(common.DebitCardWithMeToggel);
    Thread.sleep(3000);
    common.clickOnElement(common.GetOTP);
	Thread.sleep(3000);
	common.clickOnElement(common.EnterOTP);
	common.clickOnProceedButton();
    merchantNew.transactionAsperStatusOfUser();
 
    
}
}
