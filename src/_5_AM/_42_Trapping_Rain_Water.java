package _5_AM;

public class _42_Trapping_Rain_Water {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }
    public static int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] leftMax = new int[height.length], rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for(int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int water = 0;
        for(int i=0;i<height.length;i++){
            water += Math.min(rightMax[i],leftMax[i])-height[i];
        }
        return water;


    }
}
