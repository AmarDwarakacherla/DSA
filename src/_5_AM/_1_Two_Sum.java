package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length<=0) return new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }
            map.put(nums[i],i);
        }
        return res;

    }
}
