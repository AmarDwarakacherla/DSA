package LeetCode;

import java.util.HashSet;

public class _3043_Find_the_Length_of_the_Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1,10,100}, new int[]{1000}));
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        for(int num : arr1){
            while(!set.contains(num) && num>0){
                set.add(num);
                num /= 10;
            }
        }
        for(int num : arr2){
            while(!set.contains(num) && num>0){
                num /= 10;
            }
            if(num>0){
                maxLength = Math.max(maxLength, (int)Math.log10(num)+1);
            }
        }
        return maxLength;
    }

}
