package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;



public class Recursion {

	 
    int getMax(int arr[], int max, int i, int n){
        if(i>=n){
            return max;
        }
        if(arr[i]>max){
            max=arr[i];
        }
        i++;
        max=getMax(arr,max,i,n);
        return max;
    }
    
    public int largest(int arr[], int n)
    {
        return getMax(arr,Integer.MIN_VALUE, 0, n);
    }
    
    
   static int print2largest(int arr[], int n) {
        if(n==1){
            return -1;
        }
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
        	int num=arr[i];
        	if(max1<arr[i]) {
        		max2=max1;
        		max1=arr[i];
        	}
        	else if(arr[i]!=max1 && max2<arr[i]) {
        		max2=arr[i];
        	}
        }
        if(max2==Integer.MIN_VALUE){
            return -1;
        }
        // System.out.println("max1: "+max1+" , max2: "+max2);
        return max2;
    }
   
   public static int secondLargeRecurcion(int arr[], int max1,int max2,int i,int n) {
	   
	   if(i>=n) {
		   return max2;
	   }
	   
	   if(max1<arr[i]) {
   			max2=max1;
   			max1=arr[i];
   		}
   	   else if(arr[i]!=max1 && max2<arr[i]) {
   		   max2=arr[i];
   	   }
	   i++;
	   max2=secondLargeRecurcion(arr, max1, max2, i, n);
	   return max2;
   }
   
   public static int PrintSecondLarge(int arr[],int n) {
	   
	   if(n==1){
           return -1;
       }
       int max1=Integer.MIN_VALUE;
       int max2=Integer.MIN_VALUE;
       max2=secondLargeRecurcion(arr,max1,max2,0,n);
       if(max2==Integer.MIN_VALUE){
           return -1;
       }
       return max2;
   }
   
   public static int removeDuplicatesRecursion(int[] nums, int i, int j) {
	   
	  if(j>=nums.length) {
		return i+1;  
	  }
	  if(nums[i]!=nums[j]) {
		   nums[i+1]=nums[j];
		   i++;
	   }
	  j++;
	  return removeDuplicatesRecursion(nums,i,j);
	   
   }
   
   public static int removeDuplicates(int[] nums) {
	   
	   return removeDuplicatesRecursion(nums,0,1);
   }
   
   
   public static int[] runningSumRecursion(int[] nums, int[] arr, int i)
   {
	   if(i>=nums.length) {
		   return arr;
	   }
	   int j=0;
	   while(j<=i) {
		   arr[i]+=nums[j];
		   j++;
	   }
	   i++;
	   runningSumRecursion(nums, arr, i);
	   return arr;
   }
   
   public static int[] runningSum(int[] nums)
   {
	   int[] arr=new int[nums.length];
	   return runningSumRecursion(nums, arr, 0);
	   
   }
   
   public static int singleNumber(int[] nums) {
	   
	   int ans=nums[0];
	   for(int i=1;i<nums.length;i++) {
		   ans=ans^nums[i];
	   }
	   return ans;
   }
   
 public static int singleNumberRecursion(int[] nums , int i, int ans) {
	   
	 if(i>=nums.length) {
		 return ans;
	 }	  
	 ans=ans^nums[i];
	 i++;
	 return singleNumberRecursion(nums, i, ans);
   }
 
	 
	 public static int findMaxConsecutiveOnes(int[] nums,int i,int maxCount,int count) 
	 {
		 
		 if(i>=nums.length) {
			 if(count>maxCount) {
				 maxCount=count;
			 }
			 return maxCount;
		 }
		 
		 if(nums[i]==1) {
			 count++;
		 }
		 else {
			 if(count>maxCount) {
				 maxCount=count;
			 }
			 count=0;
		 }
		 i++;
		 return findMaxConsecutiveOnes(nums, i, maxCount, count);
	 }
	 
	 
	 public static int missingNumber(int[] nums,int i, int ans) 
	 {
		 if(i>=nums.length) {
			 ans=ans^nums.length;
			 return ans;
		 }
		 
		 ans=ans^nums[i]^i;
		 i++;
		 return missingNumber(nums, i, ans);
		 
	 }
	 
 
	 
 
	 public static ArrayList<Long> nthRowOfPascalTriangle(int n) {
		
		 ArrayList<Long > l=new ArrayList<>();
		 
		 long[][] arr=new long[n][n];
		 
		 for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					arr[i][j]=1;
					
				}
				else {
					long sum=(arr[i-1][j-1]%1000000007+arr[i-1][j]%1000000007)%1000000007;
					arr[i][j]=sum;
					
				}
				
				if(i==n-1){
				    l.add(arr[i][j]);
				}
					
			}
		 }
		 

		 return l;

	 }
	 
	 public static int Factorial(int n) {
		 if(n==0) {
			 return 1;
		 }
		 int ans=n*Factorial(--n);
		 System.out.println(ans);
		 return ans;
	 }
	 
	
	
    static Vector<Long> FibonaciSeriesWithVector(int N) {
        
    	Vector<Long> res=new Vector<Long>();
        
        if(N==1){
            res.add((long) 0);
            res.add((long) 1);
            return res;
        }
        else{
            res = FibonaciSeriesWithVector(N-1);
        }
        
        res.add(res.get(N-1)+res.get(N-2));
        
        return res;
    }
	 
	 
	 
    static long[] FibonaciSeriesWithArray(int N) {
    	
    	long[] arr=new long[N+1];
    	
    	if(N==1) {
    		arr[0]=0;
    		arr[1]=1;
    		return arr;
    	}
    	else {
//    		System.out.println("N : "+N);
    		long[] copyarr=FibonaciSeriesWithArray(N-1);
    		for(int i=0;i<copyarr.length;i++) {
    			arr[i]=copyarr[i];
    		}
    		
    	}
    	arr[N]=arr[N-1]+arr[N-2];
		return arr;
    	
    }
    
    
    //Count Ways To Reach The N-th Stairs
    // https://bit.ly/32VA96H
    public static int countDistinctWayToClimbStair(long nStairs) {
		if(nStairs<0) {
			return 0;
		}
		if(nStairs==0) {
			return 1;
		}
		int ans=countDistinctWayToClimbStair(nStairs-1)+countDistinctWayToClimbStair(nStairs-2);
		return ans;
	}
    
    
    static boolean isSorted(int[] arr, int i) {
    	if(arr.length==0||arr.length==1) {
    		return true;
    	}
    	
    	if(i==arr.length-1) {
    		return true;
    	}
    	if(arr[i]<arr[i+1]) {
    		return isSorted(arr, i+1);
    	}
    	else {
    		return false;
    	}
    }
    
    static boolean LinearSearch(int[] arr, int key, int i) {
    	
    	if(i>=arr.length) {
    		return false;
    	}
    	if(arr[i]==key) {
    		return true;
    	}
    	return LinearSearch(arr, key, i+1);
    }
    
	static boolean BinarySearch(int[] arr, int key, int start, int end) {
	    	
	    	if(start>end) {
	    		return false;
	    	}
	    	int mid=(start+end)/2;
	    	if(arr[mid]==key) {
	    		return true;
	    	}
	    	else if(arr[mid]>key) {
	    		end--;
	    	}
	    	else {
	    		start++;
	    	}
	    	return BinarySearch(arr, key, start, end);
	 }
	
	static void insert(int arr[],int i)
	  {
	       // Your code here
	  }
	  //Function to sort the array using insertion sort algorithm.
	  public static void insertionSort(int arr[], int n)
	  {
	      for(int i=1;i<n;i++) {
	    	  int temp=arr[i];
	    	  for(int j=i-1;j>=0;j--) {
	    		  if(arr[j]>temp) {
	    			  arr[j+1]=arr[j];
	    			  arr[j]=temp;
	    		
	    		  }
	    		  else {
					break;
				}
	    	  }
	      }
	      
	      System.out.println(Arrays.toString(arr));
	  }
	  
	  public static void Insert(int arr[], int i) {
		  int temp=arr[i];
    	  for(int j=i-1;j>=0;j--) {
    		  if(arr[j]>temp) {
    			  arr[j+1]=arr[j];
    			  arr[j]=temp;
    		
    		  }
    		  else {
				break;
			}
    	  }
	  }
	  
	public static void InsertionSortRecursion(int arr[], int n) {
		
		if(n<=1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
			
		InsertionSortRecursion(arr, n-1);
//		int temp=arr[n]
//		Insert(arr, i);
  	  	
	}
	
	 static void insertionSortRecursive(int arr[], int n) 
	    { 
	        // Base case 
	        if (n <= 1) 
	            return; 
	       
	        insertionSortRecursive( arr, n-1 );  
	        int last = arr[n-1]; 
	        int j = n-2; 
	       
	        while (j >= 0 && arr[j] > last) 
	        { 
	            arr[j+1] = arr[j]; 
	            j--; 
	        } 
	        arr[j+1] = last; 
	    } 
	
	  public static void BubbleSortRecursion(int[] arr,int n) {
		  if(n==1) {
			  System.out.println(Arrays.toString(arr));
			  return;
		  }
		  
		  
		  for(int j=0;j<n-1;j++) {
			  if(arr[j]>arr[j+1]) {
				  int temp=arr[j+1];
				  arr[j+1]=arr[j];
				  arr[j]=temp;
			  }
		  }
		 BubbleSortRecursion(arr, n-1);
	  }
    
	  
	//Sum Of Two Arrays
	  //https://bit.ly/3DXfsDZ 
	  public static int[] findArraySum(int[] a, int n, int[] b, int m) {
			int i=n-1;
			int j=m-1;
//			Vector<Integer> sum=new Vector<Integer>();
			Stack<Integer> sum=new Stack<Integer>();
			int product=0;
			int carry=0;
			int result=0;
			
			while(i>=0 && j>=0) {
				product=a[i]+b[j]+carry;
				result=product%10;
				carry=product/10;
//				sum.add(result);
				sum.push(result);
				i--;
				j--;
			}
			
			int[] lagerArray;
			int index=0;
			if(j<0) {
				lagerArray=a;
				index=i;
			}
			else {
				lagerArray=b;
				index=j;
			}
			
			while(index>=0) {
				product=lagerArray[index]+carry;
				result=product%10;
				carry=product/10;
//				sum.add(result);
				sum.push(result);
				index--;
			}
			
			if(carry>0) {
				sum.push(carry);
			}
			
			int [] arr=new int[sum.size()];
			int q=0;
//			for(int k=sum.size()-1;k>=0;k--) {
//				arr[q]=sum.get(k);
//				q++;
//			
			while(!sum.empty()) {
				arr[q]=sum.pop();
				q++;
			}
			System.out.println(Arrays.toString(arr));
			return arr;
			
	  }
	  
	  static void merge(int[] arr, int start, int mid, int end) {
		  int len1=mid-start+1;
		  int len2=end-mid;
		  
		  int[] arr1=new int[len1];
		  int[] arr2=new int[len2];
		  
		  int i=0;
		  int j=0;
		  int k=start;
		  for(;i<len1;i++) {
			  arr1[i]=arr[k++];
		  }
		  
		   k=mid+1;
		  for(j=0;j<len2;j++) {
			  arr2[j]=arr[k++];
		  }
		  
		  		  
		  i=0;
		  j=0;
		  k=start;
		  while(i<len1 && j<len2) {
			  if(arr1[i] < arr2[j]) {
				  arr[k]=arr1[i];
				  i++;
			  }
			  else {
				  arr[k]=arr2[j];
				  j++;
			  }
			  k++;
		  }
		  
		  while(i<len1) {
			  arr[k]=arr1[i];
			  i++;
			  k++;
		  }
		  
		  while(j<len2) {
			  arr[k]=arr2[j];  
			  j++;
			  k++;
		  }
		  
		
	  }
	  
	  static void mergeSort(int[] arr,int start,int end) {
		  
		  if(start>=end) {
			  return;
		  }
		  
		  int mid=start+(end-start)/2;
		  
		  mergeSort(arr, start,mid);
		  
		  mergeSort(arr, mid+1, end);
		  
		  merge(arr, start, mid, end);
		  
		  
	  }
	  
	  
//    public static void main(String args[]) 
//    { 
//    	int[] arr=new int[] {1,2,3,0,0,0};
//    	int[] arr1=new int[] {2,5,6};
////    	mergeSortedArrayInPlace(arr, 3, arr1, arr1.length);
////    	System.out.println(Arrays.toString(arr));
////    	System.out.println(b);
//    } 
}
