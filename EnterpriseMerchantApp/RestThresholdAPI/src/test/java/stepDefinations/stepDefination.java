package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.File;
import java.io.IOException;

public class stepDefination extends Utils {

public RequestSpecification req;
 Response response ;
TestData obj = new TestData();
@Given("Reset Count API Payload")
public void reset_count_api_payload() throws IOException {
	
	req= given().spec(requestBody()).relaxedHTTPSValidation().body(obj.data());
	
   
}
@When("user hit {string} with {string} method")
public void user_hit_with_method(String resource, String string2) {
	APIResources reso = APIResources.valueOf(resource);
	response = when().post("/indicore/bbps/reset-threshold").then().log().all().extract().response();
   
}
@Then("user get Status code {int}")
public void user_get_status_code(Integer int1) {
    
}
@Then("User get {string} msg {string}")
public void user_get_msg(String string, String string2) {
}
@Then("{string} should be  {string}")
public void should_be(String string, String string2) {

}

}
