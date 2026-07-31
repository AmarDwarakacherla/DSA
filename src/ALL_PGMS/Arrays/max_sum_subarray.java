package ALL_PGMS.Arrays;

public class max_sum_subarray {
	public static void main(String[] args)
	{
		int a[]= {-2,-5,6,-1,-3};
		System.out.print(one(a));
	}
	public static int one(int[] a)
	{
		int max=0;
		for(int i=0;i<a.length;i++)
		{
			int csum=0;
			for(int j=i;j<a.length;j++)
			{
				csum+=a[j];
				if(max<csum)
					max=csum;
			}
			
		}
		return max;
	}
	private static int maxsubarray(int[] a) {
		int max=a[0];
		int cmax=a[0];
		for(int i=1;i<a.length;i++)
		{
			cmax=Math.max(a[i],a[i]+cmax);
			max=Math.max(max, cmax);
		}
		return max;
	}
}
