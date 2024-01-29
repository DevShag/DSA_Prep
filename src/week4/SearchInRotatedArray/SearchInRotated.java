package week4.SearchInRotatedArray;

public class SearchInRotated {

	int peakIndex(int[] nums){
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid=(end-start)/2+start;

            if(nums[mid]>=nums[0]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        int ans=-1;

        while(start<=end){
            int mid=(end-start)/2+start;

            if(nums[mid]==target){
                ans=mid;
                break;
            }

            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }

    public int search(int[] nums, int target) {
        int peak=peakIndex(nums);
        System.out.println("peak : "+peak);

        if(nums[peak]<=target && target<=nums[nums.length-1]){
            // System.out.println("2");
            return binarySearch(nums, peak, nums.length-1, target);
        }
        else{
            // System.out.println("1");
            return binarySearch(nums, 0, peak-1, target);
        }
    }
}
