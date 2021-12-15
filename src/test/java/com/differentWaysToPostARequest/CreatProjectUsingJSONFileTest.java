package com.differentWaysToPostARequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatProjectUsingJSONFileTest {
	@Test
	public void create() {
		File file = new File("./src/test/resources/Data.json");

		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	}
}


