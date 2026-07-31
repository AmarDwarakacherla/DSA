package SWITCH;

import java.util.*;

public class Two_Sum {
    public static void main(String[] args) {

        System.out.println(twoSumApproach2(new int[]{0, -1, 2, -3, 1}, -2));
        System.out.println(twoSumApproach2(new int[]{1, -2, 1, 0, 5}, 0));
        System.out.println(twoSumApproach3(new int[]{1, -2, 1, 0, 5}, 0));
        System.out.println(twoSumApproach4(new int[]{0, -1, 2, -3, 1}, -2));


    }

    public static boolean twoSumApproach1(int arr[], int target) {
        boolean status = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoSumApproach2(int arr[], int target) {
        Arrays.sort(arr);
        int complement = 0;
        for (int i = 0; i < arr.length; i++) {
            complement = target - arr[i];
            if (binarySearch(arr, i + 1, arr.length - 1, complement)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int arr[], int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static boolean twoSumApproach3(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static boolean twoSumApproach4(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
