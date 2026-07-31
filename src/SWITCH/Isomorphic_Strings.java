package SWITCH;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
    public static void main(String[] args) {

        String s1 = "aab";
        String s2 = "xxy";

        System.out.println(areIsomorphicApproach2(s1, s2));
    }

    public static boolean areIsomorphicApproach1(String s1, String s2) {
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            // Checking all occurrences of c1 in s1
            // corresponding occurrences of c2 in s2
            for (int j = 0; j < n; j++) {
                // If we find another occurrence of c1 in s1,
                // it must match the corresponding character in s2
                if (s1.charAt(j) == c1 && s2.charAt(j) != c2) {
                    return false;
                }
                // If we find another occurrence of c2 in s2,
                // it must match the corresponding character in s1
                if (s2.charAt(j) == c2 && s1.charAt(j) != c1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean areIsomorphicApproach2(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(!map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i), i);
            }
            if(!map2.containsKey(s2.charAt(i))) {
                map2.put(s2.charAt(i), i);
            }
            if(map1.get(s1.charAt(i)) != map2.get(s2.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
