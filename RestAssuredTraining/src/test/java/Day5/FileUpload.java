package Day5;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUpload {

	void singleFileUpload() {
		
		
		File file = new File("C:\\Automationpractise\\store.json");
	 given()
	 .multiPart("file",file)// form data to send the file 
	 .contentType("multipart/form-data")
    
     
     .when()
     .post("http://localhost:8080/uploadfile")
     
     .then()
	 .statusCode(200)
	 .body("filename",equalTo("store.json"));
	
		
	}
	
	
	
      void multiplFileUpload() {
		
		
		File file1 = new File("C:\\Automationpractise\\store.json");
		File file2 = new File("C:\\Automationpractise\\students.json");
	 given()
	 .multiPart("files",file1)
	 .multiPart("files",file2)// form data to send the file 
	 .contentType("multipart/form-data")
    
     
     .when()
     .post("http://localhost:8080/uploadMultiplefile")
     
     .then()
	 .statusCode(200)
	 .body("[0].filename",equalTo("store.json"))
	 .body("[1].filename",equalTo("students.json"));
	 
	 
	 //sending more than 10 file at a time
	 
	File filearr[] = {file1,file2};
	
		
	}
	
      
      void dowloadFile() {
      
    	  given()
    	  
    	  .when()
    	  .post("http://localhost:8080/downloadfile/store.json")
    	  .then()
    	  .statusCode(200);
      }
      
      
      
      
	
}
