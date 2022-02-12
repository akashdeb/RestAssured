package responseVerification;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class VerifyResponseUsingHamcrestTest {
	
	@Test
	public void verify() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(700L), TimeUnit.MILLISECONDS)
			.log().all();
			
			
		
	}

}
