package com.crudoperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
@Test
public void listResource()
{
	//enter URI for getting all the projects
	Response response = RestAssured.get("http://localhost:8084/projects");
	ValidatableResponse validateResponse = response.then();
	//print on console
	//response.prettyPrint();----used to print on the console
	//response.toString();------used to print on the console
	validateResponse.log().all();
	//validate status code
	validateResponse.assertThat().statusCode(200);
	//validate content  type of data
	validateResponse.contentType("application/json");
}

}
