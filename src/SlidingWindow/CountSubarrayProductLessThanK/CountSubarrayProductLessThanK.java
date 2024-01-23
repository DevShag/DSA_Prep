package SlidingWindow.CountSubarrayProductLessThanK;

import java.util.Arrays;

public class CountSubarrayProductLessThanK {

	public static void main(String args[]) 
	   { 
	   	    long[] arr=new long[] {1,2,3,4};
	   	    long a= countSubArrayProductLessThanK(arr, arr.length,10);
	   	    System.out.println(a);
			 
	   } 
	
	//https://www.youtube.com/watch?v=pdBe9Ejk8Cw
	//Time Complexity:
	//We iterate the first loop from i=0 to n -> O(n).
	//We used two pointers here which in worst case can iterate for 2n times -> O(2n).
	//Therefore, the time complexity is O(2n), which is approximately O(n).
	//Space Compexity O(1)
	
	public static long countSubArrayProductLessThanK(long a[], int n, long k)
    {
       if(k==1){
           return 0;
       } 
       
       long product=1;
       long count=0;
       
       int left=0;
       int right=0;
       
       while(right<n){
           System.out.println("right : "+right);
           product*=a[right];
          
           while(product>=k) {
        	   product/=a[left];
        	   left++;
           }
           
           count=right-left+1;
           right++;
           
       }
       return count;
    }
}
