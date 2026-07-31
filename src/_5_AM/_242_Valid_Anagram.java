package _5_AM;

public class _242_Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("amar","rama"));

    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        for(char ch : t.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a']<0)
                return false;
        }
        return true;
    }
}
