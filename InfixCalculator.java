import java.util.InputMismatchException;

public final class InfixCalculator {
	
	public static String convertToPostfix(String infix) throws InputMismatchException{
	    Stack<Character> stack = new Stack<Character>();
	    Stack<Character> parenMatch = new Stack<Character>();
	    char[] c = infix.toCharArray();
	    String postfixString = "";
	    InputMismatchException e = new InputMismatchException();
	    String[] splitArray = infix.split("[^0-9]");
	    String[] intArray = new String[splitArray.length];
	    
	    for(int i = 0; i < splitArray.length; i++) {
	    	System.out.println(splitArray[i] + " ");
	    	if(splitArray[i].matches("[0-9]")) {
	    		intArray[i] = splitArray[i];
	    	}
	    }
	    
	    for(int i = 0; i < intArray.length; i++) {
	    	System.out.println(intArray[i] + " ");
	    	
	    }
	    
	    for(char val : c) {
	    	if(val == '(') {
	    		stack.push(val);
	    		parenMatch.push(val);
	    	}
	    	else if (val == ')') {
                Character oper = stack.peek();
                parenMatch.pop();

                while (!(oper.equals('(')) && !(stack.isEmpty())) {
                    stack.pop();
                    postfixString += oper.charValue() + " ";
                    if (!stack.isEmpty())
                        oper = stack.peek();
                }
                stack.pop();
            }
	    	else if (val == '+' || val == '-') {
                if (stack.isEmpty()) {
                    stack.push(val);
                } else {
                    Character oper = stack.peek();
                    while (!(stack.isEmpty() || oper.equals(('(')) || oper.equals((')')))) {
                        oper = stack.pop();
                        postfixString += oper.charValue() + " ";
                    }
                    stack.push(val);
                }
            }
	    	else if (val == '*' || val == '/') {
                if (stack.isEmpty()) {
                    stack.push(val);
                } else {
                    Character oper = stack.peek();
                    while (!oper.equals(('(')) && !oper.equals(('+')) && !oper.equals(('-')) && !stack.isEmpty()) {
                        oper = stack.pop();
                        postfixString += oper.charValue() + " ";
                    }
                    stack.push(val);
                }
            } 
	    	else {
                postfixString += val + " ";
            }
        }
        while (!stack.isEmpty()) {
            Character oper = stack.peek();
            if (!oper.equals(('('))) {
                stack.pop();
                postfixString += oper.charValue() + " ";
            }
        }
        if(!(parenMatch.isEmpty())) {
        	throw e;
        }
        return postfixString;
	}
}
