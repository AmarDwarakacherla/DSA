package SWITCH;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(getLongestPalApproach2(s));
    }

    public static String getLongestPalApproach1(String s) {
        int n = s.length(), maxLen = 1, start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String getLongestPalApproach2(String s) {
        String LPS = "";
        for (int i = 1; i < s.length(); i++) {
            // for odd length
            int low = i, high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) break;
            }
            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
            // for even length
            low = i - 1;
            high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) break;
            }
            palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }
        return LPS;
    }
}
