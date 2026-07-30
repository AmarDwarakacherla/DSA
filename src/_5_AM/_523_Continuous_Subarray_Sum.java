package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _523_Continuous_Subarray_Sum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySumApproach2(new int[]{23,2,4,6,7}, 6));

    }
    //Brute Force - TLE
    public static boolean checkSubarraySumApproach1(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(j-i+1>=2 && sum % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
    //optimal - PrefixSum + HashMap
    public static boolean checkSubarraySumApproach2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2){
                    return true;
                }
            }else {
                map.put(rem, i);
            }
        }
        return false;
    }

}
