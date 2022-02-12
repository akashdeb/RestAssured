package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Auth2 {
	
	@Test
	public void auth() {
		Response response = given()
			.formParam("client_id", "DemoTest154562")
			.formParam("client_secret", "70d4285887aeccb02255b286032a915c")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
		 	.post("http://coop.apps.symfonycasts.com/token");
		 	String token = response.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2778")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
			.log().all();
			
		
		 	
	}

}
//a418b11f6bf61701ed5bb2a640baf2552bdd8619
