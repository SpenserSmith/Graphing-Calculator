package calculator;

public class BasicOperations {
	
	public static int add(int num1, int num2) {
		return num1+num2;
	}
	
	public static int subtract(int subtractee, int subtractor) {
		return subtractee-subtractor;
	}
	
	public static int multiply(int num1, int num2) {
		return num1*num2;
	}
	
	public static int divide(int dividend, int divisor) {
		return dividend/divisor;
	}

	public static int multiplyByExponent(int numberToMultiply, int exponent) {
		return numberToMultiply^exponent;
	}
	
}
