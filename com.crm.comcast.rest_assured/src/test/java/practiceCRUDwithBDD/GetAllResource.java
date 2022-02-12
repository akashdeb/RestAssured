package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllResource {
	
	@Test
	public void createResource() {
		when()
			.get("http://localhost:8084/projects/TY_PROJ_003")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
			
	}

}
