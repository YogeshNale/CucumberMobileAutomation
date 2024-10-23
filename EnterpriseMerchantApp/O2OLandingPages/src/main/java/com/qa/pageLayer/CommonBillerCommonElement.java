package com.qa.pageLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.utility.TestData;
import com.qa.utility.Waits;

public class CommonBillerCommonElement extends TestBase {

	public CommonBillerCommonElement() {
		PageFactory.initElements(driver, this);
	}

	// select state field
	@FindBy(xpath = "//input[@id='billerstate-text-input']")
	public WebElement EnterState;

	// select Biller field
	@FindBy(xpath = "//input[@id='billername-text-input']")
	public WebElement BillerName;

	// 1st parameter for biller
	@FindBy(xpath = "(//input[@class='form-control mt-3 is-invalid customer-param'][1])")
	public WebElement paramater1st;

	// 2nd paramater
	@FindBy(xpath = "(//input[@class='form-control mt-3 is-invalid customer-param'])[2]")
	public WebElement paramater2nd;

	// 3rd parameter bill type
	@FindBy(xpath = "//input[@placeholder='Select your Bill Type']")
	public WebElement BillType;
//select city 
	@FindBy(xpath="//input[@placeholder='Select your City']")
	public WebElement SelectCity;
	// To check for enter state name
	public String enterState(String a) throws Exception {
		Thread.sleep(1000);
		EnterState.click();
		EnterState.clear();
		EnterState.sendKeys(a);
		return a;
	}

	// to check for enter Biller Name
	public String enterBiller(String a) throws Exception {
		Thread.sleep(1000);
		BillerName.click();
		BillerName.clear();
		Thread.sleep(300);
		BillerName.sendKeys(a);
		return a;
	
	}

	// To check for enter 1st parameter
	public void enter1stParamater(String a) throws Exception {
		Thread.sleep(1000);
		paramater1st.click();
		paramater1st.clear();
		paramater1st.sendKeys(a);
	}

	// enter 2nd parameter for biller
	public void enter2ndParamater(String a) throws Exception {
		Thread.sleep(1000);
		paramater2nd.click();
		paramater2nd.clear();
		paramater2nd.sendKeys(a);
	}

	// enter 3rd parameter for biller
	public void enterBillType(String a) throws Exception {
		Thread.sleep(1000);
		BillType.sendKeys(a);
	}
	
	public void selectCity(String a) throws InterruptedException {
		Thread.sleep(1000);
		SelectCity.sendKeys(a);
	}

	// Bill details available table
	@FindBy(xpath = "(//div[contains(@id,'bill-details')])[1]")
	public WebElement BillDetails;

	// logo of biller
	@FindBy(xpath = "//img[@id='biller-logomob']")
	public WebElement logo;

	
}
