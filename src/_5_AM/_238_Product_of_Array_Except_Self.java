package _5_AM;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfApproach2(new int[]{1, 2, 3, 4})));

        System.out.println(Arrays.toString(productExceptSelfApproach2(new int[]{-1, 1, 0, -3, 3})));

    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 0) {
            return new int[]{0};
        }
        //count no of zeros
        int zeroCount = 0, zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
        }
        if (zeroCount >= 2) {
            Arrays.fill(nums, 0);
        } else if (zeroCount == 1) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    product *= nums[i];
                }
            }
            Arrays.fill(nums, 0);
            nums[zeroIndex] = product;
        } else {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
        }
        return nums;

    }

    public static int[] productExceptSelfApproach2(int[] nums) {
        //using left array and right array
        //left - storing from left to right
        //right - storing from right to left
        // product of left and right array

        int[] leftSum = new int[nums.length], rightSum = new int[nums.length];
        leftSum[0] = 1; rightSum[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++){
            leftSum[i] = leftSum[i-1] * nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightSum[i] = rightSum[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = leftSum[i] * rightSum[i];
        }
        return nums;
    }
}