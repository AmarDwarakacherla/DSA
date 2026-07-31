package POTD;

public class _3517_Smallest_Palindromic_Rearrangement_I {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("babab"));
    }
    public static String smallestPalindrome(String s) {
        if(s.length() <=1 ) return s;
        StringBuilder start = new StringBuilder(), mid = new StringBuilder(), end = new StringBuilder();
        //count the freq of each character
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        //to add all the characters once
       for(int i = 0;i<26;i++){
          for(int j =0;j<freq[i]/2;j++){
               start.append(String.valueOf((char) (i + 'a')));
           }
           if(freq[i] % 2 ==1){
               mid.append(String.valueOf((char) (i + 'a')));
           }
       }
//        System.out.println(start + "->"+mid+"->"+end);
       return start.toString() + mid.toString() + start.reverse().toString();
    }
}
