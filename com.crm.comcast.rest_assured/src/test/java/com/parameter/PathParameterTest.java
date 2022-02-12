package com.parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameterTest {
	
	@Test
	public void parameter() {
		String proId = "TY_PROJ_003";
		given()
			.pathParam("projectId", proId)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
	}

}
