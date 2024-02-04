package week4.FindPeakElement;

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
        int l=nums.length;
        if(l==1){
            return 0;
        }
        if(l==2){
            return (nums[0]>nums[1]?0:1);
        }
        
        int start=1;
        int end=l-2;
        int mid=0;
        while(start<=end){
            mid=(end+start)/2;
            System.out.println("start : "+start);
            System.out.println("end : "+end);
                System.out.println("mid : "+mid);
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
System.out.println("========================");
        System.out.println("start : "+start);
            System.out.println("end : "+end);
            if(nums[0]>nums[mid]){
                return 0;
            }
            if(nums[l-1]>nums[mid]){
                return l-1;
            }
        return mid;
    }
}
