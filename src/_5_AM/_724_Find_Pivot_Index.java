package _5_AM;

public class _724_Find_Pivot_Index {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public static int pivotIndex(int[] nums) {
        int rightSum = 0, leftSum = 0, pivot = 0;
        for(int i : nums)
            rightSum += i;

        for(int i=0;i<nums.length;i++){
            rightSum -= nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }


        return  -1;

    }
}
