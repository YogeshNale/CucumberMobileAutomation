package cucumber.Options;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.utils.ServerManager;
import com.qa.utils.Utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// generate HTML report
		// plugin = { "pretty", "html:target/cucumber", "summary" },

		// To print the step scenarios in console
		dryRun = false,
		// To print console logs
		// monochrome = true,
		features = { "E:\\Automations\\CucumberMobileAutomationFramework\\src\\test\\java\\feature\\login.feature" },
		 plugin="json:target/jsonReports/cucumber-report.",
		glue = { "stepDefinations" })
public class TestRunner {

	@BeforeClass
	public static void startServer() {
		Utils.log().info("Start Appium Server Process Start");
		new ServerManager().runAppiumService();
		Utils.log().info("Appium server Started SucessFully");
	}

	@AfterClass
	public static void stopServer() {
		Utils.log().info("Stop Appium Server Process Start");
		ServerManager serverManager = new ServerManager();
		if (serverManager.getServer() != null) {
			serverManager.getServer().stop();
			Utils.log().info("Appium server stoped Sucessfully");
		} else {
			Utils.log().info("Appium server Null or Stop Already");
		}
	}

}
