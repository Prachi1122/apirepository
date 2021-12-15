package com.crudOperationsWithBDDFeatures;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteAProjectTest {
@Test
public void delet() {
	when()
		.delete("http://localhost:8084/projects/TY_PROJ_003")
	.then()
		.assertThat().statusCode(204).contentType(ContentType.JSON)
		//if we delete anything status code should be 204
		.log().all();
}
}