package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.pageLayer.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Utils  {

	// get details from property file
	public static String getProperties(String property) throws IOException {
		Properties prop = new Properties();
		String FilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator+"resources"
				+ File.separator + "config.properties";
		
		FileInputStream input = new FileInputStream(FilePath);
		prop.load(input);
		return prop.getProperty(property);
	}

	// explicit wait
	/*public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// impicit wait
	public static void implicitWait(int seconds) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
*/
	// logger method
	public static Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

	}

	// To cerate log file as per the device at time of parallel execution
	public static void createlogFile(String platformName, String deviceName) {
		String stringFile = "logs" + File.separator + platformName + "-" + deviceName;
		File logFile = new File(stringFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		ThreadContext.put("ROUTINGKEY", stringFile);

	}

	



	


}
