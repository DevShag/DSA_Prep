package week4.AggressiveCows;

import java.util.Arrays;

public class AggressiveCows {
	

	 public static void main(String args[]) 
	   { 		 
		 int[] arr=new int[] {87, 93, 51, 81, 68, 99, 59 };
		 int i=aggressiveCowsBinarySearch(arr,4);
	   	System.out.println(i);
	   }
	

//	==========================Brut Force===========================
//	 Time Complexity= O(N)
	static boolean CanWePlace(int[] stalls, int dist, int cows) {
		int cowCount=1;
		int lastPos=stalls[0];
		for(int i=1; i< stalls.length; i++) {
			int d=stalls[i]-lastPos;
			if(stalls[i]-lastPos>=dist) {
				cowCount++;
				lastPos=stalls[i];
				if(cowCount>=cows) {
					return true;
				}
			}
		}
		return false;
	}
	
//	Time Complexity =O(Max-Min)*O(N)
//	Space Complexity=O(1)
	public static int aggressiveCowsBrutForce(int []stalls, int k) {
		Arrays.sort(stalls);
		int l=stalls.length;
		int min=stalls[0];
		int max=stalls[l-1];
		int maxDist=1;
		for(int i=1;i<=(max-min);i++) {
			if(CanWePlace(stalls, i, k)) {
				maxDist=i;
			}
			else {
				break;
			}
		}
		
		return maxDist;
    }
	
	public static int aggressiveCowsBinarySearch(int []stalls, int cows) {
		Arrays.sort(stalls);
		int l=stalls.length;
		int min=0;
		int max=stalls[l-1]-stalls[0];
		int maxDist=1;
		while(min<=max) {
			int mid=(min+max)/2;
			if(CanWePlace(stalls, mid, cows)) {
				maxDist=mid;
				min=mid+1;
			}
			else {
				max=mid-1;
			}
					
		}
		return maxDist;
	}
}
