package _5_AM;

import java.util.Arrays;
import java.util.HashSet;

public class _217_Contains_Duplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicateApproach2(new int[]{1,2,3,4,3}));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupli = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!dupli.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicateApproach2(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev != nums[i]){
                prev = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
