package endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import pojo.User;

public class Endpoints {
	
	
	public static Response createUser(User user)
	{
		return  given().body(user).when().post("/users");
	}

	public static Response getUser(int id)
	{
		return given().when().get("/users/"+id );
	}
}
