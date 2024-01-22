package week3.LongestConsecutiveSequence_128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	
	 public static void main(String args[]) 
	   { 
	   	    int[] arr1=new int[] {0,0};
	   	    int a= longestConsecutive(arr1);
	   	    System.out.println(a);
			 
	   } 
	 
	//===========================================
	 //Time Complexity=O(NlogN)
	 //Space Complexity=O(1)
	 public static int longestConsecutiveUsingSorting(int[] nums) {
		 
		 Arrays.sort(nums);
		 int maxLength=0;
		 
		 for(int i=0;i<nums.length-1;i++) {
			 int currentLength=1;
			 if((nums[i]-nums[i+1])==1){
				 currentLength++;
			 }
			 else {
				 maxLength=Math.max(maxLength, currentLength);
				 currentLength=1;
			 }
		 }
		 return maxLength;
		 
	 }
	 
	 
		 //Time Complexity=O(N)
		 //Space Complexity=O(N)
	public static int longestConsecutive(int[] nums) {
        int longestLength=0;
        Map<Integer,Boolean> map=new HashMap<>();
        for(int num : nums){
            map.put(num,false);
        }

        for(int num: nums){
            int currentLength= 1;
           
           int nextNum=num+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                currentLength++;
                map.put(nextNum,true);

                nextNum++;
            }

           //Check in reverse direction
            int preNum=num-1;
            while(map.containsKey(preNum) && map.get(preNum)==false){
                currentLength++;
                map.put(preNum,true);
                preNum--;
            }

            longestLength=Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
}
