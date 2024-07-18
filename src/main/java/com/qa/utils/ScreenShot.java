package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.Scenario;

public class ScreenShot {
	public static String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
        Date date = new Date();
		return dateFormat.format(date);

	}
	public static void CaptureScreenShot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			try {
			GlobalParams param = new GlobalParams();
			TakesScreenshot screenShot = (TakesScreenshot) new DriverManager().getAppiumDriver();
			File ts =screenShot.getScreenshotAs(OutputType.FILE);
			String imagePath ="ScreenShots"+File.separator+param.getPlatformName()+"-"+File.separator+param.getDeviceName()
			+File.separator+ScreenShot.getCurrentDateTime()+File.separator+scenario.getClass().getSuperclass().getSimpleName()
			+File.separator+scenario.getName()+".png";
			
			String completeImagePath  =System.getProperty("user.dir")+File.separator+imagePath;
			File file = new File(completeImagePath);
			FileUtils.copyFile(ts, file);
			
			    Utils.log().info("Screenshot captured for scenario: " + scenario.getName());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}
