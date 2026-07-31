package _5_AM;

import java.util.Arrays;

public class _48_Rotate_Image {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        for(int[] i : arr){
            System.out.println(Arrays.toString(i));
        }

    }
    public static void rotate(int[][] matrix) {
        //swap all except the diagonals
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                    swap(matrix,i,j);
            }
        }
        //rotate each row;
        for(int i=0;i<matrix.length;i++){
            int start = 0, end = matrix[i].length-1;
            while(start<=end){
                int t = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = t;
                start++;end--;
            }
        }
    }
    public static void swap(int[][] matrix, int i , int j){
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }
}
