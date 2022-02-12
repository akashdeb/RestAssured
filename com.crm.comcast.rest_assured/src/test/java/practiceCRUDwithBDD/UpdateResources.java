package practiceCRUDwithBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateResources {
	
	@Test
	public void updateResource() {
int randomNo = new Random().nextInt(1000);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Akash");
		jObj.put("projectName", "Project_RestAssured"+randomNo);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 000);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_003")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
		
	}

}
