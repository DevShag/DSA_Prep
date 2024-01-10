package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Array_Algo {

 public static void moveZeroes(int[] nums) {
		 
		 if(nums.length==0 || nums.length==1) {
			 return;
		 }
		 int i=0;
		 int j=1;
		 
		 while(j<nums.length) {
			 if(nums[i]!=0 && nums[j]==0) {
				 i=j;
				 j++;
			 }
			 else if(nums[i]==0 && nums[j]!=0) {
				 nums[i]=nums[j];
				 nums[j]=0;
				 i++;
				 j++;
			 }
			 else if(nums[i]==0 && nums[j]==0) {
				 j++;
			 }
			 else if(nums[i]!=0 && nums[j]!=0) {
				 i++;
				 j++;
			 }
		 }
		 
		 System.out.println(Arrays.toString(nums));
	 }
 
 	
	 public static int[] twoSumHashMap(int[] nums, int target) {
		 HashMap< Integer , Integer> map=new HashMap();
		 int val[]=new int[2];
		 for(int i=0;i<nums.length;i++) {
			 int n=nums[i];
			 if(map.containsKey(target-n)) {
				 val[0]=i;
				 val[1]=map.get(target-n);
				 break;
			 }
			 
			 map.put(nums[i], i);
		 }
		 System.out.println(Arrays.toString(val));
		 return val;
	  }
	 
	 
	 
	 public static int[] twoSum2Sorting(int[] nums, int target) {
		 int val[]=new int[2];
		 Arrays.sort(nums);
		 int start=0;
		 int end=nums.length-1;
		 
		 while(start<=end) {
			 int sum=nums[start]+nums[end];
			 if(sum==target) {
				 val[0]=nums[start];
				 val[1]=nums[end];
				 break;
			 }
			 else if(sum>target) {
				 end--;
			 }
			 else {
				 start++;
			 }
		 }
		 System.out.println(Arrays.toString(val));
		 return val;
	 }
	 

	 //Optimized
	 public static List<List<Integer>> threeSumHashMap(int[] nums) {
			
		 HashSet<List<Integer>> set=new HashSet<List<Integer>>();
		 HashMap< Integer, Integer>map=new HashMap<Integer, Integer>();

		 for(int i=0;i<nums.length-2;i++) {
			 
			 for(int j=i+1;j<nums.length;j++) {
				 int target=-(nums[i]+nums[j]);
				 if(map.containsValue(target)) {
					 List<Integer> l=new ArrayList<Integer>();
					 l.add(nums[i]);
					 l.add(nums[j]);
					 l.add(target);
					 Collections.sort(l); 
					 set.add(l);
				 }
				 else {
					 map.put(j, nums[j]);
				 }
			 }
			 map.clear();
		 }
		 
		 List<List<Integer>> list=new ArrayList<>(set);
		 
		 for(int i=0;i<list.size();i++) {
			 System.out.println(list.get(i).toString());
		 }
		 return list;
		 
	 }	 
	 

 
	 //Optimal Solution
	 public static List<List<Integer>> threeSumSorting(int[] nums) {
			
		 HashSet<List<Integer>> set=new HashSet<List<Integer>>();
		 
		 Arrays.sort(nums);
		 int target=0;
		 
		 for(int i=0;i<nums.length-2;i++) {
			 int start=i+1;
			 int end=nums.length-1;
			 while(start<end) {
				 int sum=nums[i]+nums[start]+nums[end];
				 if(sum==target) {
					 List<Integer> l=new ArrayList<Integer>();
					 l.add(nums[i]);
					 l.add(nums[start]);
					 l.add(nums[end]);
					 set.add(l);
					 start++;
					 end--;
					 
				 }
				 else if(sum>target) {
					 end--;
				 }
				 else {
					 start++;
				 }
			 }
		 }
		 List<List<Integer>> list=new ArrayList<>(set);
		 
		 return list;
	 }
	 
	 
	 //Brutforce
	 public static void rotateArrayBruteForce(int[] nums, int k) {
	        while(k>0) {
	        	int current=nums[0];
	        	int next=nums[0];
	        	for(int i=0;i<nums.length-1;i++){
		            next=nums[i+1];
		            nums[i+1]=current;
		            current=next;	        				            	        				           
		        }
	        	nums[0]=next;
	        	k--;
	        }
	        System.out.println(Arrays.toString(nums));
	 }
	 
	 
	 //Extra Space
	 public static void rotateArrayExtraSpace(int[] nums, int k) {
		 int l=nums.length;
	        int[] rotate=new int[l];
	        for(int i=0;i<l;i++) {
	        	int index=i+k;
	        	index=index%l;
	        	rotate[index]=nums[i];
	        	
	        }
	        nums=rotate;
	        System.out.println(Arrays.toString(nums));
	    }
	 
	 
	 
	 static void leftRotate(int arr[], int d)
	    {
	 
	        if (d == 0)
	            return;
	 
	        int n = arr.length;
	        // in case the rotating factor is
	        // greater than array length
	        d = d % n;
	        reverseArray(arr, 0, d - 1);
	        reverseArray(arr, d, n - 1);
	        reverseArray(arr, 0, n - 1);
	        
	        System.out.println(Arrays.toString(arr));
	    }
	 
	 
	 //Array rotation without using extra memory
	 static void rightRotate(int arr[], int d)
	    {
	 
	        if (d == 0)
	            return;
	 
	        int n = arr.length;
	        // in case the rotating factor is
	        // greater than array length
	        d = d % n;
	        reverseArray(arr, n-d, n - 1);
	        reverseArray(arr,0, n-1-d);
	        reverseArray(arr, 0, n - 1);
	        
	        System.out.println(Arrays.toString(arr));
	    }
	 
	 
	 static void reverseArray(int arr[], int start, int end)
	    {
	        int temp;
	        while (start < end) {
	            temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
	        }
	    }
	
	 
	 
	 public static int lenOfLongSubarrBrutForce (int A[], int N, int K) {

		 int count=0;
		 int i=0;
		 int j=0;
		 
		 for(i=0;i<N; i++) {
			 int sum=A[i];
			 for(j=i+1;j<N;j++) {
				 sum+=A[j];
				 if(sum==K) {
					 int c=j-i+1;
					 if(c>count) {
						 count=c;
					 }
					 break;
				 }
			 }
			 if(j>=N-1) {
				 return count;
			 }
			// System.out.println("break");
		 }
	  
		 return count;
	 }
	 
	 
	 
	 public static int lenOfLongSubarrHashMap (int A[], int N, int K) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(0, -1);
		
		int maxCount=0;
		int sum=0;
		
		for(int i=0;i<N;i++) {
			sum+=A[i];
			int diff=sum-K;
			if(diff==0) {
				int count=i+1;
				if(count>maxCount) {
					maxCount=count;
				}
			}
			else if(map.containsKey(diff)) {
				int index=map.get(diff);
				int count=i-index;
				if(count>maxCount) {
					maxCount=count;
				}
			}
			map.put(sum, i);
		}
		
		return maxCount;
	 }
	 
	 
	 
	 public static int SubarraySumEqualsKCount(int[] arr, int target) {
		 int ans=0;
		 
		 HashMap<Integer, Integer> map=new HashMap<>();
		 map.put(0, 1);
		 int sum=0;
		 
		 for(int i=0;i<arr.length;i++) {
			 sum+=arr[i];
			 if(map.containsKey(sum-target)) {
				 ans+=map.get(sum-target);				 
			 }
			 map.put(sum, map.getOrDefault(sum, 0)+1);
		 }
		 return ans;
	 }
	    
    
	 
	 
	 
	 
 
}
