package Months.Sep_2026;

import java.util.Arrays;

public class _4_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysApproach2(new int[]{1,3},new int[]{2}));
    }

    public static double findMedianSortedArraysApproach2(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        int prev = 0;
        int current = 0;

        int total = m + n;

        for (int count = 0; count <= total / 2; count++) {

            prev = current;

            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    current = nums1[i++];
                } else {
                    current = nums2[j++];
                }
            }
            else if (i < m) {
                current = nums1[i++];
            }
            else {
                current = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (prev + current) / 2.0;
        }

        return current;
    }

        public static double findMedianSortedArraysApproach1(int[] nums1, int[] nums2) {
        int[] sorted = new int[nums1.length + nums2.length];
        int t = 0, i = 0, j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){

                sorted[t++] = nums2[j++];
            }else if(nums1[i]<nums2[j]){
                sorted[t++] = nums1[i++];
            }
        }
        while(i<nums1.length){
            sorted[t++] = nums1[i++];
        }
        while(j<nums2.length){
            sorted[t++] = nums2[j++];
        }
        System.out.println(Arrays.toString(sorted));
        if(sorted.length % 2 == 0){
            return (sorted[sorted.length/2] + sorted[sorted.length/2-1])/2.0;
        }else{
            return sorted[sorted.length/2];
        }

    }

}
