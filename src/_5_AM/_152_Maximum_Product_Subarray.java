package _5_AM;

public class _152_Maximum_Product_Subarray {
    public static void main(String[] args) {
        System.out.println(maxProductKadenes(new int[]{2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int prod = 1, max = Integer.MIN_VALUE;
        for(int i : nums){
            prod = Math.max(prod * i, i);
            max = Math.max(max, prod);
        }
        return max;
    }
    public static int maxProductKadenes(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], max = nums[0];
        for(int i=1;i<nums.length;i++){
            int preMax = maxProduct;
            int preMin = minProduct;
            maxProduct = Math.max(nums[i],Math.max(preMax*nums[i], preMin*nums[i]));
            minProduct = Math.min(nums[i], Math.min(nums[i]*preMax, nums[i]*preMin));

            max= Math.max(max,maxProduct);
        }
        return max;
    }
    //Brute Force
    public static int maxProductApproach(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prod = 1;
        for(int i=0;i<nums.length;i++){
            prod = 1;
            for(int j=i;j<nums.length;j++){
                prod *= nums[j];
                maxProduct = Math.max(maxProduct, prod);
            }
        }
        return maxProduct;
    }
}
