package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import base.BaseTest;
import endpoints.Endpoints;
import io.restassured.response.Response;
import pojo.User;

public class CreateUserTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(CreateUserTest.class);

	@Test
	public void testcreateUser()
	{
		User user = new User("morpheus","leader");
		
		logger.info("Creating user with name: " + user.getName());
		Response response = Endpoints.createUser(user);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		Assert.assertTrue(response.jsonPath().getString("id")!=null);
		
		logger.info("Status Code Received: " + response.getStatusCode());
        logger.info("Response Body: " + response.asString());
	}
}
