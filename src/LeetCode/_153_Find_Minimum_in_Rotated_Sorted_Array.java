package LeetCode;

import java.util.Arrays;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(fintMinApproax2(new int[]{5,4,1,2,3}));
    }
    //using linear search
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }
        return min;
    }
    //using binary search
    public static int fintMinApproax2(int[] nums){
        int low = 0, high = nums.length-1;
        while(low < high){
            //current range is sorted, first element would be the min
            if(nums[low] < nums[high])  return nums[low];
            int mid = low + (high - low)/2;
            //min lies in right half
            if(nums[mid] > nums[high])
                low = mid + 1;
            // min lies in left half including the mid
            else
                high = mid;
        }
        // low == high points to min
        return nums[low];
    }

}
