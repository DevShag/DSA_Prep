package SlidingWindow.MaxOfSubArrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;


public class MaxOfSubarrays {

	public static void main(String args[]) 
	   { 
	   	    int[] arr=new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6};
	   	    ArrayList <Integer> a= max_of_subarraysDeque(arr, arr.length,3);
//	   	    System.out.println(Arrays.toString(a));
			 
	   } 
	
	
	//Time complexity O(N*K)
	//Space Complexity O(1);
	static ArrayList <Integer> max_of_subarraysBrutForce(int arr[], int n, int k)
    {
		ArrayList<Integer> l=new ArrayList<Integer>();
		int limit=arr.length-k+1;
        for(int i=0;i<limit;i++) {
        	int max=arr[i];
        	for(int j=1;j<k;j++) {
        		max=Math.max(max, arr[i+j]);
        	}
        	l.add(max);
        }
        
        for(int i=0;i<l.size();i++) {
    		System.out.println(l.get(i));
    	}
        
        return l;
    }
	
	
//	====================================USING PRIORITY QUEUE==============================
		//https://www.youtube.com/watch?v=MCvGwtkqJS0&t=308s
		//Time complexity O(Nlog(k))
		//Space Complexity O(k);
		static ArrayList <Integer> max_of_subarraysPQ(int arr[], int n, int k)
	    {
			//creating the max heap to get max element always
			PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
			
			ArrayList<Integer> res=new ArrayList<Integer>();
			int i=0;
			
			for(;i<k;i++) {
				queue.add(arr[i]);
			}
			
			//adding the first element of the array
			res.add(queue.peek());
			
			//removing the first element of the array
			queue.remove(arr[0]);
			
			for(;i<n;i++) {
				queue.add(arr[i]);
				res.add(queue.peek());
				queue.remove(arr[i-k+1]);
			}
			for( i=0; i<res.size();i++) {
	    		System.out.println(res.get(i));
	    	}
	        
			return res;
			
	    }

		
//		====================================BEST SOLUTION=========================
//		====================================USING Doubbly LinkedList==============================
			//https://www.youtube.com/watch?v=MCvGwtkqJS0&t=308s
			//Time complexity O(N)
			//Space Complexity O(k);
			static ArrayList <Integer> max_of_subarraysDeque(int arr[], int n, int k)
		    {
				Deque<Integer> deque=new ArrayDeque<Integer>();
				ArrayList<Integer> res=new ArrayList<Integer>();
				
//				Process first K or first window element of array
				int i=0;
				for(i=0;i<k;i++) {
					//For every element the previous
					//smaller element is useless so 
					//remove them from Qi
					while(!deque.isEmpty()) {
						int lastElement=deque.peekLast();
						if(arr[i]>=arr[lastElement]) {
							deque.removeLast();
						}
						else {
							break;
						}
					}
					deque.addLast(i);
				}
				
				//Process rest of the elements,
				//i.e, from arr[k] to arr[n-1]
				for(; i<n;i++) {
					//the element at the front of the
					//queuq is the largest element of 
					//previous window so add it in result arrayList
					res.add(arr[deque.peek()]);
					
//					Remove the element which
//					are out of the window
					while(!deque.isEmpty()) {
						int index=deque.peek();
						if(index<=i-k) {
							
							deque.removeFirst();
						}
						else {
							break;
						}
					}
					
//					Remove all elements smaller
//					than the currently
//					being added element (remove
//					useless elements)
					while(!deque.isEmpty()) {
						int lastElement=deque.peekLast();
						if(arr[i]>=arr[lastElement]) {
							deque.removeLast();
						}
						else {
							break;
						}
					}
					
					deque.addLast(i);
				}
				res.add(arr[deque.peek()]);
				for( i=0; i<res.size();i++) {
		    		System.out.println(res.get(i));
		    	}
				return res;
					
		    }
		
	
}
