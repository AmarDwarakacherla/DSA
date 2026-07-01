package LeetCode;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfApproach2(new int[]{1, 2, 3})));
    }

    public static int[] productExceptSelfApproach1(int[] nums) {
        int zeroCount = 0;
        for (int i : nums) {
            if (i == 0)
                zeroCount++;
        }
        if (zeroCount > 1) {
            Arrays.fill(nums, 0);
        } else if (zeroCount == 1) {
            int product = 1, zeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    product *= nums[i];
                } else {
                    zeroIndex = i;
                }
            }
            Arrays.fill(nums, 0);
            nums[zeroIndex] = product;
        } else {
            int product = 1;
            for (int i : nums)
                product *= i;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    public static int[] productExceptSelfApproach2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left,1);Arrays.fill(right,1);
        for(int i=0;i<nums.length-1;i++){
            left[i+1] = left[i]*nums[i];
        }
        for(int i=nums.length-1;i>=1;i--){
            right[i-1] = right[i]*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = left[i] * right[i];
        }
        return nums;

    }
}
