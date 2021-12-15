package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParametersTest {
	@Test
	public void form() {
		
		given()
			.contentType(ContentType.JSON)
				.formParam("createdBy", "susmita")
				.formParam("projectName", "cogni")
				.formParam("status", "Doing")
				.formParam("teamSize", 16)
			.when()
			.post("http://localhost:8084/addProject")
			.then().log().all();
			
		
	}

}
