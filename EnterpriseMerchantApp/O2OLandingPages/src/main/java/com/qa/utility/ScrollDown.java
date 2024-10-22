package com.qa.utility;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class ScrollDown extends TestBase  {

	public ScrollDown() {
		PageFactory.initElements(driver, this);
	}
	
	public  void scrollDown(WebElement element ) {
		

   JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public  void scrollDownFalse(WebElement element ) {
		
	
   JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView(alignToMidle=0);", element);

	}
	
}
	


