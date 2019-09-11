package calculator;

import org.junit.Test;

import exceptions.InvalidInputException;;

public class Equation {

	private static final int CHAR_VALUE_OF_0 = 48;
	private static final int CHAR_VALUE_OF_9 = 57;

	public final boolean[] symbolIsOperator;
	public final Operator[] operators;
	public final int[] numbers;

	protected Equation(String equation) throws InvalidInputException {
		int equationLength = equation.length();
		symbolIsOperator = new boolean[equationLength];
		operators = new Operator[equationLength];
		numbers = new int[equationLength];

		for(int i = 0; i < equationLength; i++) {
			if(characterIsOperator(equation.charAt(i))) {
				symbolIsOperator[i] = true;
				operators[i] = parseOperatorCharacter(equation.charAt(i));
			}else if(characterIsNumber(equation.charAt(i))) {
				numbers[i] = parseNumberCharacter(equation.charAt(i));
			} else {
				throw new InvalidInputException("All characters must be a number or operator");
			}
		}
	}


	private static boolean characterIsOperator(char character) {
		boolean isOperator = false;

		if(character == Operator.ADD.getCharValue())
			isOperator = true;
		else if(character == Operator.SUBTRACT.getCharValue())
			isOperator = true;
		else if(character == Operator.MULTIPLY.getCharValue())
			isOperator = true;
		else if(character == Operator.DIVIDE.getCharValue())
			isOperator = true;
		else if(character == Operator.EXPONENT.getCharValue())
			isOperator = true;
		else if(character == Operator.OPEN_PARENTHESES.getCharValue())
			isOperator = true;
		else if(character == Operator.CLOSE_PARANTHESES.getCharValue())
			isOperator = true;

		return isOperator;
	}

	private static Operator parseOperatorCharacter(char operatorCharacter) {
		Operator parsedOperatorCharacter = null;

		if(operatorCharacter == Operator.ADD.getCharValue())
			parsedOperatorCharacter = Operator.ADD;
		else if(operatorCharacter == Operator.SUBTRACT.getCharValue())
			parsedOperatorCharacter = Operator.SUBTRACT;
		else if(operatorCharacter == Operator.MULTIPLY.getCharValue())
			parsedOperatorCharacter = Operator.MULTIPLY;
		else if(operatorCharacter == Operator.DIVIDE.getCharValue())
			parsedOperatorCharacter = Operator.DIVIDE;
		else if(operatorCharacter == Operator.EXPONENT.getCharValue())
			parsedOperatorCharacter = Operator.EXPONENT;
		else if(operatorCharacter == Operator.OPEN_PARENTHESES.getCharValue())
			parsedOperatorCharacter = Operator.OPEN_PARENTHESES;
		else if(operatorCharacter == Operator.CLOSE_PARANTHESES.getCharValue())
			parsedOperatorCharacter = Operator.CLOSE_PARANTHESES;

		return parsedOperatorCharacter;
	}

	private static int parseNumberCharacter(char numberCharacter) {
		int parsedNumber = -1;
		if(characterIsNumber(numberCharacter)) {
			parsedNumber = numberCharacter - CHAR_VALUE_OF_0;
		}


		return parsedNumber;
	}

	private static boolean characterIsNumber(char character) {
		boolean isNumber = false;

		if(character >= CHAR_VALUE_OF_0 && character <= CHAR_VALUE_OF_9) {
			isNumber = true;
		}

		return isNumber;
	}

	
	
	
	//Equation method Tests
	public static class CharacterIsOperatorTest {
		@Test
		public void testCharacterIsOperator() {
			System.out.println("Testing characterIsOperator:");
			for(int i = 0; i < 127; i++) {

				boolean isOperator = characterIsOperator((char)i);
				if(i == Operator.ADD.getCharValue() || i == Operator.SUBTRACT.getCharValue() || i == Operator.MULTIPLY.getCharValue() || i == Operator.DIVIDE.getCharValue()
						|| i == Operator.EXPONENT.getCharValue() || i == Operator.OPEN_PARENTHESES.getCharValue() || i == Operator.CLOSE_PARANTHESES.getCharValue()){
					assert(isOperator);
					//System.out.println((char)i + " " + isOperator);
				}else
					assert(!isOperator);
			}
		}
	}

	public static class CharacterIsNumberTest {
		@Test
		public void testCharacterIsNumber() {
			System.out.println("Testing characterIsNumber:");
			for(int i = 0; i < 127; i++) {
				//System.out.println((char)i);
				boolean isNumber = characterIsNumber((char)i);
				if(i >= CHAR_VALUE_OF_0 && i <= CHAR_VALUE_OF_9)
					assert(isNumber);
				else 
					assert(!isNumber);
				//System.out.print(" " + isNumber);
			}
		}
	}

	public static class NumberParseTest {
		@Test
		public void testParseNumberCharacter(){
			System.out.println("Testing parseNumberCharacter:");
			for(int i = 0; i < 127; i++) {
				int parsedNumber = parseNumberCharacter((char)i);
				if(characterIsNumber((char)i))
					assert(parsedNumber == i - CHAR_VALUE_OF_0);
				else
					assert(parsedNumber == -1);

				System.out.println("Char: " + (char)i + " num: " + parsedNumber);
			}

		}
	}

	public static class OperatorParseTest {
		@Test
		public void testParseOperatorCharacter() {
			System.out.println("Testing parseOperatorCharacter:");

			for(int i = 0; i < 127; i++) {
				Operator parsedOperator = parseOperatorCharacter((char)i);
				if(i == 40) {
					assert(parsedOperator.equals(Operator.OPEN_PARENTHESES));
				} else if(i == 41) {
					assert(parsedOperator.equals(Operator.CLOSE_PARANTHESES));
				} else if(i == 42) {
					assert(parsedOperator.equals(Operator.MULTIPLY));
				} else if(i == 43) {
					assert(parsedOperator.equals(Operator.ADD));
				} else if(i == 45) {
					assert(parsedOperator.equals(Operator.SUBTRACT));					
				} else if(i == 47) {
					assert(parsedOperator.equals(Operator.DIVIDE));
				} else if(i == 94) {
					assert(parsedOperator.equals(Operator.EXPONENT));
				} else {
					assert(parsedOperator == null);
				}
				//System.out.println((char)i + ": " + parsedOperator);
			}

		}

	}

}


