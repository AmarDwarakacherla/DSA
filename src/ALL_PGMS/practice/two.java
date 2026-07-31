package ALL_PGMS.practice;
import java.util.*;

public class two {
	public static int[] product(int[] arr)
	{
		int pro = 1;
		int l[] = new int[arr.length];
		int r[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			l[i]=pro;
			pro = pro * arr[i];
		}
		pro = 1;
		for(int i=arr.length-1;i>=0;i--)
		{
			r[i]=pro;
			pro = pro * arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = l[i]*r[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = new int[] {1,2,0,3,4};
		int t[] = product(arr);
		System.out.print(Arrays.toString(t));

	}

}
