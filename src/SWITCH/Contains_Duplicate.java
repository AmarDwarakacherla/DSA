package SWITCH;

import java.util.Arrays;
import java.util.HashSet;

public class Contains_Duplicate {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4};
        System.out.println(checkDuplicatesApproach1(arr));
        System.out.println(checkDuplicatesApproach2(arr));
        System.out.println(checkDuplicatesApproach3(arr));


    }

    public static boolean checkDuplicatesApproach1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicatesApproach2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicatesApproach3(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
