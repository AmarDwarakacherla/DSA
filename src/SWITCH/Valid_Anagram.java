package SWITCH;

import java.util.Arrays;
import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";

        System.out.println(areAnagramsApproach3(s1, s2));
    }

    public static boolean areAnagramsApproach1(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static boolean areAnagramsApproach2(String s1, String s2) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        }
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramsApproach3(String s1, String s2) {
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            freq[ch-'a']--;
        }
        for(int i : freq){
            if(i !=0 ){
                return false;
            }
        }
        return true;
    }
}
