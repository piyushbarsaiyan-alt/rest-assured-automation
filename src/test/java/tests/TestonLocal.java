package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class TestonLocal {
	
	@Test(priority =1)
	public void GetTest() {
		
		baseURI="http://localhost:3000";
		
		given().get("/users").then().statusCode(200);
		
	}
	
	@Test(priority =2)
	public void PostTest()
	{
		
		
		JSONObject response = new JSONObject();
		response.put("id", "3");
		response.put("name", "Dev");
		response.put("role", "Developer");
		
		baseURI="http://localhost:3000";
		
		given().contentType("application/json").body(response.toJSONString()).
		when().post("/users").then().statusCode(201).log().all();
		
		
		
	}
	
	
	@Test(priority =3)
	public void PutTest()
	{
		
		
		JSONObject response = new JSONObject();
		response.put("id", "3");
		response.put("name", "Ashok A");
		response.put("role", "Tester A");
		
		baseURI="http://localhost:3000";
		
		given().contentType("application/json").body(response.toJSONString()).
		when().put("/users/3").then().statusCode(200).log().all();
		
		
		
	}
	
	@Test(priority =4)
	public void PatchTest()
	{
		
		
		JSONObject response = new JSONObject();
		response.put("id", "3");
		response.put("name", "Ashok A");
		response.put("role", "Tester B");
		
		baseURI="http://localhost:3000";
		
		given().contentType("application/json").body(response.toJSONString()).
		when().patch("/users/3").then().statusCode(200).log().all();
		
		
		
	}
	
	@Test(priority =5)
	public void DeleteTest()
	{
		
		
		baseURI="http://localhost:3000";
		
		given().contentType("application/json").
		when().delete("/users/3").then().statusCode(204).log().all();
		
		
		
	}
	
}
