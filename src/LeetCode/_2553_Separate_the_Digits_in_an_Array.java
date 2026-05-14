package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class _2553_Separate_the_Digits_in_an_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13,25,83,77})));
    }
    public static int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            String str = String.valueOf(num);
            for(char ch : str.toCharArray()){
                list.add(ch-'0');
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

}
