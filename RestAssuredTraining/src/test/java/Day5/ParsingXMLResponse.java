package Day5;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;





public class ParsingXMLResponse {
	
	
	//@Test
	void testXMLResponse() 
	{
	
		// approach 1
//		given()
//		
//		.when()
//		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "application/xml; charset=utf-8")
//		.body("TravelerinformationResponse.page",equalTo("1"))
//		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		
		
		//approach2
		Response Res = given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(Res.getStatusCode(), 200);
		Assert.assertEquals(Res.getHeader("Content-Type"), "application/xml; charset=utf-8");
		String pageNO = Res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNO, "1");
		String travellerName = Res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travellerName, "Developer");
		
		
		
		
		
		
		
		
	}
	
	@Test
	void testXMLResponsedata() 
	{
	
		//approach2
		Response Res = given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj =new XmlPath(Res.asString());
		
		// finding the traveller size
		List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		int size = travellers.size();
		Assert.assertEquals(size, 10);
		
		
		// finding the traveller name
		List<String> travellers_name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		for(String travellername:travellers_name) {
			System.out.println(travellername);
			
			if(travellername.equals("Developer123")) {
				status = true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
