package week4.AllocateBooks;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
	
	 public static void main(String args[]) 
	   { 		 
		 int[] arr=new int[] {12, 34, 67, 90 };
		 ArrayList<Integer> array_list =  new ArrayList<Integer>();
		 array_list.add(12);
		 array_list.add(34);
		 array_list.add(67);
		 array_list.add(90);
		 int i=findPages(array_list,array_list.size(),2);
	   	System.out.println(i);
	   }
	
//	 Time Complexity= O(N)	 
	 public static int findNumberOfStudents(ArrayList<Integer> arr, int n, int maxPage) {
		 int studentCount=1;
         int pageCount=0;
		 
		 for(int i=0;i<arr.size();i++){
             if(pageCount+arr.get(i)>maxPage){
                 studentCount++;
                 pageCount=arr.get(i);
             }
             else{
                 pageCount+=arr.get(i);
             }
         }
         return studentCount;
	 }

//		Time Complexity =O(Max-Min)*O(N)
//		Space Complexity=O(1)
	 public static int findPages(ArrayList<Integer> arr, int n, int m) {
	        if(m>n){
	            return -1;
	        }
	        int min=arr.get(0);
	        int max=0;
	        for(int i=0;i<arr.size();i++) {
	        	min=Math.max(min, arr.get(i));
	        	max+=arr.get(i);
	        }

	        while(min<=max){
	            int mid=(min+max)/2;
	            int studentCount=findNumberOfStudents(arr, n, mid);
	            
	            if(studentCount<=m){
	                max=mid-1;
	            }
	            else{
	                min=mid+1;
	            }
	        }
	        return min;
	    }

}
