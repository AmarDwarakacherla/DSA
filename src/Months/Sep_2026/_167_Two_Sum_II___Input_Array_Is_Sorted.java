package Months.Sep_2026;

import java.util.Arrays;

public class _167_Two_Sum_II___Input_Array_Is_Sorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

    }
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{left, right};
            }
            else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return new  int[]{-1,-1};

    }
}

