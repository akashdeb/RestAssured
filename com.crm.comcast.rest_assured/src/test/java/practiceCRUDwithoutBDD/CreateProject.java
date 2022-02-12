package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
	//Create test data
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Akash");
	jObj.put("pojectName", "withoutBDD");
	jObj.put("status", "Completed");
	jObj.put("teamSize", 23);
	
	//Provide request specification
	RequestSpecification request = RestAssured.given();
	request.contentType(ContentType.JSON);
	request.body(jObj);
	
	//Perform the action
	Response response = request.post("http://localhost:8084/addproject");
	
	//print in console and verify
	System.out.println(response.asString());
	System.out.println("**************************************");
	System.out.println(response.prettyPrint());
	System.out.println("**************************************");
	System.out.println(response.prettyPeek());
	System.out.println("**************************************");
	System.out.println(response.getContentType());



	
	}

}
