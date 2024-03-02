package week6.RemoveOutermostParentheses;

import java.util.Stack;

public class RemoveOutermostParentheses {

	public static void main(String[] args) {
		String s = "(()())(())";
		String str=removeOuterParentheses(s);

	}
	
	 public static String removeOuterParentheses(String s) {
		 Stack<Character> stack=new Stack<>();
		 StringBuilder str=new StringBuilder();
		 
		 for(int i=0; i<s.length();i++) {
			 char c=s.charAt(i);
			 if(c=='(') {
				 if(stack.size()>0) {
					 str.append(c);
				 }
				 stack.push(c);
			 }
			 else {
				 stack.pop();
				 if(stack.size()>0) {
					 str.append(c);
				 }
			 }
		 }
		 return str.toString();
	 }

}
