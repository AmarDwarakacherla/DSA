package _5_AM;

import java.util.*;

public class _15_3Sum {
    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> i : res){
            System.out.println(i);
        }

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length<3) return new ArrayList<>();
        Set<List<Integer>> res= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
