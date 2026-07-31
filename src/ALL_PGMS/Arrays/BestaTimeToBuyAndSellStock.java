package ALL_PGMS.Arrays;

public class BestaTimeToBuyAndSellStock {
	public static int one(int[] a)
	{
		int maxprofit = 0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]>a[i])
				{
					maxprofit = Math.max(a[j]-a[i], maxprofit);
				}
			}
		}
		return maxprofit;
	}
	public static int two(int[] a)
	{
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<min)
				min=a[i];
			profit = Math.max(a[i]-min, profit);
		}
		return profit;
	}
	public static void main(String[] args)
	{
		int[] a = {7,1,5,3,6,4};
		System.out.print(one(a));
		System.out.print(two(a));
	}

}
