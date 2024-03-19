package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;


public class GetUser {
	@Test
	void test_getuser(ITestContext context) {
		
		String bearerToken = "d8f152165d94cf135172aca0ef382cc920487427a4029ca96244b815b9c88902";
		int id =(int) context.getAttribute("user_id");
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
