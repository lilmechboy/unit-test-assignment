package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);			
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		
		//formatter:off
		return Stream.of(
	
		arguments(2,4,6,false),
		arguments(0,4,4,true),
		arguments(0,-1,-1,true)
		);
		//formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	/*
	 * This parameterized test is for the method {@link TestDemoJUnitTest()}
	 * It shows that the concatenate when method is called it correctly handles legal and illegal values
	 * @param String a the value to concatenate
	 * @param String b the other value to concatenate
	 * @param String expected the expected value\
	 * @param expectException whether we should be expecting an exception or not
	 */
	
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForConcatenateWhen")
	void assertThatTwoStringsAreConcatenated(String a, String b, String expected, boolean expectException) {
		
		//Given: Two strings to test
		
		
		
		if(!expectException) {
			//When: the method to concatenate upon conditions is called
			//Then: The stings are concatenated correctly
			assertThat(testDemo.concatenateWhen(a, b)).isEqualTo(expected);
		}
		else {
			
			//When: The method is called to concatenate under conditions
			//Then: An exception is thrown
			assertThatThrownBy(() -> testDemo.concatenateWhen(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	
	/*
	 * These arguments are for {@link #assertThatTwoStringsAreConcatenated(String, String, String, boolean)}
	 * Junit expects a static method with no parameters to supply the test arguments
	 * 
	 * @return A Stream of test arguments
	 */	
	
	static Stream<Arguments> argumentsForConcatenateWhen() {
		
		//formatter:off
		return Stream.of(
				
				arguments("abc", "abc", "abcabc", false),
				arguments("bc", "bc", "bc", true),
				arguments("abc", "ac", "abc", true)
				);
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	} 
}
