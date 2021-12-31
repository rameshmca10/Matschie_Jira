package services;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class IncidentTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.accept(ContentType.JSON)	
			.get("issuetype/10017")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body(containsString("id"),containsString("description"));		
	}
}