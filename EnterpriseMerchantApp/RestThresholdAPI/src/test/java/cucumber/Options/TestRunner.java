package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\Automation Projects\\EnterpriseMerchantApp\\RestThresholdAPI\\src\\test\\java\\features\\RestAPI.feature",
		glue={"stepDefinations"})
public class TestRunner {

}
