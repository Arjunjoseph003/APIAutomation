package Day6;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;



public class XMLSchemaValidation {
	
	// serialization - converting from pojo to json 
	// deserilaization - converting json to pojo
	
	@Test
	void XMLschemaValidation() {
		
         given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
		
		
		
		
	}

}
