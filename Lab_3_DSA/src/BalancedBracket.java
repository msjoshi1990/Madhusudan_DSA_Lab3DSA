import java.util.Stack;

public class BalancedBracket {
	
	public static Boolean isBalanced(String exp) {
		
		Stack<Character> stack = new Stack<Character>();
		
        char[] charArray = exp.toCharArray();   
        
        for (int i = 0; i < charArray.length; i++) {
			
            char currChar = charArray[i];   
            
            if (currChar == '{' || currChar == '[' || currChar == '(') {   
                stack.push(currChar);   
                continue;   
            }   
            
            if (stack.isEmpty()) {    
                return false;   
            }   
            
            char popChar;   

            switch (currChar) {
			case ')':
                popChar = (char) stack.pop();   
                
                if (popChar == '{' || popChar == '[')   
                    return false;   
                
				break;
				
			case '}':   
                popChar = (char) stack.pop();   
                if (popChar == '(' || popChar == '[')   
                    return false;   
                break;   
                case ']':   
                popChar = (char) stack.pop();   
                if (popChar == '(' || popChar == '{')   
                    return false;   
                break;  

			default:
				break;
			}

		}

        if (stack.isEmpty()) {
        	return true;
        }
		
		return false;
	}
	
	public static void main(String[] args) {
		
		String exp = "(({}))";
		
		if (BalancedBracket.isBalanced(exp))   
            System.out.println("Balanced.");   
        else   
            System.out.println("Not balanced");   
		
	}

}
