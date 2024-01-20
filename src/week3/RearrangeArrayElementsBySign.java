package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElementsBySign {
	
	 public static void main(String args[]) 
	   { 
	   	int[] arr1=new int[] {-37,-10,-9,15,14,31};
//	   	System.out.println(Arrays.toString(arr1));
			// rearrangeArrayBrutforce(arr1);
//			 System.out.println(Arrays.toString(arr1));
			 ArrayList<Integer[]> list = new ArrayList<Integer[]>();
			 Integer[] i=new Integer[] {1,3};
			 list.add(i);
			 list.add(i);
			 list.size();
//			 int[][] a= (int[][]) list.toArray();
			 int b=0;
	   } 
	 
	 
	 //===========================================
	 
	 //Time Complexity=O(2N)
	 //Space Complexity=O(N)
	 public static int[] rearrangeArrayBrutforce(int nums[]) {
		 int len=nums.length;
		 int[] arr1=new int[len/2];
		 int[] arr2=new int[len/2];
		 int i=0;
		 int i1=0;
		 int i2=0;
		 for(;i<len;i++) {
			 if(nums[i]>=0) {
				 arr1[i1++]=nums[i];
			 }
			 else {
				 arr2[i2++]=nums[i];
			 }
		 }
		 
		 i=0;
		 i1=0;
		 i2=0;
		 
		 for(;i<len;i++) {
			if(i%2==0) {
				nums[i]=arr1[i1++];
			}
			else {
				nums[i]=arr2[i2++];
			}
		 }
		
		 System.out.println(Arrays.toString(nums));
		 return nums;
	 }
	 
	//Time Complexity=O(N)
	//Space Complexity=O(N)
	 public static int[] rearrangeArrayWithExtraSpace(int nums[]) {
		 int len=nums.length;
		 int[] arr=new int[len];
		 int pos=0;
		 int neg=1;
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		 for(int i=0;i<len;i++) {
			if(nums[i]>0) {
				arr[pos]=nums[i];
				pos+=2;
			}
			else {
				arr[neg]=nums[i];
				neg+=2;
			}
		 }
		
		 System.out.println(Arrays.toString(arr));
		 return arr;
	 }
	
	public static void rotate(int nums[], int start, int end) {
		int temp=nums[end];
		for(int i=end-1;i>=start;i--) {
			nums[i+1]=nums[i];
		}
		nums[start]=temp;
	}
	
	//Time Complexity=O(N²)
	//Space Complexity=O(N)
	//Giving TLE for big data
	public static int[] rearrangeArray(int nums[]) {
		
		int n=nums.length;
		int i=0;
		int j=0;
		int k=0;
		
		while(k<n && i<n && j<n) {
			if(k%2==0) {
				if(nums[k]<0) {
					i=k;
					j=k;
					
					while(i<n && nums[i]<0) {
						i++;
					}
					if(i>=n) {
						break;
					}
					else {
						rotate(nums,j,i);
					}
					
				}
			}
				else {
					if(nums[k]>0) {
						i=k;
						j=k;
						while(j<n && nums[j]>=0) {
							j++;
						}
						if(j>=n) {
							break;
						}
						else {
							rotate(nums,i,j);
						}
					}
				}
				
				k++;
			
			
		}
		
		return nums;
	}
}
