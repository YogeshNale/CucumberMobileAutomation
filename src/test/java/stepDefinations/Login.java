package stepDefinations;

import static org.testng.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Scenario;

import com.qa.pageLayer.TestBase;
import com.qa.utils.DriverManager;
import com.qa.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends TestBase {
	
	 
	
	@Given("check content sub option get open")
	public void check_content_sub_option_get_open() throws InterruptedException {
		Utils.log().info("User on Home Page");
		
	}

	@When("user click on content")
	public void user_click_on_content() {
		page.clickOnContent();
		Utils.log().info("User click on contet");
		
	}

	@Then("click on another subOption")
	public void click_on_another_sub_option() {
	page.clickOnasset();
	Utils.log().info("Execute");
	}

	@Then("verify user reach to destination")
	public void verify_user_reach_to_destination() {
	Utils.log().info("Execute");
 Assert.fail();
		
		
	}
}
