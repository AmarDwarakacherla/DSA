package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _560_Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,4,1}, 5));
    }
    //brute force - using tow for loops

    //optimal prefixSum + HashMap
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
