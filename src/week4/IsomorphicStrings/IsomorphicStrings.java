package week4.IsomorphicStrings;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String args[]) 
	{ 		 
		 String s = "egg";
		 String t = "add";
		 boolean i=isIsomorphic(s,t);
	   	System.out.println(i);
	}
	
	
	
	 public static boolean isIsomorphic(String s, String t) {

	        HashMap<Character, Character> map=new HashMap<Character, Character>();
	        
	        
	        for(int i=0;i<s.length();i++) {
	     
	        	if(!map.containsKey(s.charAt(i))) {
	        		if(!map.containsValue(t.charAt(i))) {
	        			map.put(s.charAt(i), t.charAt(i));
	        		}
	        		else {
	        			
	        			return false;	        			        		
	        		}
	        	}
	        	else {
	        		if(map.get(s.charAt(i))!=t.charAt(i)) {
	        			return false;
	        		}
	        	}
	        }
	        	
	        	
//	        System.out.println(c);
	        return true;
	 }
}
