package ALL_PGMS.Arrays;
import java.util.*;
public class Merge_Sorted_Array {
	public static void merge(int a[],int b[])
	{
		int n=a.length;
		int m=b.length;
		int left = 0;
		int right = 0;
		int index = 0;
		
		int temp[] = new int[a.length+b.length];
		while(left<n && right<m)
		{
			if(a[left] < b[right])
			{
				temp[index] = a[left];
				index++;
				left++;
			}
			else
			{
				temp[index] = b[right];
				index++;
				right++;
			}
		}
		while(left<n)
		{
			temp[index]=a[left];
			index++;
			left++;
		}
		while(right<m)
		{
			temp[index]=b[right];
			index++;
			right++;
		}
		System.out.print(Arrays.toString(temp));
	}
	
	public static void main(String[] args)
	{
		int a[] = {1,2,3,4,5};
		int b[] = {1,3,5,7,9};
		merge(a,b);
		
	}

}
