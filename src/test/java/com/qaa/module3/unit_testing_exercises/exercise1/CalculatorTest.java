package test.java.com.qaa.module3.unit_testing_exercises.exercise1;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.qaa.module3.unit_testing_exercises.exercise1.Calculator;

class CalculatorTest {
	
	Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	void testAddTwoSmallNumbers() {		
		assertEquals(40,calculator.add(10, 30));
	}
	
	@Test
	void testAddTwoBigNumbers() {		
		assertEquals(13000,calculator.add(10000, 3000));
	}
	
	@Test
	void testAddTwoNegativeNumbers() {		
		assertEquals(-40,calculator.add(-10, -30));
	}

	@Test
	void testSubtractTwoSmallNumbers() {
		assertEquals(-20,calculator.subtract(10, 30));
	}
	
	@Test
	void testSubtractaNegativeNumbers() {
		assertEquals(40,calculator.subtract(10, -30));
	}
	
	@Test
	void testSubtractBigTwoNumbers() {
		assertEquals(7000,calculator.subtract(10000, 3000));
	}

	@Test
	void testMultiplyTwoSmallNumbers() {
		assertEquals(300,calculator.multiply(10,30));
	}
	
	@Test
	void testMultiplyTwoNegativeNumbers() {
		assertEquals(300,calculator.multiply(-10,-30));
	}
	
	@Test
	void testMultiplyOnePosOneNeg() {
		assertEquals(-300,calculator.multiply(10,-30));
	}

	@Test
	void testDivideTwoSmallNumbers() {
		assertEquals(2.5,calculator.divide(5,2));
	}
	
	@Test
	void testDivideTwoBigNumbers() {
		assertEquals(2,calculator.divide(10000,5000));
	}
	
	@Test
	void testDivideByZero() {
		try {
			assertEquals(2.5,calculator.divide(5,0));
			fail("Should raise an execption");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("divisor must not be 0"));
		}				
	}

}
