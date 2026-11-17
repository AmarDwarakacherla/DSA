package Months.Nov_2026;

import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0, current = 0, count = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                current = num;
                count = 1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;

    }
}
