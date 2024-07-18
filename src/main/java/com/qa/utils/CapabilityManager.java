package com.qa.utils;

import java.net.URL;

import org.openqa.selenium.Capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CapabilityManager {

	GlobalParams param = new GlobalParams();

	public Capabilities setCapability() {
		try {
			UiAutomator2Options opt = new UiAutomator2Options();
			opt.setPlatformName(param.getPlatformName());
			opt.setDeviceName(param.getDeviceName());
			opt.setUdid(param.getudid());
			opt.setAvd("Pixel_8_API_31");
			switch (param.getPlatformName()) {
			case "Android":
				opt.setAutomationName(Utils.getProperties("AutomationName"));
				opt.setAppPackage(Utils.getProperties("AppPackage"));
				opt.setAppActivity(Utils.getProperties("AppActivity"));
				// opt.setSystemPort("10000");
				// opt.setChromedriverPort("10001");
				String AppURL = "E:\\Automations\\CucumberMobileAutomationFramework\\src\\test\\resource\\Apps\\ApiDemos-debug.apk";
				opt.setApp(AppURL);

				break;
			case "ios":
				break;
			}

			return opt;
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}
}
