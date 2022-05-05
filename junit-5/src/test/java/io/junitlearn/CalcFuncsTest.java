package io.junitlearn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalcFuncsTest {
	CalcFuncs cal;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	void beforeAllInit() {
		System.out.println("Before All the initialization....");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		cal = new CalcFuncs();
		testReporter.publishEntry("Running the  "+testInfo.getDisplayName()+" method ");
	}
	
	@AfterEach
	void cleanup() {
		System.out.println();
	}

	@Test
	void testAdd() {
		int expected =2;
		int actual = cal.add(1, 1);
		assertEquals(expected,actual, "The add method should add two numbers");
	}
	
	@Nested
	@DisplayName("Nested Test for Addition")
	class AddTest {
		
		@Test
		@DisplayName("Add two Positive Numbers")
		void testAddPositive() {
			assertEquals(2,cal.add(1, 1), "The add method should add two + numbers");
		}
		
		@Test
		@DisplayName("Add two Negative Numbers")
		void testAddNegative() {
			assertEquals(-4,cal.add(-3, -1), ()->"The add method should add two - numbers");
		}
	}
	
	@RepeatedTest(3)
	@DisplayName("Square Root of a Number")
	void testSquareRoot() {
		assertEquals(4, cal.square(2), "The square of the given number" );
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,4,5})
	void testIsEven(int num) {
		Assertions.assertTrue(cal.isEven(num));
	}
	
	@ParameterizedTest
	@MethodSource("generateEvenNumbers")
	void testIsEvenMethodSource(int num) {
		Assertions.assertTrue(cal.isEven(num));
	}
	
	IntStream generateEvenNumbers() {
		  return IntStream.iterate(0, i -> i + 2).limit(50);
	}
	
	
	@Test
	@DisplayName("Assert All experiment")
	void testMultiply() {
		testReporter.publishEntry("Running the  "+testInfo.getDisplayName()+" method ");
		assertAll(
				()-> assertEquals(4,cal.multiply(2, 2)),
				()-> assertEquals(0,cal.multiply(0, 2)),
				()-> assertEquals(-4,cal.multiply(-4, 1))
				);
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, ()->cal.divide(1,0), "Divide throws Exception");
		
	}

}
