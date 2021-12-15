package com.crudoperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteResourceTest {
	@Test
	public void delete() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_406");
		ValidatableResponse valiadteResponse = response.then();
		valiadteResponse.log().all();
		valiadteResponse.statusCode(204);
		valiadteResponse.contentType("application/json");
	}

}
