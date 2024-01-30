package week4.SearchInSortedRotatedArray2;

public class SearchInSortedRotatedArray2 {
	  
    public static void main(String args[]) 
    { 
    	int[] arr=new int[] {1,0,1,1,1};
    	boolean b=SearchBrutForce(arr, 3);
    	System.out.println(b);

    }
	 
  //===========================================
  	 //Time Complexity=O(N)
  	 //Space Complexity=O(1)
    public static boolean SearchBrutForce(int[] nums, int target) {
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==target) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
  //===========================================
  	 //Time Complexity=O(logN)
  	 //Space Complexity=O(1)
    public static boolean Search(int[] nums, int target) {
    	int n=nums.length;
    	int low=0;
    	int high=n-1;
    	
    	while(low<=high) {
    		
    		int mid=(low+high)/2;
    		
    		if(nums[mid]==target) {
    			return true;
    		}
    		
    		//Edge case
    		if(nums[low]==nums[mid] && nums[mid]==nums[high]) {
    			low=low+1;
    			high=high-1;
    			continue;
    		}
    		
    		//if left part is sorted
    		if(nums[low]<=nums[mid]) {
    			if(nums[low]<=target && target<=nums[mid]) {
    				high=mid-1;
    			}
    			else {
    				low=mid+1;
    			}
    		}
    		else {
    			if(nums[mid]<=target && target<=nums[high]) {
    				low=mid+1;
    			}
    			else {
    				high=mid-1;
    			}
    		}
    	}
    	return false;
    }
}
