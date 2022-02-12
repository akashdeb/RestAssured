package com.RMGYantraTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseAPIClass;
import genericUtility.IEndPoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;
import static io.restassured.RestAssured.*;

public class ModifyResourceAndVerifyInDbTest extends BaseAPIClass {

	@Test
	public void modifyResourceAndVerifyInDbTest() throws Throwable
	{
		//Step1: Create test data
		//String projectId= "TY_PROJ_206";
		PojoClass pObj = new PojoClass("NewUser", "NewProject", "Completed", 200);
		Response resp = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				//Step2: action-Update
				.when()
				.put(IEndPoint.updateProject);

		//Step3: get projectId From response body
		String expData = rLib.getJSONData(resp, "createdBy");
		Reporter.log(expData+" data found in response body", true);

		//Step4: verify in db
		String query= "select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 2, expData);
		Reporter.log(actData +" data created by in db", true);

		Assert.assertEquals(expData, actData);
		Reporter.log("Verification successful",true);

	}
}