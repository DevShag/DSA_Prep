package Leet_Easy;

import java.util.Arrays;

public class EasyByLeet {
	
    public static int removeDuplicates(int[] nums) {
        
        int i=0;
        int j=i+1;
        int count=1;
        int len=nums.length;
        while(j<len){
            if(nums[j]!=nums[i]){
            	nums[i+1]=nums[j];
                i++;
                count++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("count : "+count);
        return count;
    }
    
    
  
    
    public static int removeElement(int[] nums, int val) {
    	int index=0;
    	
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]!=val) {
    			nums[index]=nums[i];
    			index++;
    		}
    	}
    	if(index==0) {
    		nums=null;
    	}
    	System.out.println(Arrays.toString(nums));
    	System.out.println("index : "+index);
    	return index;
    			
    }
    
    public static int strStr(String haystack, String needle) {
//    	haystack = "butsad", needle = "sad"
//    	haystack = "leetcode", needle = "leeto"
    	int len1=haystack.length();
    	int len2=needle.length();
    	if(len1<len2) {
    		return -1;
    	}
        int i=0;int j=0;
        int index=-1;
        while(i<haystack.length()) {
        	
        	if(haystack.charAt(i)==needle.charAt(j)) {
        		if(index==-1) {
        			
        			index=i;
        		}
        		int k=i+1;
        		j++;
        		while(j<needle.length()) {
        			if(haystack.charAt(k)!=needle.charAt(j)) {
        				break;
        			}
        			k++;
        			j++;
        		}
        		if(j>=needle.length()) {
        			
        			return index;
        		}
        		
        	}
        	else if(index!=-1){
        		index=-1;
        		j=0;
        	}
        	else if(index==-1 && len1-i<len2) {
        		return -1;
        	}
        	i++;
        	
        }
    	
    	return -1;
    }
    
    public static int findClosest(int[] arr, int x){
        int start=0;
       int end=arr.length-1;
       
       while(start<=end){
           int mid=(start+end)/2;
           
           if(arr[mid]==x){
               return mid;
           }
           
           else if(arr[mid]<x){
               start=mid=1;
           }
           else{
               end=mid-1;
           }
       }
       
       return start;
    }
    
    public static int[] findClosestElements(int[] arr, int k, int x) {
       int index=findClosest(arr,x);
       System.out.println("index : "+index);
       int[] a=new int[k];
       a[0]=arr[index];
       int i=1;
       int count=1;
       while(count<k){
           System.out.println("count : "+count);
           if(index-i>=0){
               a[count]=arr[index-i];
               count++;
           }
           
           if(index+i<arr.length && count <k){
               a[count]=arr[index+i];
               count++;
           }
           i++;
       }
       
       Arrays.sort(a);
       return a;
    }
    
    public static void main(String args[]) 
    { 
    	int[] n=new int[] {1, 2, 3, 4, 5};
    	findClosestElements(n, 4,3);
//    	Sy?stem.out.println("index : "+i);
    } 

}
