package SWITCH;

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.HashSet;

public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        System.out.println(findDuplicateApproach5(new int[]{1, 3, 4, 2, 2}));
    }

    public static int findDuplicateApproach1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int findDuplicateApproach2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return nums[i];
        }
        return -1;
    }

    public static int findDuplicateApproach3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return i;
            set.add(i);
        }
        return -1;
    }

    //using Floyd’s Cycle Detection
    public static int findDuplicateApproach4(int[] nums) {
        int slow = nums[0], fast = nums[0];
        //find the meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        //finding the entrance
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int findDuplicateApproach5(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        for (int i : nums) {
            if (seen[i]) {
                return i;
            }
            seen[i] = true;
        }
        return 0;
    }
}