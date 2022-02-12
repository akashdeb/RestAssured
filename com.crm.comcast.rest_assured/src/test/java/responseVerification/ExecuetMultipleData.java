 package responseVerification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;
import static io.restassured.RestAssured.*;

public class ExecuetMultipleData {
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][4];
		obj[0][0]="Akash";
		obj[0][1]="PojectDataProvided";
		obj[0][2]="completed";
		obj[0][3]=98;
		
		obj[1][0]="Vijay";
		obj[1][1]="PojectDataProvided2";
		obj[1][2]="completed";
		obj[1][3]=89;
		
		return obj;
	}
	
				
	@Test (dataProvider = "getData")
	public void verify(String createdBy, String projectName, String status, int teamSize ) {
		
		PojoClass pojo = new PojoClass(createdBy, projectName, status, teamSize);
		
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
