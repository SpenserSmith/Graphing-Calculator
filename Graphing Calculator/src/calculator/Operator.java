package calculator;

public enum Operator {

	ADD(43),
	SUBTRACT(45),
	MULTIPLY(42),
	DIVIDE(47),
	EXPONENT(94),
	OPEN_PARENTHESES(40),
	CLOSE_PARANTHESES(41);
	
	private int charValue;
	
	private Operator(int operatorValue) {
		this.charValue = operatorValue;
	}
	
	public int getCharValue() {
		return charValue;
	}
	
}
