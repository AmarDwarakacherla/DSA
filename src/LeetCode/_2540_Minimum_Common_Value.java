package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _2540_Minimum_Common_Value {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1,2,3}, new int[]{2,4}));

        System.out.println(getCommonApproach2(new int[]{1,2,3}, new int[]{2,4}));
    }
    public static int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
                return nums1[i];
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        return -1;
    }
    public static int getCommonApproach2(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums1){
            seen.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(seen.contains(num)){
                list.add(num);
            }
        }
        return list.isEmpty() ? -1 : list.getFirst();

    }
}
