package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _771_Jewels_and_Stones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStonesApproach2("Z","zZ"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> freq = new HashMap<>();
        for (Character ch : stones.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (Character ch : jewels.toCharArray()) {
            if (freq.containsKey(ch)) {
                count += freq.get(ch);
            }
        }
        return count;
    }

    public static int numJewelsInStonesApproach2(String jewels, String stones) {
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}