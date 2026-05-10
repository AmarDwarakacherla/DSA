package ALL_PGMS.Arrays;
import java.util.*;
public class rotateArray {
	public static int[] Approach1Right(int[] arr,int k) {
		for(int i=0;i<k;i++)
		{
			int temp = arr[arr.length-1];
			for(int j=arr.length-1;j>=1;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[0]=temp;
			
		}
		return arr;
	}
	public static int[] Approach1Left(int[] arr,int k)
	{
		for(int i=0;i<k;i++)
		{
			int t = arr[0];
			for(int j=0;j<arr.length-1;j++)
			{
				arr[j]=arr[j+1];
			}
			arr[arr.length-1] = t;
		}
		return arr;
	}
	public static int[] Approach2Right(int[] arr,int k)
	{
		reverse(arr,0,arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		return arr;
	}
	public static int[] Approach2Left(int[] arr,int k)
	{
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		reverse(arr,0,arr.length-1);
		return arr;
	}
	public static void reverse(int[] arr,int start,int end)
	{
		while(start<end)
		{
			int t = arr[start];
			arr[start] = arr[end];
			arr[end] = t;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args)
	{
		int arr[] = new int[] {1,2,3,4,5,6,7};
		int arr1[] = Arrays.copyOf(arr, arr.length);
		int arr2[] = Arrays.copyOf(arr, arr.length);
		int arr3[] = Arrays.copyOf(arr,arr.length);
		int arr4[] = Arrays.copyOf(arr,arr.length);
		int k =3;
		int result1[] = Approach1Right(arr1,k);
		int result2[] = Approach2Right(arr2,k);
		int result3[] = Approach1Left(arr3,k);
		int result4[] = Approach1Left(arr4,k);
		System.out.println("Right Rotate"+Arrays.toString(result1));
		System.out.println("Right Rotate"+Arrays.toString(result2));
		System.out.println("left Rotate"+Arrays.toString(result3));
		System.out.println("left Rotate"+Arrays.toString(result4));
		
	}

}
