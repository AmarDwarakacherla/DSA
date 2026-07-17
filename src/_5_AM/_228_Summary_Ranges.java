package _5_AM;

import java.util.*;

public class _228_Summary_Ranges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //checking weather the current number is not consecutive
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        //Add the last
        if (start == nums[nums.length - 1]) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }
        return res;
    }

    public static List<String> summaryRangesApproach2(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            boolean is = false;
            //0 ,1,2,3,4
            while(i<nums.length && nums[i]+1==nums[i+1]){
                i++;
                is = true;
            }
            if(is){
                sb.append("->");
                sb.append(nums[i]);
            }
            res.add(sb.toString());
        }
        return res;

    }
}
