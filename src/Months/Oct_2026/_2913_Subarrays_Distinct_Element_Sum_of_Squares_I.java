package Months.Oct_2026;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _2913_Subarrays_Distinct_Element_Sum_of_Squares_I {
    public static void main(String[] args) {
        System.out.println(sumCounts(Arrays.asList(1,2,1)));

    }
    public static int sumCounts(List<Integer> nums) {
        int sum = 0;
        for(int i=0;i<nums.size();i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<nums.size();j++){
                set.add(nums.get(j));
            }
            sum += set.size()* set.size();
        }
        return sum;

    }
}
