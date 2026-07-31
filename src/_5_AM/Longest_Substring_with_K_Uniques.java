package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_K_Uniques {
    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe", 3));
    }
    public static int longestKSubstr(String s, int k) {
        if(s==null || s.isEmpty() || k==0){
            return -1;
        }
        int[] freq = new int[256];
        int left = 0, maxLen = -1, distinctChar = 0;
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)]==0){
                distinctChar++; // new distinct char
            }
            freq[s.charAt(right)]++;
            //if distinct count exceeds k , shrink the window
            while(distinctChar > k){
                freq[s.charAt(left)]--;
                if(freq[s.charAt(left)]==0){
                    distinctChar--;
                }
                left++;
            }
            if(distinctChar == k){
                maxLen = Math.max(maxLen, right-left+1);
            }

        }
        return maxLen;
    }
}
