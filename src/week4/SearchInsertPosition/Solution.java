package week4.SearchInsertPosition;

public class Solution {

//===========================================================================
//	https://leetcode.com/problems/search-insert-position/description/
//	Time complexity O(log N)
//	Auxiliary space O(1)
	public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans;
        int mid=0;
        while(start<=end){
            mid=(end-start)/2+start;
            // System.out.println("mid : "+mid);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
               
                end=mid-1;
            }
        }
        
        return start;
    }
}
