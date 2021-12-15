package com.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParametersTest {
	@Test
	public void queryTest() {
		given()
		   .queryParam("page", "2")
		.when()
		   .get("https://reqres.in/api/users")
		 .then()
		     .log().all();
		
	}
}
