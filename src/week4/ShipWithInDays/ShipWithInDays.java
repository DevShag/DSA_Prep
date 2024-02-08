package week4.ShipWithInDays;

public class ShipWithInDays {
	
	 public static void main(String args[]) 
	   { 		 
		 int[] arr=new int[] {1,2,3,4,5,6,7,8,9,10};
		 int i=shipWithinDays(arr,5);
	   	System.out.println(i);
	   }
	
	public static int findNumberOfDays(int[] w, int capacity){
        int loads=0;
        int days=1;
        for(int i=0;i<w.length;i++){
            if(loads+w[i]>capacity){
                days++;
                loads=w[i];
            }
            else{
                loads+=w[i];
            }
        }
        return days;
    }

  

    public static int shipWithinDays(int[] weights, int days) {
        int l=weights.length-1;
        int start=Integer.MIN_VALUE;
        int end=0;
        for(int i=0;i<weights.length;i++){
            end+=weights[i];
            start=Math.max(start,weights[i]);
        }
        while(start<=end){
            int mid=(start+end)/2;
            System.out.println("mid : "+mid);
            int shippingDays=findNumberOfDays(weights,mid);
            System.out.println("shippingDays : "+shippingDays);
            
            if(shippingDays<=days){
                end=mid-1;
            }
            else if(shippingDays>days){
                start=mid+1;
            }
           
        }
        return start;
    }
}
