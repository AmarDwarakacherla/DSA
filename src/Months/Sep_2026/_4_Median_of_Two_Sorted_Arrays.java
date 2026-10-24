package Months.Sep_2026;

import java.util.Arrays;

public class _4_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysApproach2(new int[]{1,3},new int[]{2,1}));
    }

    public static double findMedianSortedArraysApproach2(int[] nums1, int[] nums2) {

        int i = 0, j = 0, curr = 0, prev = 0;
        int total = nums1.length+nums2.length;
        for(int c = 0; c <= total/2; c++){
            prev = curr;
            if(i<nums1.length && j<nums2.length){
                if(nums1[i] < nums2[j]){
                    curr = nums1[i++];
                }else{
                    curr = nums2[j++];
                }
            }else if(i < nums1.length){
                curr = nums1[i++];
            }else{
                curr = nums2[j++];
            }
        }
        if(total % 2 == 0){
            return (prev+curr)/2.0;
        }
        return curr;
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
