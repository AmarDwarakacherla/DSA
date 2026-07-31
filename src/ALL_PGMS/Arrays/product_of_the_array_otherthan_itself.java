package ALL_PGMS.Arrays;
import java.util.*;

public class product_of_the_array_otherthan_itself {

    public static void main(String[] args) {
        int a[] = new int[] {1,2,3,4};
        System.out.print(Arrays.toString(product_array(a)));

    }
    private static int[] product_array(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < n; i++) {
            a[i] = left[i] * right[i];
        }
        return a;
    }
}
