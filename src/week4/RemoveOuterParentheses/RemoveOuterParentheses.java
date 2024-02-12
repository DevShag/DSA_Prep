package week4.RemoveOuterParentheses;

import java.util.Stack;

public class RemoveOuterParentheses {
	
	public static void main(String args[]) 
	{ 		 
		 String s = "(()())(())(()(()))";
		 String i=removeOuterParentheses(s);
	   	System.out.println(i);
	}
	
	public static String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<Character>();
        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                if(stack.size()>0){
                    sb.append(c);
                }
                stack.push(c);
            }
            else{
                stack.pop();
                if(stack.size()>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
