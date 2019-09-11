import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import calculator.Equation.*;

public class Main {

	public static void main(String[] args) {
		
	}

	public static void RunTests() {
		Result result = JUnitCore.runClasses(CharacterIsOperatorTest.class, CharacterIsNumberTest.class, NumberParseTest.class, OperatorParseTest.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());

	}
	
}
