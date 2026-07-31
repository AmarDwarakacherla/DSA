package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class _2784_Check_if_Array_is_Good {
    public static void main(String[] args) {
        System.out.println(isGood(new int[]{1, 3, 3, 2}));
    }
    public static boolean isGood(int[] nums) {
        int n = nums.length-1;;
        Set<Integer> seen = new HashSet<>();
        boolean dup = false;
        for(int num : nums)
        {
            if(num>n)   return false;
            if(seen.contains(num)){
                if(num==n)
                    dup = true;
                else
                    return false;
            }
            seen.add(num);
        }
        return dup;
    }
}
