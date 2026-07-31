package _5_AM;

import java.util.*;

public class _438_Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int[] pFreq = new int[26], windowFreq = new int[26];
        for(char ch : p.toCharArray()){
            pFreq[ch-'a']++;
        }
        //sliding window
        for(int i=0;i<s.length();i++){
            //add current character
            windowFreq[s.charAt(i)-'a']++;
            // removing the left most character
            if(i>=pLen){
                windowFreq[s.charAt(i-pLen)-'a']--;
            }
            if(i>=pLen-1 && Arrays.equals(pFreq,windowFreq)){
                result.add(i-pLen+1);
            }
        }
        return result;
    }


    public static List<Integer> findAnagramsApproacch2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pChar = p.toCharArray();
        int len = p.length();
        Arrays.sort(pChar);
        for(int i=0;i<s.length()-p.length();i++){
            char[] windowChar = s.substring(i,i+len).toCharArray();
            Arrays.sort(windowChar);
            if(Arrays.equals(pChar,windowChar)){
                result.add(i);
            }
        }
        return result;
    }

}
