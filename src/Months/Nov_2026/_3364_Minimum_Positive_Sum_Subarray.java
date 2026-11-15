package Months.Nov_2026;

import java.util.Arrays;
import java.util.List;

public class _3364_Minimum_Positive_Sum_Subarray {
    public static void main(String[] args) {
        System.out.println(minimumSumSubarray(Arrays.asList(-2,2,-3,1),2, 3));


    }
    //time - o(n^2) space - o(1)
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int  min = Integer.MAX_VALUE, sum = 0, len = 0;
        for(int i=0;i<nums.size();i++){
            sum = nums.get(i);
            for(int j=i+1;j<nums.size();j++){
                sum += nums.get(j);
                len = j - i + 1;
                if(len>=l && len<=r && sum >0) {
                    min = Math.min(sum, min);
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static int minimumSumSubarrayApproach2(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n+1];
        return 0;
    }


}
