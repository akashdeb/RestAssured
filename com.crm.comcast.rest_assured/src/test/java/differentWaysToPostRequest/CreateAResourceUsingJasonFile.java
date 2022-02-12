package differentWaysToPostRequest;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResourceUsingJasonFile {
	
	@Test
	public void create() {
		File file = new File("./jsonData.json");
		
		given()
	 	.body(file)
	 	.contentType(ContentType.JSON)
	 	
	 .when()
	 	.post("http://localhost:8084/addProject")
	 
	 	.then()
	 		.assertThat().statusCode(201)
	 		.contentType(ContentType.JSON)
	 		.log().all();
	 
	}

}
