package com.qa.utils;

import java.io.File;

import org.apache.logging.log4j.ThreadContext;

import com.qa.pageLayer.TestBase;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {

	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

	public AppiumDriverLocalService getServer() {
		return server.get();
	}

	public AppiumDriverLocalService getAppiumServicedefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	public void runAppiumService() {
		GlobalParams params = new GlobalParams();

		// Build parameters for appium server:
		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
		appiumServiceBuilder.usingAnyFreePort().withIPAddress("127.0.0.1")

				.withAppiumJS(
						new File("C:\\Users\\Dell\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.usingDriverExecutable(new File("E:\\Softwares\\node.exe"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withLogFile(new File("server.logs"));
		AppiumDriverLocalService server = AppiumDriverLocalService.buildService(appiumServiceBuilder);
		server.start();
		if (server == null || !server.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started");

		}
		// if dont want to print server ;log in consoler add below line
		server.clearOutPutStreams();
		this.server.set(server);
		ThreadContext.put("ROUTINGKEY", "serverLogs");
	}
}
