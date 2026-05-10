package ALL_PGMS.Arrays;

import java.util.Arrays;

public class Sorting {
	static void SelectionSort(int a[])
	{
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;
			for(int j=i;j<a.length;j++)
			{
				if(a[j]<a[min])
					min=j;
			}
			int t=a[min];
			a[min]=a[i];
			a[i]=t;
		}
	}
	public static void main(String[] args)
	{
		int a[]= {1,23,4,5,7,9};
		SelectionSort(a);
		System.out.print(Arrays.toString(a));
	}

}
