package com.responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidStaticResponseTest {
	@Test
	public void responseValidate() {
		String expectedProjName = "automation_project";
		Response resp = when()
			.get("http://localhost:8084/projects");
		String actualProjName=resp.jsonPath().get("[0].projectName");
		
		System.out.println("actual value  "+actualProjName);
		System.out.println("expected value "+expectedProjName);
		
		resp.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		Assert.assertEquals(expectedProjName, actualProjName);
		
			
	}
}
