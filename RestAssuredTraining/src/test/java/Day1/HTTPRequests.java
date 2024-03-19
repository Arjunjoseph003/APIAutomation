package Day1;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

//given() - content type, set cookies, add auth, add param, set headers info etc..
//when() - request url ( get, post, put, delete etc)
//then() - validate status code, extract response, extract headers cookies and response body




public class HTTPRequests {

	int id;
	
	//@Test
	void getUser()
	{
		
		given()
		
		.when()
	
		       .get("https://reqres.in/api/users?page=2")
		
		.then()
		
		       .statusCode(200)
		       .body("page",equalTo(2))
		       .log().all();
	}
	
	@Test(priority =1)
	void createUser()
	{
		
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "trainer");
		
		
		
		id = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
		
	}
	
	@Test(priority =2)
	void updateUser()
	{
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "teacher");
		
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users"+id);
		
		
//	  .then()
//	   .statusCode(201)
//	   .log().all();
		
	}
	
	@Test
	void deleteUser()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users"+id)
		
		
		.then()
		.statusCode(204)
		.log().all();
	}
	
	
	
}
