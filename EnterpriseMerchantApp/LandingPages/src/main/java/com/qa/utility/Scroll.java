package com.qa.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class Scroll extends TestBase {

	public Scroll() {
		PageFactory.initElements(driver, this);
	}

	public static void ScrollPage(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void scrollDownFalse(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(alignToMidle=0);", element);

	}
}
