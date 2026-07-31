package _5_AM;

import java.util.Arrays;

public class _14_Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefixApproach2(new String[]{"felower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(String s : strs){
            min = Math.min(s.length(),min);
        }
        StringBuilder sb = new StringBuilder();
       for(int i=0;i<min;i++){
           char ch = strs[0].charAt(i);
           for(String s : strs){
               if(s.charAt(i)!=ch){
                   return sb.toString();
               }
           }
           sb.append(ch);
       }
       return sb.toString();
    }
    public static String longestCommonPrefixApproach2(String[] strs) {
        Arrays.sort(strs);
        int i=0;
        String first = strs[0], last = strs[strs.length-1];
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }

}
