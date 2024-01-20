package week3.MergeInterval_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> list=new ArrayList<>();
        int mergeCount=0;
        int[] previousInterval=intervals[0];
        for(int[] currentInterval:intervals){
          
            if(previousInterval[1]>=currentInterval[0]){
                
                if(previousInterval[1]>currentInterval[1]){
                    
                }
                else{
                    previousInterval[1]=currentInterval[1];
                }
                
            }
            else{
                list.add(previousInterval);
                previousInterval=currentInterval;
            }
        }
      list.add(previousInterval);
        return list.toArray(new int[list.size()][]);
    }
}
