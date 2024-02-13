package week4.ValidAnagram;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
	
	public static void main(String args[]) 
	{ 		 
		 String s = "anagram";
		 String t = "nagaram";
		 boolean i=isAnagram(s,t);
	   	System.out.println(i);
	}
	
//	The time complexity of this algorithm is Linear: O(NLOGN)
//	 The space complexity is constant: O(2N)

	public static boolean isAnagramBrutForce(String s, String t) {
		char arr1[] = s.toCharArray();
		char arr2[] = t.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		String s1=new String(arr1);
		String s2=new String(arr2);
        return s1 == s2;
    }
	
	
//	The time complexity of this algorithm is Linear: O(N)
//	 The space complexity is constant: O(N)

	public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }

         for(int i=0; i<t.length();i++){
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0){
                map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)- 1);
            }
            else{
                return false;

            }
        }
        return true;
        
    }

}
