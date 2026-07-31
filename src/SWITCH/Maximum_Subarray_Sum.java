package SWITCH;

public class Maximum_Subarray_Sum {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySumApproach2(arr));
    }

    public static int maxSubarraySumApproach1(int[] arr) {
        int maxSum = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                maxSum = Math.max(maxSum, sum += arr[j]);
            }
        }
        return maxSum;
    }

    public static int maxSubarraySumApproach2(int[] arr) {
        int maxSum = arr[0], sum = arr[0];
        for(int i=1;i<arr.length;i++){
            sum = Math.max(arr[i],sum+arr[i]);
            maxSum = Math.max(maxSum, sum);

        }
        return maxSum;

    }
}