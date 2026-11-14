package Months.Oct_2026;

public class _26_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println(removeDuplicates(new int[]{0,0,5,5,2}));

    }
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
