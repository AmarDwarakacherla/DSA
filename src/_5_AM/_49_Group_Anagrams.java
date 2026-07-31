package _5_AM;

import java.util.*;

public class _49_Group_Anagrams {
    public static void main(String[] args) {
        List<List<String>> group = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> str : group)
            System.out.println(str);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> group = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char ch : str.toCharArray()){
                count[ch-'a']++;
            }
            //creating a unique key
            StringBuilder key = new StringBuilder();
            for(int ch : count){
                key.append(ch).append("#");
            }
//            group.computeIfAbsent(key.toString(),k->new  ArrayList<>()).add(str);
            group.putIfAbsent(key.toString(),new ArrayList<>());
            group.get(key.toString()).add(str);
        }
        //if we want to filter a list by length
        List<List<String>> newStr = new ArrayList<>(group.values());
        newStr.sort(Comparator.comparingInt(l->l.size()));

//        return new ArrayList<>(group.values());
        return newStr;
    }
}
