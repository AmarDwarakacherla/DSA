package Months.Oct_2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _217_Contains_Duplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicateApproach3(new int[]{1,2,3}));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Integer i : map.values()){
            if(i > 1){
                return true;
            }
        }
//        for(Integer i : map.keySet()){
//            if(map.get(i) > 1){
//                return true;
//            }
//        }
        return false;
    }
    public static boolean containsDuplicateApproach2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
    public static boolean containsDuplicateApproach3(int[] nums) {
        //need to add if the array.legnth < 1
        if(nums.length == 0 || nums.length==1){
            return false;
        }
        int max = Arrays.stream(nums).max().orElseThrow(()->new RuntimeException(""));
        int temp[] = new int[max+1];
        for(int i : nums){
            temp[i]++;
        }
        for(int i : temp){
            if(i > 1){
                return true;
            }
        }
        return false;
    }
}
