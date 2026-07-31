package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _169_Majority_Element {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));

    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0) + 1);
        }
        for(Integer i : freq.keySet()){
            int t = freq.get(i);
            if(nums.length/2 < t){
                return i;
            }
        }
        return -1;
    }
}
