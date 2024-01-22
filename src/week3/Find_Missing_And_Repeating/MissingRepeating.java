package week3.Find_Missing_And_Repeating;

import java.util.Arrays;

public class MissingRepeating {

	
	public static void main(String args[]) 
	{ 
		    int[] arr=new int[] {1, 3, 3};
		    findTwoElementUsingExtrapace(arr, arr.length);
			 
	}
	
	
	//====================BRUT FORCE========================
		//Time Complexity=O(N²)
		//Space Complexity=O(1)
	static int[] BrutForce(int[] arr, int n) {
		
		int repeating=-1;
		int arraySum=0;
		
		for(int i=0;i<n;i++) {
//			arraySum+=arr[i];
			for(int j=i+1;j<n;j++) {
				if(arr[i]==arr[j]) {
					repeating=arr[i];
					break;
				}
			}
		}
		
		int indexSum=0;
		for(int i=0;i<n;i++) {
			arraySum+=arr[i];
			indexSum+=(i+1);
		}
		
		int missing=indexSum+repeating-arraySum;
		
		int[] elements=new int[2];
		elements[0]=repeating;
        elements[1]=missing;
        System.out.println(Arrays.toString(elements));
        return elements;
		
	}
	
	
	//====================OPTIMIZED USING EXTRA SPACE========================
		//Time Complexity=O(2N)
		//Space Complexity=O(N)
	static int[] findTwoElementUsingExtrapace(int arr[], int n) {
		int[] nums=new int[n+1];
		nums[0]=-1;
		
		for(int i=0;i<n;i++) {
			nums[arr[i]]+=1;
		}
		
		int repeating=-1;
		int missing=-1;
		for(int i=1;i<n+1;i++) {
			if(nums[i]>1) {
				repeating=i;
			}
			
			if(nums[i]==0) {
				missing=i;
			}
		}
		
		int[] elements=new int[2];
		elements[0]=repeating;
        elements[1]=missing;
        System.out.println(Arrays.toString(elements));
        return elements;
		
		
	}
	
	
	//====================SPACE OPTIMIZED========================
	//Time Complexity=O(2N)
	//Space Complexity=O(1)
	int repeatElement(int arr[], int n){
        int ans=-1;
        for(int i=0;i<n;i++){
            int a=Math.abs(arr[i]);
            if(arr[a-1]<0){
                ans=a;
               // break;
            }
            else{
                arr[a-1]=-arr[a-1];
            }
        }
        return ans;
    }
    
    int missingElement(int arr[], int n){
        int missingElement=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                missingElement=i+1;
                break;
            }
           
        }
       return missingElement;
    }
    
    
    int[] findTwoElement(int arr[], int n) {
        
        int repeat=repeatElement(arr,n);
        int missing=missingElement(arr,n);
        int[] elements=new int[2];
        elements[0]=repeat;
        elements[1]=missing;
        return elements;
    }
}
