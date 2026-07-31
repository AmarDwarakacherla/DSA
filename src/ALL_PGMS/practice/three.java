package ALL_PGMS.practice;
import java.util.*;
public class three {
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4, 6, 5};
		int M = 3;
		int start = M+1, end = arr.length-1, t = 0;
		while(start <= end) {
			t = arr[start];
			arr[start] = arr[end];
			arr[end] = t;
			start++;
			end--;
		}
		System.out.print(Arrays.toString(arr));

	}
}
