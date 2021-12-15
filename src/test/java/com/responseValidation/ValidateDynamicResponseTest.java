package com.responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
public class ValidateDynamicResponseTest {
	@Test
	public void validateDynamicResp() {
		String expectedProjName = "TechnoSoft";
		String actualProjName=null;
		Response resp = when()
			.get("http://localhost:8084/projects");
		List<String> list=resp.jsonPath().get("projectName");
		boolean flag=false;
		for(String name:list) {
			if (expectedProjName.equals(name))
			{
				actualProjName=name;
				flag=true;
			}
		}
		Assert.assertEquals(expectedProjName, actualProjName);
		Assert.assertTrue(flag);
		Assert.assertEquals(flag, true);
	}
}
