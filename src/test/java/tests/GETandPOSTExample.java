package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GETandPOSTExample {
	
	@Test
	public void GETTest()
	{
		baseURI="https://reqres.in/api";
		
		given().header("x-api-key","reqres-free-v1").get("/users?page=2").then().statusCode(200)
		.body("data[3].first_name", equalTo("Byron")).body("data.first_name", hasItems("Tobias","Rachel"));
		
	}
	
	@Test
	public void POSTTest()
	{
		 
		baseURI="https://reqres.in/api";
		//Map<String,Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");
		
		//System.out.println(map);
		System.out.println(request.toJSONString());
		
		given().contentType("application/json").
		body(request.toJSONString()).header("x-api-key","reqres-free-v1").
		when().post("/users?page=2").
		then().statusCode(201).log().all();
		
		
	}
}
