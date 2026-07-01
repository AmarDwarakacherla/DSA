package LeetCode;

public class _2348_Number_of_Zero_Filled_Subarrays {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarrayApproach2(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(zeroFilledSubarrayApproach2(new int[]{0,0,0,2,0,0}));

           }
    public static long zeroFilledSubarrayApproach1(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
           for(int j=i;j<nums.length;j++){
               if(nums[j] == 0)
                   count++;
               else
                   break;
           }
        }
        return count;
    }
    public static long zeroFilledSubarrayApproach2(int[] nums) {
        long count = 0, zero = 0;
        for(int i : nums){
            if(i == 0) {
                zero++;
                count += zero;
            }else{
                zero = 0;
            }
        }
        return count;
    }

}

