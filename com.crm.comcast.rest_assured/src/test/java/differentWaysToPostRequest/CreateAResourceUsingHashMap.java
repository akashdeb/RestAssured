package differentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResourceUsingHashMap {
	@Test
	public void create() {
		 HashMap map = new HashMap();
		 
		 map.put("createdBy", "Akash");
		 map.put("projectName", "Project_UsingHashmap");
		 map.put("status", "Created");
		 map.put("teamSize", 12344);
		 
		 given()
		 	.body(map)
		 	.contentType(ContentType.JSON)
		 	
		 .when()
		 	.post("http://localhost:8084/addProject")
		 
		 	.then()
		 		.assertThat().statusCode(201)
		 		.contentType(ContentType.JSON)
		 		.log().all();
		 
	}
}
