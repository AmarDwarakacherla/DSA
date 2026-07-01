package LeetCode;

import java.util.Arrays;

public class _392_Is_Subsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequenceApproach2("abc", "ahbgdc"));
    }

    public static boolean isSubsequenceApproach1(String s, String t) {
        //wrong code
        //checking the freq only
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;
        for (char ch : t.toCharArray())
            freq[ch - 'a']--;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                count++;
            }
        }
        return count == s.length();
    }

    public static boolean isSubsequenceApproach2(String s, String t) {
        int i = 0, j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
