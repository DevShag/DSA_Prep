package week4.FindMinimumInRotatedSortedArray;

public class Solution {

	 public int FindMin(int[] nums) {
	        int start=0;
	        int end=nums.length-1;

	        while(start<end){
	            int mid=(end+start)/2;

	            if(nums[0]<=nums[mid] && nums[mid]>=nums[end]){
	                start=mid+1;
	            
	            }
	            else{
	                end=mid;
	            }
	        }
	        return nums[start];
	    }
}
