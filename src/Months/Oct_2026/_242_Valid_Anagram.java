package Months.Oct_2026;

import java.util.Arrays;

public class _242_Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram",  "nagaram"));

    }
    public static boolean isAnagram(String s, String t) {
        int freq[] = new int[27];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            freq[ch-'a']--;
        }
        for(int i : freq){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
