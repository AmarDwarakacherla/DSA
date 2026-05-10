package SWITCH;

public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int arr[] = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductApproach1(arr));
        System.out.println(maxProductApproach2(arr));
        System.out.println(maxProductApproach3(arr));
    }

    public static int maxProductApproach1(int[] arr) {
        int maxProduct = arr[0], product = 1;
        for (int i = 0; i < arr.length; i++) {
            product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maxProductApproach2(int[] arr) {
        int currMax = arr[0], currMin = arr[0], maxProduct = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //storing max product at the current index
            int t = max(arr[i], currMax * arr[i], currMin * arr[i]);
            //min product at current index
            currMin = min(arr[i], currMax * arr[i], currMin * arr[i]);
            //updating the max product at current index
            currMax = t;
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int maxProductApproach3(int[] arr) {
        int leftToRight = 1, rightToLeft = 1, maxProduct = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if(leftToRight == 0) leftToRight = 1;
            if(rightToLeft == 0) rightToLeft = 1;

            leftToRight = leftToRight * arr[i];
            rightToLeft = rightToLeft * arr[arr.length-i-1];
            maxProduct = Math.max(leftToRight, Math.max(rightToLeft, maxProduct));
        }
        return maxProduct;
    }
}
