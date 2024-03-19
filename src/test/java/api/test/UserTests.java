package api.test;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
    @BeforeClass	
	public void setupData() {
		
    	faker= new Faker();
    	
    	userpayload = new User();
    	userpayload.setId(faker.idNumber().hashCode());
    	userpayload.setUsername(faker.name().username());
    	userpayload.setFirstName(faker.name().firstName());
    	userpayload.setLastName(faker.name().lastName());
    	userpayload.setEmail(faker.internet().emailAddress());
    	userpayload.setPassword(faker.internet().password(5,10));
    	userpayload.setPhone(faker.phoneNumber().cellPhone());
    	
    	
	}
	
    
    
   @Test (priority = 1)
   public void  test_postUser(){
    	
	   Response response = UserEndpoints.createUSer(userpayload);
	   response.then().log().all();
	   Assert.assertEquals(response.getStatusCode(), 200); 
    	
    }

   @Test (priority = 2)
   public void  test_getUser(){
    	
	   Response response = UserEndpoints.readUSer(this.userpayload.getUsername());
	   response.then().log().all();
	   Assert.assertEquals(response.getStatusCode(), 200); 
    	
    }

   @Test (priority = 3)
   public void  test_updateUser(){
    	
	   userpayload.setFirstName(faker.name().firstName());
   	   userpayload.setLastName(faker.name().lastName());
   	userpayload.setEmail(faker.internet().emailAddress());
	   
	   Response response = UserEndpoints.updateUSer(this.userpayload.getUsername(),userpayload);
	   response.then().log().all();
	   Assert.assertEquals(response.getStatusCode(), 200); 
    	
    }
   
   
   @Test (priority = 4)
   public void  test_deleteUser(){
    	
	  
	   
	   Response response = UserEndpoints.deleteUSer(this.userpayload.getUsername());
	   response.then().log().all();
	   Assert.assertEquals(response.getStatusCode(), 200); 
    	
    }
   
   
   
   
   
   
   
   
   
   
   
   
}
