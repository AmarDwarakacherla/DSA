package _5_AM;

public class _1189_Maximum_Number_of_Balloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoonbal"));

    }
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray()){
            freq[ch-'a']++;
        }
        return  Math.min(Math.min(freq['b'-'a'],freq['a'-'a']),Math.min(Math.min(freq['l'-'a']/2,freq['o'-'a']/2),freq['n'-'a']));

    }
}
