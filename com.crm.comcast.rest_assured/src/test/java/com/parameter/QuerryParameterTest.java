package com.parameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QuerryParameterTest {
	
	@Test
	public void querryParam() {
		
		given()
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(200)
			.log().all();	
	}

}
