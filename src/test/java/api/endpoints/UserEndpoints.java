package api.endpoints;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created to perform CRUD operations [ CRUD - Create, Read, Update & Delete ]

public class UserEndpoints {

	
	public static Response createUSer(User payload){
		
	    Response res =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
	return res;
		
	}
	
	
	public static Response readUSer(String username){
		
	    Response res =given()
		.pathParam("username", username)
		
		.when()
		.get(Routes.get_url);
	
	return res;
	
		
	}
	
	public static Response updateUSer(String userName, User payload){
		
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			
			.when()
			.put(Routes.update_url);
		
		return res;
		
			
		}	
	
	
    public static Response deleteUSer(String userName){
		
	    Response res =given()
		.pathParam("username", userName)
		
		.when()
		.delete(Routes.delete_url);
	
	return res;
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}