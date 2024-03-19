package Day3;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {
	
	//@Test
	void cookiesDemo() {
		
		given()
		
		
		.when()
		.get("https://www.google.com")
		
		.then()
		.cookie("AEC", "Ae3NU9OAPXV-kBTYfInWBpzTHjWYneTzGjxIDDNLRGex--2gCnFmkOIrdQ")
		.log().all() // prints all 
		.log().body() // prints body
		.log().cookies() // prints cookies
		.log().headers() ;// prints headers
		
		
	}
	
	@Test
	void cookiesInfo() {
		
		Response res=given()
		
		
		.when()
		.get("https://www.google.com");
		
		// get single cookie info
		
//        String	cookie_value = res.getCookie("AEC");
//        System.out.println("the value of cookie :"+ cookie_value);
//		
		
		// get all cookie info
		
		Map<String, String> cookies_values = res.getCookies();	
		
		System.out.println(cookies_values.keySet());
		
		
		for(String k :cookies_values.keySet()){
			 String cookie_value = res.getCookie(k);
			 
			 System.out.println("the value of the cookie :"+cookie_value);
			
			
		}
		
		
		
	}
	
	
	

}
