package week4.LargestOddNumber;

public class LargestOddNumber {
	
	public static void main(String args[]) 
	{ 		 
		 String s = "10133890";
		 String i=largestOddNumber(s);
	   	System.out.println(i);
	}
	
	
	 public static String largestOddNumber(String num) {
	        
	        for(int i=num.length()-1;i>=0;i--){
	            int d=num.charAt(i)-'0';
	            if(d%2!=0){
	                if(i==num.length()-1){
	                    return num;
	                }
	                return num.substring(0,i+1);
	               
	            }
	            
	        }
	        
	        return "";
	    }

}
