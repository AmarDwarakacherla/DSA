package SWITCH;

import java.util.*;

public class Group_Anagrams_Together {
    public static void main(String[] args) {

        String[] arr = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> res = anagramsApproach2(arr);
        System.out.println(res);
    }
    public static ArrayList<ArrayList<String>> anagrams(String[] arr){
        Map<String,Integer> map  = new HashMap<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(String str : arr){
            String key = isAna(str);
            if(!map.containsKey(key)){
                map.put(key,res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(key)).add(str);
        }
        return res;

    }
    public static String isAna(String s){
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            sb.append(freq[i]).append("#");
        }
        return sb.toString();
    }

    public static ArrayList<ArrayList<String>> anagramsApproach2(String[] arr){
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : arr){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
