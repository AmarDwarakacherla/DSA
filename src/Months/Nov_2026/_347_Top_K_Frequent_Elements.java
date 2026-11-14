package Months.Nov_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _347_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3},2)));

    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(Integer i : map.keySet()){
            list.add(i);
        }
        list.sort((a, b) -> map.get(b) - map.get(a));
        return list.stream().limit(k).mapToInt(Integer::valueOf).toArray();
    }
}
