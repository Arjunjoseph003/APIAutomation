package Day3;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class TestHeaders {

	//@Test
	void testHeaders() {
	
	given()
	
	
	.when()
	.get("https://www.google.com")
	
	.then()
	.header("Content-Type", "text/html; charset=ISO-8859-1")
	.and() //multiple validations
	.header("Server", "gws")
	.and()
	.header("Content-Encoding", "gzip")
	.log().all();
	
	
	}	
	@Test
	void testHeadersvalues() {
		
		  Response res=given()
		
		
		.when()
		.get("https://www.google.com");
		  
		  
		  
		String header_value=res.getHeader("Content-Type");
		
		
		// get Multiple headers 
		
		Headers headers_value =res.getHeaders();
		
		for(Header hd : headers_value) {
			System.out.println("The values of the headers:"+hd.getValue());
		}
		
		
		
		}	

	
	
}
