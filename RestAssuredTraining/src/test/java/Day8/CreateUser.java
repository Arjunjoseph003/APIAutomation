package Day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	void test_createUser(ITestContext context) {
		
		
		Faker fake = new Faker(); // using faker class to create the dummy data randomly
		
		JSONObject data = new JSONObject(); // using json object to create the data
		
		data.put("name", fake.name().fullName());
		data.put("gender", "Male");
		data.put("EmailAddress", fake.internet().emailAddress());
		data.put("Status", "Inactive");
		
		
		String bearerToken = "d8f152165d94cf135172aca0ef382cc920487427a4029ca96244b815b9c88902";
		
		int id= given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
        .body(data.toString())
        
        
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		context.setAttribute("user_id", id); // test level access
//		context.getSuite().setAttribute("User_id", id); // suite level access
		
//		String id = res.jsonPath().get("id").toString();
//		String gender = res.jsonPath().get("gender").toString();
//		String EmailAddress = res.jsonPath().get("EmailAddress").toString();
		
		
		
		
		

		
		
		
		
		
		
	}

}
