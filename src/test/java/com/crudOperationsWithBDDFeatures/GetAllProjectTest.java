package com.crudOperationsWithBDDFeatures;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjectTest {
@Test
public void getProject(){
	
	when()
		.get("http://localhost:8084/projects")
	.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
}
}
