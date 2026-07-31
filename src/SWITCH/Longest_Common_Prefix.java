package SWITCH;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        System.out.println(longestCommonPrefixApproach2(arr));
    }

    public static String longestCommonPrefixApproach1(String[] arr) {
        Arrays.sort(arr);
        String first = arr[0], end = arr[arr.length - 1];
        int minLength = Math.min(first.length(), end.length());
        int i = 0;
        while (i < minLength && first.charAt(i) == end.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }

    public static String longestCommonPrefixApproach2(String[] arr) {
        int minLength = arr[0].length();
        for(String s : arr)
            minLength = Math.min(minLength, s.length());
        StringBuilder res = new StringBuilder();
        for(int i=0;i<minLength;i++){
            char ch = arr[0].charAt(i);
            for(String str : arr){
                if(str.charAt(i) != ch){
                    return res.toString();
                }
            }
            res.append(ch);
        }
        return res.toString();
    }

    //using divide and conquer
    public static String longestCommonPrefixApproach3(String[] arr) {
        return "";

    }
}

