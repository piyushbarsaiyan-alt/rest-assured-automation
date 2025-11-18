package tests;

import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//import io.restassured.internal.util.IOUtils;

public class SoapXMLRequest {
	
	@Test
	public void SoapXMLPostRequest() throws IOException
	{
		
		File file = new File("./SoapRequest/soap.xml");
		if(file.exists())
		{
			System.out.println(">>  File Exists");
		}
		FileInputStream fileinput =  new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileinput,"UTF-8");
		
		baseURI="http://www.dneonline.com";
		
		
		given().contentType("text/xml").accept(ContentType.XML).body(requestBody).
		when().post("/calculator.asmx").then().statusCode(200).log().all();
		
		
		
		
		
	}

}
