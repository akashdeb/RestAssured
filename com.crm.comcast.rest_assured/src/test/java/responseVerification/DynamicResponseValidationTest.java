package responseVerification;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DynamicResponseValidationTest {
	
	@Test
	public void verify() {
		
		String expectedProjectName=  "Project_RestAssured762";
			Response response = when()
				.get("http://localhost:8084/projects");
			List<String> actualProjectName = response.jsonPath().get("projectName");
			boolean flag = false;
			
			for(String pName:actualProjectName) {
				if(pName.equals(expectedProjectName)) {
					flag=true;
				}
			}
			response.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
			
		Assert.assertEquals(flag, true);
			
		
	}


}
