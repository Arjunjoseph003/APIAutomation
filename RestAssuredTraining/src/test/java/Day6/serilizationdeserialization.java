package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day2.Pojo_PostRequest;

//pojo --serialiize--> JSON object ---deserialize -- pojo 
public class serilizationdeserialization {
	
	
	
	//@Test
	void convertpojotojson() throws JsonProcessingException {
		
		
		student stupojo = new student();
		stupojo.setName("moses");
		stupojo.setLocation("bangalore");
		stupojo.setPhone("87654321");
		String coursesArr1[] = {"c","C&"};
		stupojo.setCourses(coursesArr1);
		
		//convert java object --> json object(serialization)
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String jsonData = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsonData);
		
		
	}
	
	    @Test
        void converjsontopojo() throws JsonProcessingException {
		
		
		String jsonData ="{\r\n"
				+ "  \"name\" : \"moses\",\r\n"
				+ "  \"location\" : \"bangalore\",\r\n"
				+ "  \"courses\" : [ \"c\", \"C&\" ],\r\n"
				+ "  \"phone\" : \"87654321\"\r\n"
				+ "}";
		
		
		//convert json to pojo
		
		ObjectMapper objmapper = new ObjectMapper();
		student stu = objmapper .readValue(jsonData, student.class);
		
		System.out.println(stu.getName());
		System.out.println(stu.getPhone());
		System.out.println(stu.getLocation());
		System.out.println(stu.getCourses()[0]);
		
		
	}
	
	

}
