package _5_AM;

public class _1768_Merge_Strings_Alternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0,j = 0;
        while(i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;j++;
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
