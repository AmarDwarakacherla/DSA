package GeeksForGeeks;

import java.util.HashSet;
import java.util.Set;

public class Product_Pair {
    public static void main(String[] args) {
        System.out.println(isProductApproach2(new int[]{10, 20, 9, 40}, 400));
    }

    public static boolean isProductApproach1(int[] arr, long target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isProductApproach2(int[] arr, long target) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(num == 0){
                if(target == 0){
                    return true;
                }
            }else{
                if(target % num == 0){
                    int div = (int) (target / num);
                    if(set.contains(div)){
                        return true;
                    }
                }
            }
            set.add(num);
        }
        return false;
    }
}
