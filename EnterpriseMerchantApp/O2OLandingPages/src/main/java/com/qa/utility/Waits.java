package com.qa.utility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;

public class Waits extends TestBase {

	public Waits() {
		PageFactory.initElements(driver,this);
	}
	public static void explicitWait(WebElement element) {
		WebDriverWait did_wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		did_wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void implicitWait(int second) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
	}
	
	public static void explicitWaitVisible(WebElement element) {
		WebDriverWait did_wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		did_wait.until(ExpectedConditions.visibilityOf(element));
	}
}
