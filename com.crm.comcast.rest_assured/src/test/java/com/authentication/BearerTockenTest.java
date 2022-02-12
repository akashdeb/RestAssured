package com.authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BearerTockenTest {
	
	@Test
	public void bearerAuth() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
