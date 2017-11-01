import java.util.InputMismatchException;

public class tester {

	public static void main(String[] args) throws InputMismatchException {
		
		System.out.println(PostfixCalculator.postFixCalc("5 22 3 + / 5 2 - +"));
		System.out.println(InfixCalculator.convertToPostfix("5/(22+3)+(5-2)"));
		
		Integer[][] tour = KnightsTour.startKnightsTour(10, 9, 3);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println(tour[i][j]);
			}
		}

	}

}
