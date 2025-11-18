package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemavalidator {
	
	@Test
	public void GETTest()
	{
		baseURI="https://reqres.in/api";
		
		//get("/products").then().;
		
		
		given().header("x-api-key","reqres-free-v1").get("/users?page=2").then().
		assertThat().body(matchesJsonSchemaInClasspath("Schemas/schema.json")).statusCode(200);
		
	}

}
