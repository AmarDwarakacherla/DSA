package ALL_PGMS.Sorting;
import java.util.*;
public class InsertionSort {
	public static void main(String[] args)
	{
		int a[] =new int[] {23,1,5,76,2,3};
		int min=0;
		int t=0;
		for(int i=0;i<a.length;i++)
		{
			min=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[min]>a[j])
					min=j;
			}
			t=a[i];
			a[i]=a[min];
			a[min]=t;
			
		}
		System.out.print(Arrays.toString(a));
	}

}
