package com.crudoperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateAResourceTest {
	@Test
	public void create() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "PPP");
		jobj.put("projectName", "evoqTool");
		jobj.put("status", "IP");
		jobj.put("teamSize", 11);


		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType("application/json");
		reqspec.body(jobj);
		Response response = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validateResponse = response.then();

		validateResponse.statusCode(201);
		validateResponse.contentType("application/json");
		validateResponse.log().all();


	}
}
