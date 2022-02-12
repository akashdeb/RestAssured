package com.requestChainning;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;


public class RequestChainningTest {
	
	@Test
	public void chaining() {
		
		 Response response = when()
				.get("http://localhost:8084/projects");
		 String projectId = response.jsonPath().get("[1].projectId");
		 System.out.println(projectId);
		 
		 given()
		 	.pathParam("proId", projectId)
		 .when()
		 	.delete("http://localhost:8084/projects/{proId}")
		 .then()
		 	.assertThat().statusCode(204)
		 	.log().all();
					
		
	}

}
