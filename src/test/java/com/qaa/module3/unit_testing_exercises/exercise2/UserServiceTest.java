package test.java.com.qaa.module3.unit_testing_exercises.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.qaa.module3.unit_testing_exercises.exercise2.UserService;

class UserServiceTest {
	
	UserService userService; 

	@BeforeEach
	void setUp() throws Exception {
		userService = new UserService();
	}

	@AfterEach
	void tearDown() throws Exception {
		userService = null;
	}

	@Test
	void testRegisterValid() {
		
		assertEquals("bobby",userService.register("bobby", "Codes123"));
	}
	
	@Test
	void testRegisterpasswordNoNumber() {
		
		try {
			userService.register("fobby", "Codess");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must contain at least 1 number character"));
		}				
	}
	
	@Test
	void testRegisterpasswordTooShort() {
		
		try {
			userService.register("fobby", "Codes");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must contain at least 6 characters"));
		}				
	}
	
	@Test
	void testRegisterpasswordEmpty() {
		
		try {
			userService.register("fobby", "  ");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must not be whitespace only"));
		}				
	}
	
	@Test
	void testRegisterpasswordNull() {
		
		try {
			userService.register("fobby", null);
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must not be null"));
		}				
	}
	
	@Test
	void testRegisterpasswordNoUppercase() {
		
		try {
			userService.register("fobby", "markie1");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must contain at least 1 uppercase character"));
		}				
	}
	
	@Test
	void testRegisterpasswordNoLowercase() {
		
		try {
			userService.register("fobby", "MARKIE1");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Password must contain at least 1 lowercase character"));
		}				
	}
	
	@Test
	void testRegisterusernameNull() {
		
		try {
			userService.register(null, "Codes123");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Username must not be null"));
		}				
	}
	
	@Test
	void testRegisterusernameEmpty() {
		
		try {
			userService.register("  ", "Codes123");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Username must not be whitespace only"));
		}				
	}
	
	@Test
	void testRegisterusernamelessthan4chars() {
		
		try {
			userService.register("Ben", "Codes123");
			userService.register("Ben", "Codes123");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Username must contain at least 4 characters"));
		}				
	}
	
	@Test
	void testRegisterusernameAlreadyExists() {
		
		try {
			userService.register("bobby", "Codes123");
			userService.register("bobby", "Codes123");
			fail("exception expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("Username already exists"));
		}				
	}
	
	

	@Test
	void testLogin() {
		userService.register("bobby", "Codes123");
		assertEquals("bobby",userService.login("bobby", "Codes123"));
	}

}
