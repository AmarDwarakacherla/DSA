package _5_AM;

public class _53_Maximum_Subarray {
    public static void main(String[] args) {
        System.out.println(kadanes(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i : nums){
            sum = Math.max(sum+i,i);
            max = Math.max(sum,max);
        }
        return max;
    }
    public static int kadanes(int[] nums){
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum = nums[i];
            }else{
                sum+=nums[i];
            }
            if(max<sum){
                max = sum;
            }
        }
        return max;
    }

    //Brute Force using the two loop approach
}
