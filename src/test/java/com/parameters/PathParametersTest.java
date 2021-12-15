package com.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParametersTest {
	@Test
	public void path() {
		String proId = "TY_PROJ_1004";
		given()
		.pathParam("projectId", proId)
		.when()
		.get("http://localhost:8084//projects/{projectId}")
		.then().log().all();	
	}

}
