package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDriventest {
	
	
	@Test (priority = 1, dataProvider="Data",dataProviderClass = DataProviders.class)
	   public void  test_postUser(String userid, String userName, String fname, String lname, String useremial, String pwd, String ph){
		
			User userpayload = new User();
			
			userpayload.setId(Integer.parseInt(userid));
			userpayload.setUsername(userName);
			userpayload.setFirstName(fname);
			userpayload.setLastName(lname);
			userpayload.setEmail(useremial);
			userpayload.setPassword(pwd);
			userpayload.setPhone(ph);
		
		
	    	
		    Response response = UserEndpoints.createUSer(userpayload);
		    Assert.assertEquals(response.getStatusCode(), 200); 
	    	
	    }
	
	
	@Test(priority = 2, dataProvider="UserNames", dataProviderClass = DataProvider.class)
	public void testDeleteuser(String userName) {
		
		
		   Response response = UserEndpoints.deleteUSer(userName);
		   Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
