package com.qa.pageLayer;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
//import com.qa.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestBase {
	
	public  AppiumDriver driver;
	public TestBase() {
		this.driver =new DriverManager().getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	
	GlobalParams param = new GlobalParams();
	public static HomePage page = new HomePage();
	
	
	int a= 10;
	// click on element
	public void clickOnElement(WebElement element) {
		element.click();

	}

	// send keys
	public void sendkeys(WebElement element) {
		element.click();
		

	}

	// get attribute
	String att;

	public String getAttribute(WebElement element) {
    return element.getAttribute("text");
	}
public void getSCreenShot() throws IOException {
	File obj= new File("Scrrenshot.png");
	File take = new DriverManager().getAppiumDriver().getScreenshotAs(OutputType.FILE);
	FileHandler.copy(obj, take);
	
}
}
