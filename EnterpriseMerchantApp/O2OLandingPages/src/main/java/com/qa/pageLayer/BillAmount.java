package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class BillAmount extends TestBase {

	public BillAmount() {
		PageFactory.initElements(driver, this);

	}
	

	
	//scroll on text
	@FindBy(xpath="//select[@id='billername-input']")
	public WebElement text;
	
	
	//Write a fetched bill details in sheet
	public String writeBillAmount() throws Throwable {
		
		String  billAmount=amount.tata.getBillAmount();
		return billAmount;
	}
	//Fetched Bill details 
	@FindBy(xpath = "(//div[contains(@id,'bill-details')])[1]")
	public  WebElement BillDetails;
	public boolean billDetailsAvailable() {
		Waits.implicitWait(500);
		boolean bill=BillDetails.isDisplayed();
		return bill;
	}
	
	//consumer number 
	@FindBy(xpath="//span [@id='bill-consumer-number']")
	private WebElement ConsumerNumber;
	public String getConsumerNumber() {
		Waits.implicitWait(1000);
		String number =ConsumerNumber.getText();
		return number;
	}
	
	int i;
	public boolean billAvailableGetAmount() throws Throwable {
		Thread.sleep(6000);
		boolean billAvailable = tata.BillDetails.isDisplayed();
		System.out.println("Bill available ");
		if (billAvailable == true) {
			Thread.sleep(1000);
		//	scroll.scrollDown(tata.BillDetails);
			String n=tata.getBillAmount();
			System.out.println(n);
			  String billAmount=  amount.writeBillAmount();
			    TestData.writeBillAmount(1, i,1, billAmount );
			   
			
			
			
		} 
		else if (billAvailable == false) {
		   String error_msg = common.fetchBillErrorMsg();
           System.out.println(error_msg);
           TestData.writeBillAmount(1, i,1, error_msg );
           
           
           
		}

		return billAvailable;
	}
	public void checkBillAmountForConsumerNumber() throws Throwable, InterruptedException {
	
		for (i = 0; i <= 65; i++) {
			Waits.implicitWait(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",amount.text );
			scroll.scrollDown(tata.BillerName);
			Thread.sleep(500);
			common.EnterConsumerNumber.click();
			common.EnterConsumerNumber.clear();
			common.EnterConsumerNumber.sendKeys(TestData.billAmount(0,i,0));
			tata.scrollOnconsumerNumberFeild();
			common.clickOnFetchBillButton1();
			amount.billAvailableGetAmount();
		     String billAmount=  amount.writeBillAmount();
			driver.navigate().refresh();
			System.out.println(i);
			
			
		
		
			
			
		}
	}
}
