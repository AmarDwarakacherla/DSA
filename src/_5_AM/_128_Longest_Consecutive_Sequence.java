package _5_AM;

import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
//        for(int i : nums){
//            if(!set.contains(i-1))
//        }
        return  0;

    }
}
