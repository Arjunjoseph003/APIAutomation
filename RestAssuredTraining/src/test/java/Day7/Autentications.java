package Day7;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Autentications {
	
	//@Test(priority = 1)
   void testBasicAuthentications() {
	   
	   
	   given()
	   .auth().basic("postman", "password")
	   
	   .when()
	   .get("https://postman-echo.com/basic-auth")
	   
	   .then()
	   .statusCode(200)
	   .body("authenticated", equalTo(true));
   }
	
	//@Test(priority = 2)
	void testDigestAuthentications() {
		   
		   
		   given()
		   .auth().digest("postman", "password")
		   
		   .when()
		   .get("https://postman-echo.com/basic-auth")
		   
		   .then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true));
	   }
	//@Test(priority = 3)
	void PreeempyiveAuthentications() {
		   
		   
		   given()
		   .auth().preemptive().basic("postman", "password")
		   
		   .when()
		   .get("https://postman-echo.com/basic-auth")
		   
		   .then()
		   .statusCode(200)
		   .body("authenticated", equalTo(true));
	

}
	
	//@Test(priority = 4)
	void testBearertTokenAuthentication() {
		
		String  bearerToken="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";
		
		given()
		.headers("Authorization","Bearer"+bearerToken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();	
		
	}
	
	
	//@Test
	void TestOAUTH1Authentication() {
		
		
		given()
		.auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokensecrate") // this is for oauth1 authentication
		
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	
	
	//@Test
	void testoauth2authentication() {
		
		
		given()
		.auth().oauth2("ghp_224pH0Icz1PKHClqotLwj57AuDYmtSz2fuYKP")
		
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	   @Test
		void testAPIKeyAuthentication() {
			
			
		   // Method1
		   given()
			.queryParam("appid", "5729b308bf119b0abf30535f2553f6b3") //appid is key
			
			.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
			
			.then()
			.statusCode(200)
			.log().all();
			
		   
		   // Method2
		   given()
		   .pathParam("mypath", "data/2.5/forecast/daily")
		   .queryParam("appid", "5729b308bf119b0abf30535f2553f6b3")
		   .queryParam("q", "Delhi")
		   .queryParam("units", "metric")
		   .queryParam("cnt", "7")
		   
		   .when()
		   .get("https://api.openweathermap.org/{mypath}")
		   
		   .then()
		   .statusCode(200)
		   .log().all();
		}
	
	
	
	
	
	
	
	
	
	
	
}
