package com.crudoperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdateTest {
@Test
public void update() {
	JSONObject jobj=new JSONObject();
	jobj.put("status", "completed");
	
	
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jobj);
	
	Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_409");
	ValidatableResponse valiadteResponse = response.then();
	valiadteResponse.log().all();
	valiadteResponse.statusCode(200);
	valiadteResponse.contentType("application/json");
	}
}
