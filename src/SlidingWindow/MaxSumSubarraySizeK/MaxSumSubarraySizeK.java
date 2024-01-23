package SlidingWindow.MaxSumSubarraySizeK;

import java.util.ArrayList;

public class MaxSumSubarraySizeK {

	static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long maxSum=0;
        
        for(int i=0;i<K;i++){
            maxSum+=Arr.get(i);
        }
        
        long windowSum=maxSum;
        for(int i=K;i<N;i++){
            windowSum=windowSum+Arr.get(i)-Arr.get(i-K);
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
