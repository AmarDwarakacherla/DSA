package SWITCH;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        System.out.println(Arrays.toString(rotateArrApproach3(arr, d)));

    }

    public static int[] rotateArrApproach1(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            int t = arr[arr.length - 1];
            for (int j = arr.length - 1; j >= 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = t;
        }
        return arr;
    }

    public static int[] rotateArrApproach2(int[] arr, int d) {
        d = d % arr.length;
        int[] temp = new int[arr.length];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[arr.length - d + i];
        }
        for (int i = 0; i < arr.length - d; i++) {
            temp[i + d] = arr[i];
        }
        return temp;
    }

    public static int[] rotateArrApproach3(int[] arr, int d) {
        d = d % arr.length;
        swap(arr,0,arr.length-1);
        swap(arr,0,d-1);
        swap(arr,d,arr.length-1);
        return arr;

    }
    public static void swap(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}