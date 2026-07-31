package ALL_PGMS.Arrays;

public class Kth_Missing_Number {
	public static int miss_linear(int[] a,int k)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<=k) k++;
			else break;
		}
		return k;
	}
	public static int miss_Binary(int[] a,int k)
	{
		int low=0,high=a.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			int miss=a[mid]-(mid+1);
			if(miss<k)
				low=mid+1;
			else
				high=mid-1;
		}
		return k+high+1;
	}
	public static void main(String[] args) {
		int a[]= {1,3,5,7};
		System.out.print(miss_linear(a,7));
	}
}
