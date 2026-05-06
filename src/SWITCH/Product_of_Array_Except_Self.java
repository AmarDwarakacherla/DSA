package SWITCH;

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res = productExceptSelfApproach2(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] productExceptSelfApproach1(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            res[i] = product;
        }
        return res;
    }

    public static int[] productExceptSelfApproach2(int[] arr) {
        int[] suffixArray = new int[arr.length], prefixArray = new int[arr.length];
        prefixArray[0] = 1;
        suffixArray[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefixArray[i] = arr[i - 1] * prefixArray[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixArray[i] = arr[i + 1] * suffixArray[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = prefixArray[i] * suffixArray[i];
        }
        return arr;
    }

    public static int[] productExceptSelfApproach3(int[] arr) {
        int zeroCount = 0, zeroIndex = 0, product = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                product *= arr[i];
            }
        }
        if (zeroCount == 0) {
            for (int i = 0; i < arr.length; i++)
                arr[i] = product / arr[i];
        } else if (zeroCount == 1) {
            arr[zeroIndex] = product;
        }
        return arr;
    }
}