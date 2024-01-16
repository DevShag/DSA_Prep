package week3;

import java.util.*;

public class ArrayWeek3 {
	
	public static int solve(ArrayList<Integer> A, int B) {
        int sum=0;
        for(int i=0;i<B;i++){
            sum+=A.get(i);
        }
        int len=A.size();
        int j=0;
        int newSum=sum;
        while(j<B){
            int include=A.get(len-1-j);
            int exclude=A.get(B-1-j);
            newSum+=include-exclude;
            if(newSum>sum){
                sum=newSum;
            }
            j++;
           
        }
        return sum;
    }
	
	
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	//Time complexity O(N²)
	//Space Complexity O(1);
	 public int maxProfitBrutForce(int[] prices) {
	        
	        int maxProfit=0;

	        for(int i=0;i<prices.length-1;i++){
	            for(int j=i+1;j<prices.length;j++){
	                int profit=-prices[i]+prices[j];
	             //   System.out.println("i: "+prices[i]+", j : "+prices[j]+", profit : "+profit);
	                if(profit>maxProfit){
	                    maxProfit=profit;
	                }
	            }
	        }
	        return maxProfit;
	 }
	
	 
	//Time complexity O(N)
	//Space Complexity O(N);
	 public static int maxProfitUsingExtraSpace(int[] prices) {
		 //creating auxilary space
		 int len=prices.length;
		 int[] auxilaryArray=new int[len];

		 int previousMax=0;
		 for(int i=prices.length-1;i>=0;i--) {
			 int max=Math.max(previousMax, prices[i]);
			 auxilaryArray[i]=max;
			 previousMax=max;
		 }
		 
		 int maxProfit=0;
		 for(int i=0;i<len;i++) {
			 int profit=auxilaryArray[i]-prices[i];
			 if(profit>maxProfit) {
				 maxProfit=profit;
			 }
					 
					 
		 }
		 return maxProfit;
	 }
	 
	 
	//Time complexity O(N)
	//Space Complexity O(1);
	 public int maxProfitOptimal(int[] prices) {
		 int minSale=prices[0];
			int maxProfit=0;
			
			for(int i=1;i<prices.length;i++) {
				if(prices[i]<minSale){
	                minSale=prices[i];
	            }
	            int profit=prices[i]-minSale;
	            if(profit>maxProfit){
	                maxProfit=profit;
	            }
			} 

	        return maxProfit;
	    
	 }
	 
	 
	//Time complexity O(N²)
	//Space Complexity O(1);
	 public int majorityElementBrutForce(int[] nums) {
	        int count=0;
	        int n=nums[0];
	        int mid=(0+nums.length-1)/2;
	        for(int i=0;i<=mid;i++){
	            count=0;
	            for(int j=0;j<nums.length;j++){
	               if(nums[i]==nums[j]){
	                   count++;
	                   if(count>nums.length/2){
	                       n=nums[i];
	                       return n;
	                   }
	               } 
	            }
	        }

	        return n;
	    }
	 
	 
	//Time complexity O(NLogN)
	//Space Complexity O(1);
	 public int majorityElementOptimal(int[] nums) {
	        Arrays.sort(nums);
	        return nums[(0+nums.length-1)/2];
	    }
	 
	 //=============================================
	 
	 public static void main(String args[]) 
	   { 
	   	int[] arr=new int[] {1,2,4,2,5,7,2,4,9,0,9};
	//   	int[] arr1=new int[] {2,5,6};
			 
			 int b=maxProfitUsingExtraSpace(arr);
	//   	mergeSortedArrayInPlace(arr, 3, arr1, arr1.length);
	//   	System.out.println(Arrays.toString(arr));
	   	System.out.println(b);
	   } 
}
