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
	 //Week 3 question 5
//	 https://www.geeksforgeeks.org/problems/minimum-sum4058/1
	//Time complexity O(NLogN)
	//Space Complexity O(N)
	 static String minimumSum(int[] arr, int n) {
		 	Arrays.sort(arr);         
	        List<Integer> l1=new ArrayList<Integer>();
	        List<Integer> l2=new ArrayList<Integer>();
	       for(int i=0;i<arr.length;i++){
	            if(i%2==0){
	                l1.add(arr[i]);
	                // System.out.println("n1 : "+n1);
	            }
	            else{
	                l2.add(arr[i]);
	            }
	        }
	        
	        int i=l1.size()-1;
	        int j=l2.size()-1;
	        Stack<Integer> stack=new Stack<Integer>();
	        int carry=0;
	        while(i>=0 && j>=0){
	            int product=l1.get(i--)+l2.get(j--)+carry;
	            int result=product%10;
	             carry=product/10;
	            stack.push(result);
	        }
	        
	        while(i>=0){
	            int product=l1.get(i--)+carry;
	            int result=product%10;
	             carry=product/10;
	            stack.push(result);
	        }
	        
	         while(j>0){
	            int product=l2.get(j--)+carry;
	            int result=product%10;
	             carry=product/10;
	            stack.push(result);
	        }
	        
	        if(carry>0){
	            stack.push(carry);
	        }
	        
	        
	        
	        String s="";
	        boolean isZero=true;
	        while(!stack.isEmpty()){
	            int a=stack.pop();
	            if(a==0 && isZero){
	                continue;
	            }
	            else{
	                isZero=false;
	                s+=a;
	            }
	            // /+=stack.pop();
	        }
	        
	        if(s==""){
	            return "0";
	        }
	        return s;

	    }
	 
//================================================================	 
	 
	 //https://leetcode.com/problems/sort-colors/
	
	 	//Time complexity O(N)
		//Space Complexity O(1);
	    public void sortColorsUsingDutchFlagAlgo(int[] nums) {
	        int start=0;
	        int mid=0;
	        int end=nums.length-1;

	        while(mid<=end){
	            if(nums[mid]==0){
	                swap(nums,start,mid);
	                start++;
	                mid++;

	            }         
	            else if(nums[mid]==1){
	                mid++;

	            }   
	            else{
	                swap(nums,mid,end);
	                end--;
	            }                               
	        }
	    }
	    
	    void swap(int[] nums, int i, int j){
	        // System.out.println("i : "+i+" , j : "+j);
	        int temp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=temp;
	    }

//=================================================================================	    
	 
	 //https://leetcode.com/problems/maximum-subarray/
	    public int maxSubArrayBrutForce(int[] nums) {
	        int currentSum=0;
	        int maxSum=nums[0];
	        for(int i=0;i<nums.length;i++){
	            currentSum=nums[i];
	            if(currentSum>maxSum){
	                    maxSum=currentSum;
	                }
	            for(int j=i+1;j<nums.length;j++){
	                currentSum+=nums[j];
	                if(currentSum>maxSum){
	                    maxSum=currentSum;
	                }
	            }
	        }

	        return maxSum;
	    }

	 
	//Time complexity O(N)
	//Space Complexity O(1);
	 public int maxSubArrayUsingKadanesAlgo(int[] nums) {
	        int currentSum=0;
	        int maxSum=nums[0];

	        for(int i=0;i<nums.length;i++){
	            currentSum+=nums[i];
	            if(currentSum>maxSum){
	                maxSum=currentSum;
	            }

	            if(currentSum<0){
	                currentSum=0;
	            }
	        }
	        return maxSum;
	    }
	 
	 
//	 ==================================================
	 
	 public static void Swap(int[] nums, int i, int j){
	        int temp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=temp;

	    }

	    public static void Reverse(int[] nums, int start, int end){
	        
	        while(start<end){
	            Swap(nums,start++,end--);
	        }
	    }

	    //
	    //Time complexity: O(n)
	    //Space complexity: O(1)
	    public static void nextPermutation(int[] nums) {
	    	int i=nums.length-2;

	        while(i>=0 && nums[i]>=nums[i+1]){
	            i--;
	        }

	        int j=nums.length-1;

	        if(i>=0)
	        {
	            while(nums[j]<=nums[i]){
	                j--;
	            }
	            Swap(nums,i,j);
	        }
	        Reverse(nums, i+1, nums.length-1);
	    }
	    
	    public static int[] rearrangeArray(int[] nums) {
	        boolean isPositive=nums[0]>0?true:false;
	        int index=1;

	        for(int i=1; i<nums.length;i++){
	             boolean b=nums[i]>0?true:false;
	            //  System.out.println("isPositive : "+isPositive);
	                // System.out.println("i : "+nums[i]+" , b : "+b+" index : "+index);
	                //  System.out.println("index : "+index);
	             if(b!=isPositive){
	                 if(i!=index){
	                     Swap(nums, index, i);
	                 }
	                 index++;
	                 isPositive=b;
	             }
//	            System.out.println(Arrays.toString(nums));
	        }

	        System.out.println(Arrays.toString(nums));
	        return nums;
	    }
	 
	 public static void main(String args[]) 
	   { 
//	   	int[] arr=new int[] {1, 1, 5, 2, 7, 6, 1, 4, 2, 3, 2, 2, 1, 6, 8, 5, 7, 6, 1, 8, 9, 2, 7, 9, 5, 4, 3, 1};
	   	int[] arr1=new int[] {3,1,-2,-5,2,-4};
			 
			 rearrangeArray(arr1);
			 System.out.println(Arrays.toString(arr1));
	//   	mergeSortedArrayInPlace(arr, 3, arr1, arr1.length);
	//   	System.out.println(Arrays.toString(arr));
//	   	System.out.println(b);
	   } 
}
