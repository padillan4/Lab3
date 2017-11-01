import java.util.InputMismatchException;

public final class InfixCalculator {
	
	public static Integer convertToPostfix(String infix) throws InputMismatchException{
	    Stack<Character> stack = new Stack<Character>();
	    Stack<Character> parenMatch = new Stack<Character>();
	    String postfixString = "";
	    InputMismatchException e = new InputMismatchException();
	    String[] intOperands = infix.split("[^0-9]");
	    MyLinkedList<String> listIntOperands = new MyLinkedList<>();
	    
	    for(int i = 0; i < intOperands.length; i++) {
	    	if(intOperands[i].matches("\\b\\d+\\b")) {
	    		listIntOperands.add(intOperands[i]);
	    	}
	    }
	    
	    for(int i = 0; i < infix.length(); i++) {
	    	char val = infix.charAt(i);
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
                    if (!stack.isEmpty()) {
                        oper = stack.peek();
                    }
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
	    		Character oper = infix.charAt(i+1);
	    		
	    		if(!(listIntOperands.isEmpty()) && !(Character.isDigit(oper))) {
	    			postfixString += listIntOperands.get(0) + " ";
	    			listIntOperands.remove(0);
	    		}
            }
        }
	    if(!(parenMatch.isEmpty())) {
        	throw e;
        }
        while (!stack.isEmpty()) {
            Character oper = stack.peek();
            if (!oper.equals(('('))) {
                stack.pop();
                postfixString += oper.charValue() + " ";
            }
        }
        return PostfixCalculator.postFixCalc(postfixString);
	}
}
