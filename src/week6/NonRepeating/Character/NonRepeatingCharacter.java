package week6.NonRepeating.Character;

import java.util.HashMap;

public class NonRepeatingCharacter {

	public static void main(String[] args) {
		String s="hello";
		nonrepeatingCharacter(s);

	}
	
	 static char nonrepeatingCharacter(String S)
	    {
	        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	        
	        for(int i=0;i<S.length();i++){
	           map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
	        }
	        
	        for(int i=0;i<S.length();i++) {
	        	if(map.get(S.charAt(i))==1) {
	        		return S.charAt(i);
	        	}
	        }
	        
	        return '$';
	    }

}
