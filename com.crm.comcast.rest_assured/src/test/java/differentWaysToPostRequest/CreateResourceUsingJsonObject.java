package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourceUsingJsonObject {
	
	@Test
	public void create() {
		
		int randomNo = new Random().nextInt(1000);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Akash");
		jObj.put("projectName", "Project_RestAssured"+randomNo);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 44444);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();

}
}