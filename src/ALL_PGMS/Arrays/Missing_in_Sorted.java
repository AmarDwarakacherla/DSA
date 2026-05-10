package ALL_PGMS.Arrays;

public class Missing_in_Sorted {
	public static void main(String[] args)
	{
		int a[]= {1,3,4,5};
		int sum=0;
		for(int i:a)
			sum+=i;
		int n=a.length+1;
		int t=n*(n+1)/2;
		System.out.println(t);
		System.out.print(t-sum);
	}
}
