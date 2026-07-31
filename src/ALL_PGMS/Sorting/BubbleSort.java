package ALL_PGMS.Sorting;
import java.util.*;
public class BubbleSort {
	public static void main(String[] args)
	{
		int a[] = new int[]{1,2,37,8,9,0};
		int t=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
		}
		System.out.print(Arrays.toString(a));
	}
}
