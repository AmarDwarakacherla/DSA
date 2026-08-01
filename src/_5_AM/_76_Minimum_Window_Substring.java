package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _76_Minimum_Window_Substring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> required = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0, found = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for(char c : t.toCharArray()){
            required.put(c,required.getOrDefault(c,0) + 1);
        }
        while(right < s.length()){
            char rightChar = s.charAt(right);
            window.put(rightChar,window.getOrDefault(rightChar,0) + 1);
            if(required.containsKey(rightChar) && required.get(rightChar).intValue() == window.get(rightChar).intValue()){
                found++;
            }
            while(found == required.size()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)){
                    found--;
                }
                left++;
            }

            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" :s.substring(startIndex,startIndex+minLen);

    }
}
