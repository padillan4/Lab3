import java.util.InputMismatchException;

public final class PostfixCalculator {
	
	public static Integer postFixCalc(String s) throws InputMismatchException{
		InputMismatchException e = new InputMismatchException();
		Stack<Integer> stack = new Stack<>();
		String[] foo;
		Integer op1;
		Integer op2;
		if(s.matches("^[\\d\\+\\/\\- \\*]*")){
			foo = s.split(" ");
			for(int i = 0; i < foo.length; i++){
				if(foo[i].matches("\\d+")){
					stack.push(Integer.valueOf(foo[i]));
				}
				else if(foo[i].equals("+")){
					op1 = stack.pop();
					op2 = stack.pop();
					
					stack.push( op1 + op2);
				}
				else if(foo[i].equals("-")){
					op1 = stack.pop();
					op2 = stack.pop();
					
					stack.push( op2 - op1);
				}
				else if(foo[i].equals("/")){
					op1 = stack.pop();
					op2 = stack.pop();
					
					stack.push( op1 / op2);
				}
				else if(foo[i].equals("*")){
					op1 = stack.pop();
					op2 = stack.pop();
					
					stack.push( op1 * op2);
				}
			}
			return stack.pop();
		}
		throw e;
	}
}
