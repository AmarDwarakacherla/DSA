package _5_AM;

import java.util.Arrays;

public class _567_Permutation_in_String {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc","dcda˳"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for(int i=0;i<s1.length();i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++){
            if(Arrays.equals(s1Freq,s2Freq)){
                return true;
            }
            s2Freq[s2.charAt(i)-'a']--;
            s2Freq[s2.charAt(i+s1.length())-'a']++;
        }
        return false;
    }
}
