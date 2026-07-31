package LeetCode;

import java.util.HashSet;

public class _41_First_Missing_Positive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositiveApproach3(new int[]{1, 0, 2}));
    }

    public static int firstMissingPositiveApproach1(int[] nums) {
        //won't work for the negative numbers
        int sum = nums.length * (nums.length + 1) / 2;
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        return sum - totalSum;
    }

    public static int firstMissingPositiveApproach2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public static int firstMissingPositiveApproach3(int[] nums) {
        //using cyclic sort
        int i=0;
        while(i<nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;

    }
}
