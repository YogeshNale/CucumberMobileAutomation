package com.qa.utils;

import java.io.IOException;
import java.net.URL;

import com.qa.pageLayer.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager  {

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	public  AppiumDriver getAppiumDriver() {
		return driver.get();
	}

	public void setAppiumDriver(AppiumDriver driver1) {
		driver.set(driver1);
	}

	public void initializeDriver() throws Exception {
		AppiumDriver driver = null;
		GlobalParams params = new GlobalParams();
		if (driver == null) {
			try {
				Utils.log().info("Initalize driver process Start");
				
				switch (params.getPlatformName()) {
				case "Android":
					// no need to pass appium url manually it sfetch when server get start
					//new ServerManager().getServer().getUrl(),
					URL url=new URL("http://0.0.0.0:4723");
					
					driver = new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilityManager().setCapability());
					break;
				case "ios":
					driver = new IOSDriver(new ServerManager().getServer().getUrl(),
							new CapabilityManager().setCapability());
					break;
				}
				if (driver == null) {
					throw new Exception("Driver initialization abort");
				}
				Utils.log().info("driver is Initalize sucessfully");
				this.driver.set(driver);
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}

	}
}
