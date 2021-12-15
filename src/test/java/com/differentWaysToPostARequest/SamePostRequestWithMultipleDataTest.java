package com.differentWaysToPostARequest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectUtilis.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SamePostRequestWithMultipleDataTest {
	@Test(dataProvider = "provideData")
	public void multipleData(String createdBy, String projectName, String status, int teamSize) {
		PojoLibrary pojo=new PojoLibrary(createdBy, projectName, status, teamSize);
		given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	@DataProvider
	public Object[][] provideData() {
		Object[][] obj = new Object[2][4];
		
		obj[0][0]="Rakesh";
		obj[0][1]="tyss12";
		obj[0][2]="completed";
		obj[0][3]=10;
		
		obj[1][0]="sohan";
		obj[1][1]="tyss13";
		obj[1][2]="created";
		obj[1][3]=120;
		return obj;
	}
}
