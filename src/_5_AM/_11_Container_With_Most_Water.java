package _5_AM;

public class _11_Container_With_Most_Water {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

    }
    public static int maxArea(int[] height) {
        if(height.length<2) return 0;
        int left = 0, right = height.length-1;
        int h = Integer.MIN_VALUE, w = 0, product = Integer.MIN_VALUE;
        while(left < right){
            h = Math.min(height[left], height[right]);
            w = right - left;
            product = Math.max(product, h * w);
           if(height[left]>height[right]){
              right--;
           }else{
               left++;
           }
        }
        return product;

    }
}
