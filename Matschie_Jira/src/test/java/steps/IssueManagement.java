package steps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class IssueManagement extends baseAPI{

	@Given("enable logs")
	public void setUp() {
		request = given().log().all();
	}

	@When("issue details are added in body {string}")
	public void add_issue_details(String str) {

		File file = new File(str);
		response = given().contentType(ContentType.JSON).body(file).log().all().when().post("issue");

	}

	@Then("the status code is (\\d+)$") // ->only Digit
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String, String> responseFields) {

		System.out.println(json.extract().asString());

	}

}