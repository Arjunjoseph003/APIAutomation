package Day2;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class DiffWaysToCreatePost {
	
//	@Test(priority=1)
	void testPostUsinhHashMap()
	{
	
		HashMap data = new HashMap();
		data.put("name", "scott");
		data.put("location", "bangalore");
		data.put("phone","12345678678");
		
        String coursearr[]= {"c","c++"};

        data.put("courses",coursearr);
        
        given()
        .contentType("application/json")
        .body(data)
        
        .when()
        .post("http://localhost:3000/students")
        
        .then()
        .statusCode(201)
        .body("name",equalTo("scott"))
        .body("location",equalTo("bangalore"))
        .body("phone",equalTo("12345678678"))
        .body("courses[0]",equalTo("c"))
        .body("courses[1]",equalTo("c++"))
        .header("content-type", "application/json")
        .log().all();
        	
		
	}
	
//	@Test(priority=2)
	void deleteUser()
	{
		
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/4")
		
		.then()
		.statusCode(200);	
	}
//	@Test
	void testPostUsingjsonlibrary()
	{
		JSONObject data = new JSONObject();
		
		data.put("name", "Steve");
		data.put("Location", "US");
		data.put("Phone", "12345678");
		
	String	coursesArr[] = {"python","Java"};
	
	data.put("Courses", coursesArr);
	
	given()
	.contentType("application/json")
	.body(data.toString())

	.when()
	.post("http://localhost:3000/students")
	
	.then()
		.statusCode(201);	
		
	}
	
//	@Test
	void testPostUsingPOJOClass()
	{
		
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setName("moses");
		data.setLocation("bangalore");
		data.setPhone("87654321");
		String coursesArr1[] = {"c","C&"};
		data.setCourses(coursesArr1);
		
	    given()
	    .contentType("application/json")
	    .body(data)
	    
	    .when()
	    .post("http://localhost:3000/students")
	    
	    .then()
		.statusCode(201);
		
	}
	
	@Test
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		File F = new File(".\\body.json");
		FileReader fr = new FileReader(F);
		JSONTokener jt =new JSONTokener(fr);
		JSONObject data = new JSONObject();
	
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201);
			
		
		
		
	}
	
	
	
	

}
