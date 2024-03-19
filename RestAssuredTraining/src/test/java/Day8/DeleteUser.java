package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;



public class DeleteUser {
	
	@Test
	void test_deleteUser(ITestContext context) {
		String bearerToken = "d8f152165d94cf135172aca0ef382cc920487427a4029ca96244b815b9c88902";
		int id =(int) context.getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
        .pathParam("id", id)
        
        
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
		
	}
	
	
	

}
