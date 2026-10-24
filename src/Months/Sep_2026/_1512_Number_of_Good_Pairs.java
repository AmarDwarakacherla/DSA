package Months.Sep_2026;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _1512_Number_of_Good_Pairs {
    public static void main(String[] args) {
        System.out.println(Approach2numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        AtomicInteger count = new AtomicInteger();

        count.incrementAndGet();

    }
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j] && i < j){
                    count++;
                }
            }
        }
        return count;

    }
    public static int Approach2numIdenticalPairs(int[] nums) {
        int pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int count = map.getOrDefault(num,0);
            pairs += count;
            map.put(num,count+1);
        }
        return pairs;
    }
}
