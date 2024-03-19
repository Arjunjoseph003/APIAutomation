package Day4;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponseData {
	
	//@Test
	void testJSONResponse() {
		
		
		//approach1
		
//		given()
//		.contentType("ContentType.JSON")
//		
//		.when()
//		.get("http://localhost:3000/store")
//		
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "")
//		.body("book[3].title", equalTo("The Lord of the rings"));
		
		
		//approach 2
		
		Response res = given() // getting the response to the variable
		.contentType("ContentType.JSON")
		
		
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		String bookName = res.jsonPath().get("book[3].title").toString();
		
		Assert.assertEquals(bookName, "The Lord of the rings");
	}
	
	@Test
   void testJSONResponsedata() {
		
		//approach 2
		
//		Response res = given() // getting the response to the variable
//		.contentType("ContentType.JSON")
//		
//		
//		.when()
//		.get("http://localhost:3000/store");
//		
//		Assert.assertEquals(res.getStatusCode(), 200);
//		Assert.assertEquals(res.header("Content-Type"), "application/json");
//		String bookName = res.jsonPath().get("book[3].title").toString();
//		
//		Assert.assertEquals(bookName, "The Lord of the rings");
		
   Response res =        		
		
        given()

       .when()
       .get("http://localhost:3000/store");
   
       JSONObject jo = new JSONObject(res.toString());// converting repsonse to jsonobject
       
       
       boolean status = false;
       
       for(int i=0;i<=jo.getJSONArray("book").length();i++) {
    	   
    	   String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
    	   System.out.println(bookTitle);
    	   if(bookTitle.equals("The Lord of the rings"))
    	   {
           status = true;
    	   break;
    	     
    	   }
    	   
    	   
       }
    
       
        Assert.assertEquals(status, true);
        
        
        double totalPrice = 0;
        for(int i=0;i<=jo.getJSONArray("book").length();i++) {
     	   
     	   String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
     	   System.out.println(price);
     	   
     	   
        
     	  totalPrice =totalPrice+Double.parseDouble(price);
     	  System.out.println("totalPrice");
     	  
     	  Assert.assertEquals(status, 53.92);
        
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
   

		
	}
}
