package com.qa.utils;

import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.PageFactory;

import com.qa.pageLayer.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public  class GlobalParams  {
	

	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
	private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
	private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
	private static ThreadLocal<String> webkitDebugproxyPort = new ThreadLocal<String>();

	public void setPlatformName(String platformName1) {
		platformName.set(platformName1);
	}

	public String getPlatformName() {
		return platformName.get();
	}

	public void setudid(String udid1) {
		udid.set(udid1);
	}

public String getudid() {
		return udid.get();
	}

	public void setDeviceName(String deviceName1) {
		deviceName.set(deviceName1);
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public void setSystemPort(String systemPort1) {
		systemPort.set(systemPort1);
	}

	public String getSystemPort() {
		return systemPort.get();
	}

	public void setWdaLocalPort(String wdaLocalPort1) {
		wdaLocalPort.set(wdaLocalPort1);
	}

	public String getWdaLocalPort() {
		return wdaLocalPort.get();
	}

	public void setwebkitDebugproxyPort(String webkitDebugproxyPort1) {
		webkitDebugproxyPort.set(webkitDebugproxyPort1);
	}

	public String getwebkitDebugproxyPort() {
		return webkitDebugproxyPort.get();
	}
	
	public void setChromeDriverPort(String chromeDriverPort1) {
		chromeDriverPort.set(chromeDriverPort1);
	}
	public String getChromeDriverPort() {
		return chromeDriverPort.get();
	}
	
	public void initializeGlobalParam() {
		GlobalParams param = new GlobalParams();
		param.setPlatformName(System.getProperty("platformName", "Android"));
		param.setDeviceName(System.getProperty("deviceName", "Pixel_8_API_31"));
		param.setudid(System.getProperty("udid", "emulator-5554"));
		
		
		switch(getPlatformName()) {
		case "Android":
			param.setSystemPort(System.getProperty("systemPort","10000"));
			param.setChromeDriverPort(System.setProperty("chromeDriverPort", "11000"));
			break;
		case"ios":
			param.setWdaLocalPort(System.getProperty("wdaLocalPort","10001"));
			param.setwebkitDebugproxyPort(System.setProperty("webkitDebugproxyPort", "11001"));
			break;
			default:
				throw new IllegalStateException("Invalid PlatformName");
				
		}
		}
}
