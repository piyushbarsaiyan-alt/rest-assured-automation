package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class PutPatchDeleteExample {
	
	
	@Test
	public void Put()
	{
		
		JSONObject response = new JSONObject();
		response.put("name", "morpheus");
		response.put("job", "zion resident");
		
		baseURI ="https://reqres.in";
		
		given().header("x-api-key","reqres-free-v1").header("Content-Type","application/json").body(response.toJSONString()).
		when().put("/api/users/2").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void Patch()
	{
		
		
		JSONObject response = new JSONObject();
		response.put("name", "morpheus");
		response.put("job", "zion resident");
		
		baseURI ="https://reqres.in";
		
		given().header("x-api-key","reqres-free-v1").header("Content-Type","application/json").body(response.toJSONString()).
		when().patch("/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void Delete()
	
	{
		baseURI ="https://reqres.in";
		given().header("x-api-key","reqres-free-v1").when().delete("/api/users/2").then().statusCode(204).log().all();
	}

}
