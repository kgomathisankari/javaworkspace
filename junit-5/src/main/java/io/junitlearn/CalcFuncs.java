package io.junitlearn;

import java.util.stream.IntStream;

public class CalcFuncs {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}

	public int multiply(int a, int b) {
		return a*b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public int square(int a) {
		return a*a;
	}
	
	
	public boolean isEven(int num) {
		return num % 2 == 0;
	}
	
	
}
