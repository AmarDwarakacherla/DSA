package SWITCH;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println(Arrays.toString(mergeArraysApproach2(arr1, arr2)));
    }

    static int[] mergeArraysApproach1(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] merge = new int[m + n];
        int t = 0;
        for (int i = 0; i < m; i++) {
            merge[t++] = arr1[i];
        }
        for (int j = 0; j < n; j++) {
            merge[t++] = arr2[j];
        }
        Arrays.sort(merge);
        return merge;
    }

    static int[] mergeArraysApproach2(int[] arr1, int[] arr2) {
        int left = 0, right = 0, m =arr1.length, n = arr2.length, k = 0;
        int[] merged = new int[m + n];
       while(left < m && right < n){
           if(arr1[left] < arr2[right]){
               merged[k++] = arr1[left++];
           }else if(arr1[left] > arr2[right]){
               merged[k++] = arr2[right++];
           }
       }
       //add the remaining
        while(left < m) merged[k++] = arr1[left++];
        while(right < n) merged[k++] = arr2[right++];
        //place the merged array to arr1 and  arr2
        return merged;
    }
}
