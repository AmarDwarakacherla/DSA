package _5_AM;

public class _383_Ransom_Note {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab","baa"));

    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(char ch : magazine.toCharArray())
            freq[ch-'a']++;
        for(char ch : ransomNote.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a']<0)
                return false;
        }
        return true;
    }
}
