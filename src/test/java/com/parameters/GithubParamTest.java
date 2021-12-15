package com.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GithubParamTest {
	@Test
	public void pathandqueryparam() {
		given()
			.pathParam("username", "prachi1122")
			.queryParam("sort", "created")
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then().log().all();
		
	}
}
