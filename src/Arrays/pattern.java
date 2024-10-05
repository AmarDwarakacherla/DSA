package Arrays;

public class pattern {
	public static void main(String[] args)
	{
		int n = 5;
		for(int i=0;i<=n;i++)
		{
			for(int sp=0;sp<n-i;sp++)
			{
				System.out.print(" ");
			}
			int t = 65;
			for(int j=0;j<i;j++)
			{
				
				char ch = (char)(t);
				System.out.print(ch+" ");
				t++;
			}
			System.out.println();
		}
	}

}
