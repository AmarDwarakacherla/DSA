package ALL_PGMS.practice;



public class One {
	
	public void pattern(int n)
	{
		for(int i=n;i>=0;i--)
		{
			for(int sp=0;sp<n-i;sp++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=2;i<=n;i++)
		{
			for(int sp=0;sp<n-i;sp++)
				System.out.print(" ");
			for(int j=0;j<i;j++)
				System.out.print("* ");
			System.out.println();
		}
	}
    public static void main(String[] args) {
        One obj = new One();
        obj.pattern(5);
    }
}
