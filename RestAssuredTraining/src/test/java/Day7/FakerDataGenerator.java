package Day7;


import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	
	@Test
	void testGenerateDummydata() {
		
		Faker f =new Faker();
		String fullName = f.name().fullName();
		String firstName = f.name().firstName();
		String lastName = f.name().lastName();
		String username = f.name().username();
		String password = f.internet().password();
		String cellPhone = f.phoneNumber().cellPhone();
		String safeEmailAddress = f.internet().safeEmailAddress();
		String creditCardExpiry = f.business().creditCardExpiry();
		System.out.println(fullName+firstName+lastName+username+password);
	
		
		
		
	}

}
