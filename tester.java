import java.util.InputMismatchException;

public class tester {

	public static void main(String[] args) throws InputMismatchException {
		
		System.out.println(PostfixCalculator.postFixCalc("5 22 3 + / 5 2 - +"));
		System.out.println(InfixCalculator.convertToPostfix("5/(22+3)+(5-2)"));

	}

}
