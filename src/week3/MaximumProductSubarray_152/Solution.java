package week3.MaximumProductSubarray_152;

public class Solution {
	
	 public static void main(String args[]) 
	   { 
	   	    int[] arr1=new int[] {2,3,-2,4};
	   	    int a= maxProductBestSolution(arr1);
	   	    System.out.println(a);
			 
	   } 
	 
	//===========================================
	
	//Time Complexity=O(N^2)
	//Space Complexity=O(1)
	 public static int maxProductBrutForce(int[] nums) {
		 
		 int maxProduct=nums[0];
	     int currentProduct=  1;
	     
	     for(int i=0;i<nums.length;i++) {
	    	 currentProduct=nums[i];
	    	 
	    	 for(int j=i+1;j<nums.length;j++) {
	    		 
	    		 currentProduct*=nums[j];
	    		 maxProduct=Math.max(maxProduct, currentProduct);
	    	 }
	     }
	     
	     return maxProduct;
	 }
	 
	 
//	 ===============================Best Approche=====================================
	//Time Complexity=O(N)
   //Space Complexity=O(1)
	 public static int maxProductBestSolution(int[] nums) {
		 if(nums.length==1){
	            return nums[0];
	     }
		 int prefixSum=1;
		 int suffixSum=1;
		 int ans=0;
		 
		 int l=nums.length-1;
		 
		 for(int i=0;i<=l;i++) {
			 prefixSum*=nums[i];
			 suffixSum*=nums[l-i];
			 ans=Math.max(ans, Math.max(prefixSum, suffixSum));
			 if(prefixSum==0) {
				 prefixSum=1;
			 }
			 
			 if(suffixSum==0) {
				 suffixSum=1;
			 }
		 }
		 return ans;
	 }
		 
		 
		 
	 
	 
	 //====================================Not Intitutive Solution Dont Use it============================
	
	/*
	 * The Approach to this question is exactly same as Kadane's Algo the only differece is,
	 *  we will be traversing the array from both sides i.e left to right ( lets say the max prod
	 *  is maxi1 ) and from right to left ( say max prod is maxi2 ), now the final answer will we
	 *   max of maxi1 and maxi2.
	 */
	
	 //Time Complexity=O(N)
	 //Space Complexity=O(1)
	public static int maxProduct(int[] nums) {
        int maxProduct=nums[0];
        int currentProduct=  1;

        for(int i=0;i<nums.length;i++){
            currentProduct*=nums[i];
            maxProduct=Math.max(currentProduct,maxProduct);
            if(currentProduct==0){
                currentProduct=1;
            }
        }  

        currentProduct=  1;
        for(int i=nums.length-1;i>=0;i--){
            currentProduct*=nums[i];
            maxProduct=Math.max(currentProduct,maxProduct);
            if(currentProduct==0){
                currentProduct=1;
            }
        }                  
        return maxProduct;
    }
}
