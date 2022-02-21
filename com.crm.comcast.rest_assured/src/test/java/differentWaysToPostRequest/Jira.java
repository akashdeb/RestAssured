package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Jira {
	
	@Test
	public void create() {
		File file = new File("./jira.json");
		
		given()
		.auth().basic("akashdeb87@gmail.com", "7EfwEYREdfuOgiOdHI7c6670")
	 	.body(file)
	 	.contentType(ContentType.JSON)
	 	
	 .when()
	 	.post("https://akashdebtestyantra.atlassian.net/rest/api/3/issue/")
	 
	 	.then()
	 		.contentType(ContentType.JSON)
	 		.log().all();
	 
	}

}
