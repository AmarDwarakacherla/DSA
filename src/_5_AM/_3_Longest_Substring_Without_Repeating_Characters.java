package _5_AM;

import Practice.Main;

import java.util.HashSet;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringApproach2("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int maxLen = 0, left = 0;
        for(int right = 0;right<s.length();right++){
            freq[s.charAt(right)]++;
            //if we found duplicates shrinking the window
            while(freq[s.charAt(right)]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringApproach2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
