package LeetCode;

public class _941_Valid_Mountain_Array {
    public static void main(String[] args) {
        System.out.println(validMountainArrayApproach2(new int[]{0, 3, 2, 1}));
    }

    public static boolean validMountainArrayApproach1(int[] arr) {
        if (arr.length < 3)
            return false;
        int peak = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[peak]) {
                peak = i;
            }
        }
        //check weather peak equals to start index or end index
        if (peak == 0 || peak == arr.length - 1)
            return false;
        for (int i = 0; i < peak; i++) {
            if (arr[i] >= arr[i + 1])
                return false;
        }
        for (int i = peak; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1])
                return false;
        }
        return true;
    }

    public static boolean validMountainArrayApproach2(int[] arr) {
        if (arr.length < 3)
            return false;
        int i = 0;
        //climbing up
        while (i+1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        //peak cannot be first or last
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        //climbing down
        while (i+1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }
}
