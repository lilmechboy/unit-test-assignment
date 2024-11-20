package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	public TestDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public int addPositive(int a, int b) {
		
		int result = a + b;
		if ( a > 0 && b > 0) {
			return result;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public String concatenateWhen(String a, String b) {
		
		
		/*
		 * concatenate two strings when the conditions are met.
		 * 
		 * @param String a first value to test and concatenate
		 * @param String B second value to test and concatenate
		 * 
		 * @return a value that meets the conditions and returns a concatenation
		 * 		or returns an illegalArgumentException
		 */
		
		
		if (a.contains("a") && b.contains("b")) {
			return a + b; 
		}
		else {
			throw new IllegalArgumentException("First string must contain a, Second string must contain b");
		}
	}
	
	/*
	 * For step 4-1
	 */
	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
	}
	
	@VisibleForTesting
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}

}
