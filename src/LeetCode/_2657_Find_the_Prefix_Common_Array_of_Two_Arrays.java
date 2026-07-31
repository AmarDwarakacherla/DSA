package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2657_Find_the_Prefix_Common_Array_of_Two_Arrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2,3,1},new int[]{3,1,2})));
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();
        int count = 0;
        int[] C = new int[A.length];
        for(int i=0;i<A.length;i++){
            setA.add(A[i]);
            if(setA.contains(B[i])){
                count++;
            }
            setB.add(B[i]);
            if(A[i] != B[i] && setB.contains(A[i])){
                count++;
            }
            C[i] = count;
        }


        return C;
    }
}
