package week4.Search_2D_Matrix;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
        int numOfRows=matrix.length;
        int numOfCol=matrix[0].length;
        int start=0;
        int end=(numOfRows*numOfCol)-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            int row=mid/numOfCol;
            int col=mid%numOfCol;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return false;

    }
}
