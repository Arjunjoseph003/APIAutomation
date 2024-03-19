package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	
@Test	
void test_updateUser(ITestContext context) {
	
	
		
		
		Faker fake = new Faker(); // using faker class to create the dummy data randomly
		
		JSONObject data = new JSONObject(); // using json object to create the data
		
		data.put("name", fake.name().fullName());
		data.put("gender", "Male");
		data.put("EmailAddress", fake.internet().emailAddress());
		data.put("Status", "active");
		
		
		String bearerToken = "d8f152165d94cf135172aca0ef382cc920487427a4029ca96244b815b9c88902";
		int id =(int) context.getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
        .body(data.toString())
        .pathParam("id", id)
        
        
		.when()
		.post("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
}

}
