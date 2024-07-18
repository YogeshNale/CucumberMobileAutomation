package stepDefinations;

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ScreenShot;
import com.qa.utils.ServerManager;
import com.qa.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	// start server , initalize appium driver
	@Before
	public void initialize() throws Exception {
       Thread.sleep(30000);
		GlobalParams param = new GlobalParams();
		param.initializeGlobalParam();
		ThreadContext.put("ROUTINGKEY", param.getPlatformName() + "_" + param.getDeviceName());
		Utils.createlogFile(param.getPlatformName(), param.getDeviceName());
		new DriverManager().initializeDriver();

	}

	@After
	public void quite(Scenario scenario) throws IOException {

		 ScreenShot.CaptureScreenShot(scenario);

		DriverManager manager = new DriverManager();
		if (manager.getAppiumDriver() != null) {
			manager.getAppiumDriver().quit();
			manager.setAppiumDriver(null);
			Utils.log().info("Driver is Stopped Sucessfully.");
		} else {
			Utils.log().info("Driver is null.");
		}

	}
}
