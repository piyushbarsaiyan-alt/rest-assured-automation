package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class testexample {
	
	@Test
	public void test()
	{
		Response response =get("https://reqres.in/api/users?page=2");
		
		int statuscode =response.getStatusCode();
		assertEquals(statuscode, 200);
		System.out.println("status code :"+ statuscode);
		System.out.println("Response body "+ response.getBody());
	}

	@Test
	public void test2()
	{
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id",equalTo(8) ).log().all();
		
	}
}
