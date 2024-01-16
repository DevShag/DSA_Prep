package Week1;

import java.lang.reflect.Array;
import java.util.*;

public class NumbrTheory {
		
    
    public static void print_divisors(int n) {
    	if(n==1) {
    		System.out.print(n);
    		return;
    	}
    	
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i){
                    arr.add(i);
                }
                else{
                    arr.add(i);
                    arr.add(n/i);
                }
            }
        }
        
        Collections.sort(arr);
        
            for(int i:arr) {
            	System.out.print(i+" ");
            }
           
        
    }
    
    public static int addDigits(int num) {
        int sum=0;
        int count=0;
        while(num!=0){
            sum+=num%10;
            num=num/10;
            count++;
        }
        if(count>1) {
        	return addDigits(sum);
        }
        return sum;
    }
    
    public static int commonFactors(int a, int b) {
        int count =1;
        int limit=(a<b)?a:b;
        int i=2;
        while(i<=limit){
            if(a%i==0 && b%i==0){
                count++;
            }
            i++;
        }
        return count;
    }
    
  
    
    static long StringToNum(String s) {
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        
        long num=0;
        int p=0;
        for(int i=s.length()-1;i>=0;i--) {
        	if(map.containsKey(s.charAt(i))) {
        		int n=map.get(s.charAt(i));
        		num=(int) (n*Math.pow(10, p)+num);
        		p++;
        	}
        }
        
        if(s.charAt(0)=='-') {
        	num*=-1;
        }
        return num;
    }
    
    static String NumToString(int num) {
    	HashMap<Integer,Character> map=new HashMap<Integer,Character>();
        map.put(0, '0');
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');
        
        
        
        StringBuilder str=new StringBuilder();
        
        while (num!=0) {
			int i=num%10;
			if(map.containsKey(i)){
				
				str.append(map.get(i));
			}
		}
        return str.toString();
    }
    
    public static String multiplyStrings(String s1,String s2)
    {
    	String s="342857466747623190253535915582654079729535249666495366204751947309612861759399743340838318159436477709808 4471335218251938463464417392810911901096513109096223883606949011331588570391782354624160500218170491853613331964401401436877119247304542334868677958787620083249";
        long a=StringToNum(s);
        //long b=StringToNum("2");
        
        System.out.println(a);
//        return a*b+"";
        return "";
    }
    
    public static String multIncludimgNegativeNum(String mult1, String mult2) {
    	 if(mult1.compareTo("0")==0 || mult2.compareTo("0")==0){
             return "0";
         }
    	boolean isNegative=false;
    	if(mult1.charAt(0)=='-') {
    		isNegative=true;
    		mult1=mult1.substring(1);
    	}
    	if(mult2.charAt(0)=='-') {
    		isNegative=!isNegative;
    		mult2=mult2.substring(1);
    	}
    	int len1=mult1.length();
    	int len2 = mult2.length();
    	int[] result=new int[len1+len2];
    	int num_shift=0;
    	int totalSum=0;
    	for(int i= len1-1;i>=0;i--) {
    		int mult_digit=mult1.charAt(i)-'0';
    		int carry=0;    		
    		int[] current_product=new int[len2+1];
    		for(int j=len2-1;j>=0;j--) {
    			int digit=mult2.charAt(j)-'0';   			
    			int index=len1+j-num_shift;
    			int product=mult_digit*digit+carry+result[len1+j-num_shift];
//    			int pro=mult_digit*digit+carry;
    			result[len1+j-num_shift]=product%10;
//    			current_product[j+1]=pro%10;
    			carry=product/10;
    			totalSum+=product%10;
    		}
    		if(carry>0) {
    			result[len1-num_shift-1]=carry;
//    			current_product[0]=carry;
    			totalSum+=carry;
    		}  
    		num_shift++;
    		
//    		System.out.println(Arrays.toString(current_product));
    	}
    	System.out.println(Arrays.toString(result));
    	System.out.println( totalSum);
    	if(totalSum==0) {
    		return "0";
    	}
    	String ans="";
    	if(isNegative) {
    		ans+="-";
    	}
    	boolean zero=true;
    	for(int i=0;i<result.length;i++) {
    		if(result[i]==0 && zero) {
    			//its a firt zero do nothing
    			
    		}
    		else {
    			//its not a zero or not a first zero
    			zero=false;
    			ans+=result[i];
    		}
    	}
//    	System.out.println(ans);
    	return ans;

    }
    
    public static String multiply(String num1, String num2) {
    	
    	 if(num1.compareTo("0")==0 || num2.compareTo("0")==0){
             return "0";
         }
        int len1=num1.length();
        int len2=num2.length();
        int numShift=0;
        int[] result=new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            int mulDigit=num1.charAt(i)-'0';
            int carry=0;
            for(int j=len2-1;j>=0;j--){
                int digit=num2.charAt(j)-'0';
                int index=len1+j-numShift;
                int product=mulDigit*digit+carry+result[len1+j-numShift];
                result[index]=product%10;
                carry=product/10;

            }
            if(carry>0){
                result[len1-numShift-1]=carry;
            }
            numShift++;
        }
        String ans="";
        boolean zero=true;
        for(int i=0;i<result.length;i++){
            if(result[i]==0 && zero){

            }
            else{
                zero=false;
                ans+=result[i];
            }
        }
        return ans;
    }
    
    
    public static int largestPrimeFactor(int n) {
    	int ans=0;
    	for(int i=2;i*i<=n;i++) {
    		if(n%i==0) {
    			ans=i;
    			while(n%i==0 && n!=0) {
    				n=n/i;
    			}
    		}
    	}
    	if(n>0) {
    		ans=Math.max(ans, n);
    	}
    	return ans;
    	
    }
    
    public static boolean[] SeiveOfEratonSthenes(int n) {
    	if(n<=2) {
    		boolean[] b=new boolean[1];
    		b[0]=false;
    		return b;
    	}
    	boolean [] isPrime=new boolean[n+1];
    	Arrays.fill(isPrime, true);
    	isPrime[0]=false;
    	isPrime[1]=false;
    	
    	int count=0;
    	for(int i=2;i*i<=n;i++) {
    		count++;
    		int j=2*i;
    		while(j<n) {
    			isPrime[j]=false;
    			j=j+i;
    		}
    		
    	}
    	
    	for(int i=0;i<n;i++) {
    		System.out.println(i+" , "+isPrime[i]);
    	}
    	
    	System.out.println("count : "+count);
    	
    	return isPrime;
    	
    	
    }
  
    // Driver method 
//    public static void main(String args[]) 
//    { 
////    	String s=mult("6", "5");;
////        System.out.println("The divisors of 100 are: "); 
////    	String s=multiplyStrings(null, null);
////    	int p=largestPrimeFactor(4);
////    	System.out.print(p);
////    	SeiveOfEratonSthenes(10);
//    	
//    	System.out.println(i);
//    } 
}
