package ALL_PGMS.Arrays;

public class Second_Maximum {
	public static void main(String[] args)
	{
		int[] a = {1,3,4,1,1,216,19,17};
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max1)
			{
				max2=max1;
				max1=a[i];
			}
			else if(a[i]>max2 && a[i]!=max1)
			{
				max2=a[i];
			}
		}
		System.out.print(max1 +" "+max2);
	}
}
