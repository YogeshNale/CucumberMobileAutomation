package com.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class ComonBillerTestLayer extends TestBase {

	public ComonBillerTestLayer() {
		PageFactory.initElements(driver, this);
	}

	@Test(priority = 0)
	public void OpenURL() {
		driver.get("https://mcp.pe/8291969602");
	}

	@Test(priority = 1)
	public void getBillAmounts() throws Throwable {
		com.checkBillAmountForConsumerNumber();

	}
}
