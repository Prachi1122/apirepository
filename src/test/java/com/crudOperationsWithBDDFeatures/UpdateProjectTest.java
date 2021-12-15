package com.crudOperationsWithBDDFeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectTest {
@Test
public void updateProject() {
	Random random = new Random();
	int randomNumber=random.nextInt(2000);
	JSONObject jobj= new JSONObject();
	jobj.put("createdBy", "virtusa"+randomNumber);
	given()
		.contentType(ContentType.JSON)
		.body(jobj)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_001")
	.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	
}
}
