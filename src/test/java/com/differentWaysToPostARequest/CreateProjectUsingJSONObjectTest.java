package com.differentWaysToPostARequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObjectTest {
	@Test
	public void creatProject() {
		Random random = new Random();
		int randomNumber=random.nextInt(2000);


		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "JinuM");
		jobj.put("projectName", "snippet"+randomNumber);
		jobj.put("status", "InP");
		jobj.put("teamSize", 10);

		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()	
			.assertThat().statusCode(201).contentType(ContentType.JSON)
			.assertThat().log().all();
	}
}