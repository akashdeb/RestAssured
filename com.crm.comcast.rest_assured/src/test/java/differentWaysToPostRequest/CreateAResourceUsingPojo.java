package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

public class CreateAResourceUsingPojo {
	
	@Test
	public void create() {
		 
		PojoClass pojo = new PojoClass("Akash101", "CreatedUsing Pojo", "Completed", "555");
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
	
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}

}
