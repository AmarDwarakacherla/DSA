package _5_AM;

public class _2239_Find_Closest_Number_to_Zero {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4,-2,1,4,8}));
    }
    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for(int num : nums){
            if(Math.abs(num)<Math.abs(closest)){
                closest = num;
            }else if(Math.abs(num)==Math.abs(closest) && num>closest){
                closest = num;
            }
        }
        return closest;

    }
}
