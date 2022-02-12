package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResource {
	
	@Test
	public void createResource() {
		
		int randomNo = new Random().nextInt(1000);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Akash");
		jObj.put("projectName", "Project_RestAssured"+randomNo);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 456123);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
		
			
	}

}
