package SlidingWindow.FirstNegativeNumberInEveryWindowOfSizeK;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowOfSizeK {

	
	public static void main(String args[]) 
	   { 
	   	    long[] arr=new long[] {12,-1,-7,8, -15, 30, 16, 28};
	   	    long[] a= printFirstNegativeInteger(arr, arr.length,3);
	   	    System.out.println(Arrays.toString(a));
			 
	   } 
	
	public static long[] printFirstNegativeIntegerBrutForce(long A[], int N, int K)
    {
		long[] arr=new long[N-K+1];
        for(int i=0;i<=N-K;i++) {
        	for(int j=0;j<K;j++) {
        		if(A[i+j]<0) {
        			arr[i]=A[i+j];
        			break;
        		}
        	}
        }
        return arr;
    }
	
	//======================Sliding Window Approch=========================
	//============================VVV IMP=============================
	//Time complexity O(N)
		//Space Complexity O(K);
	public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
		Queue<Long> queue=new LinkedList<Long>();
		
		//calculating for the first window;
		int index=0;
		while(index<K) {
			if(A[index]<0) {
				queue.offer(A[index]);
			}
			index++;
		}
		long res[]=new long[N-K+1];
		res[0]=queue.isEmpty()?0:queue.peek();
		
		for(int i=1;i<N-K+1;i++) {
			//remove
			if(A[i-1]<0) {
				queue.poll();
			}
			
			//add
			if(A[i+K-1]<0) {
				queue.offer(A[i+K-1]);
			}
			res[i]=queue.isEmpty()?0:queue.peek();
			
		}
		
		return res;
    }
}
