package practiceCRUDwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteResource {
	
	@Test
	public void delete() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_001")
	.then()
		.assertThat().statusCode(204)
		.log().all();
		
}

}
