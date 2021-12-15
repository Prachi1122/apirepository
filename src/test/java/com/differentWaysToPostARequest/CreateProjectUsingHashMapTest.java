package com.differentWaysToPostARequest;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMapTest {
@Test
public void create() {
	Random random = new Random();
	int randomNumber=random.nextInt(2000);
	HashMap map = new HashMap();
	map.put("createdBy", "Gunu"+randomNumber);
	map.put("projectName", "TechnoSoft");
	map.put("status", "complete");
	map.put("teamSize", 45);
	given()
		.contentType(ContentType.JSON)
		.body(map)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	
}
}
