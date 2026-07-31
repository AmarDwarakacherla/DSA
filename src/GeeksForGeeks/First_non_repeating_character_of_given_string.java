package GeeksForGeeks;

public class First_non_repeating_character_of_given_string {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(nonRepApproach2(s));
    }

    public static Character nonRepApproach1(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return s.charAt(i);
        }
        return '$';
    }

    public static Character nonRepApproach2(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        for(char ch : s.toCharArray()){
            if(freq[ch - 'a'] == 1){
                return ch;
            }
        }
        return '$';
    }
}
