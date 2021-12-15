package com.differentWaysToPostARequest;

import org.testng.annotations.Test;

import com.ProjectUtilis.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAProjectUsingPojoLibraryTest {
@Test
public void create() {
	PojoLibrary pojo = new PojoLibrary("abd", "rmgy1", "created", 56);
	given()
		.contentType(ContentType.JSON)
		.body(pojo)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		 .assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
}

}
