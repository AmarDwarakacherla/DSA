package LeetCode;

public class _1358_Number_of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstringsApproach3("abcabc"));

    }

    public static int numberOfSubstringsApproach1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean a = false, b = false, c = false;
                for (int k = i; k <= j; k++) {
                    if (s.charAt(k) == 'a')
                        a = true;
                    else if (s.charAt(k) == 'b')
                        b = true;
                    else if (s.charAt(k) == 'c')
                        c = true;
                }
                if (a && b && c)
                    ans++;

            }
        }
        return ans;
    }

    public static int numberOfSubstringsApproach2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[3];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0)
                    ans++;
            }
        }
        return ans;
    }

    public static int numberOfSubstringsApproach3(String s) {
        int[] freq = new int[3];
        int left = 0, count = 0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count += s.length()-right;
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
    }
}
