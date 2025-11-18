package base;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import  io.restassured.RestAssured;
import utils.ConfigueReader;


public class BaseTest {
	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod
public void setup()
{
	//	RestAssurred  baseURI="https://reqres.in/api";
		
		logger.info("Request specification initialized successfully");
		RestAssured.baseURI =ConfigueReader.getProperty("baseURI");
		RestAssured.requestSpecification = given().header("x-api-key",ConfigueReader.getProperty("apiKey")).
				header("Content-Type", "application/json");
		
		
		logger.info("Base URI set to: " + ConfigueReader.getProperty("baseURI"));
        logger.info("Auth Token added successfully");
}

}
