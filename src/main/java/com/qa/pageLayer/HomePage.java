package com.qa.pageLayer;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends TestBase {

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Content\"]")
	public WebElement Content;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Assets\"]")
	private WebElement Assets;

	// get next page element name to verify
	public void getConetentAttribute() {
		getAttribute(Content);
	}

	// click on content
	public void clickOnContent() {

		clickOnElement(Content);
	}

	// get next page element name to verify
	public void getElementAttribute() {
		getAttribute(Assets);
	}

	public void clickOnasset() {

		clickOnElement(Assets);
	}

	public String getValue() {
		String a = getAttribute(Assets);
		return a;
	}
}
