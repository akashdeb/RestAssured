package com.requestChainning;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainingPostAndDelete {
	
		
		@Test
		public void chaining() {
			int randomNo = new Random().nextInt(1000);
			
			JSONObject jObj = new JSONObject();
			jObj.put("createdBy", "Akash");
			jObj.put("projectName", "Project_RestAssured"+randomNo);
			jObj.put("status", "Completed");
			jObj.put("teamSize", 456123);
			
			Response response = given()
				.body(jObj)
				.contentType(ContentType.JSON)
				
			
			 .when()
					 .post("http://localhost:8084/addProject");
			 
			  String proId = response.jsonPath().get("projectId");
			 System.out.println(proId);
			 
			 given()
			 	.pathParam("ProjectID", proId)
			 .when()
			 	.delete("http://localhost:8084/projects/{ProjectID}")
			 .then()
			 	.assertThat().statusCode(204)
			 	.log().all();
						
			
		}

}
