package com.practiceTestCases;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectAndAllocateUsersTest {
	
	@Test
	public void createProjectAndAllocateUsersTest() {
		
int randomNo = new Random().nextInt(1000);
		
		String expectedProjectName = "Airtel"+randomNo;
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "deepak");
		jObj.put("projectName", ""+expectedProjectName+"");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.assertThat().time(Matchers.lessThan(600L), TimeUnit.MILLISECONDS)
			.log().all();
		
		jObj.put("designation", "SDET");
		jObj.put("dob", "25/05/1999");
		jObj.put("email", "nithesh@gmail.com");
		jObj.put("teamSize", 12);
	}

}
