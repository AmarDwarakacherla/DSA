package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _974_Subarray_Sums_Divisible_by_K {
    public static void main(String[] args) {
        System.out.println(subarraysDivByKApproach2(new int[]{4,5,0,-2,-3,1}, 5));

    }
    public static int subarraysDivByKApproach1(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraysDivByKApproach2(int[] nums, int k){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, rem = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            rem = sum % k;
            if(rem < 0){
                rem +=k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}
