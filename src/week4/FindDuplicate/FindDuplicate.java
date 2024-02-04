package week4.FindDuplicate;

//https://www.youtube.com/watch?v=49HrEGt6D2s&t=899s
public class FindDuplicate {

	 public static void main(String args[]) 
	   { 		 
		 int[] arr=new int[] {1,3,4,2,2};
//		 int[] arr=new int[] {4,2,1,2,3};
		 int i=FindDuplicate(arr);
	   	System.out.println(i);
	   }
	 
	 
//	The time complexity of this algorithm is Linear: O(N)
//	 The space complexity is constant: O(1)

	 public static int FindDuplicate(int[] nums) {
	        int slow=nums[0];
	        int fast=nums[0];


	       do{
	            slow=nums[slow];
	            fast=nums[nums[fast]];
	        } while(slow!=fast);
	       
	        slow=nums[0];
	        while(slow!=fast){
	            slow=nums[slow];
	            fast=nums[fast];
	        }
	        return slow;
	 }
	 
	
}
