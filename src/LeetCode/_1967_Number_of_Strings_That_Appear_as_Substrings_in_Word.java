package LeetCode;

public class _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    public static void main(String[] args) {
        System.out.println(numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
    }
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String str : patterns){
            if(word.contains(str)){
                count++;
            }
        }
        return count;
    }
}
