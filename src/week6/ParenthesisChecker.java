package week6;

import java.util.Stack;

public class ParenthesisChecker {
	
	public static void main(String[] args) {
		String str="{([])}";
		boolean b=ispar(str);
		System.out.println(b);
	}
	
	  static boolean ispar(String x)
	    {
		  if(x.length()%2!=0){
	            return false;
	        }
	        Stack<Character> stack=new Stack<Character>();
	      
	        for(int i=0; i<x.length();i++){
	            char c=x.charAt(i);
	            if(c=='{' || c== '[' || c=='('){
	                stack.push(c);
	                continue;
	           
	            }
	            
	            if(stack.isEmpty()) {
	            	return false;
	            }
	            
	            char p=stack.peek();
	            
	            switch(c){
	                case '}':
	             
	                    if(p!='{'){
	                        return false;
	                    }
	                    break;
	                    
	                    case ')':
	                    if(p!='('){
	                        return false;
	                    }
	                    break;
	                    
	                    case ']':
	                    if(p!='['){
	                        return false;
	                    }
	                    break;
	            }
	            stack.pop();
	        }
	        return true;
	    }

}
