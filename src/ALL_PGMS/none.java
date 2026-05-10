package ALL_PGMS;

public class none {
	public static void main(String[] args)
	{
		int count = 0;
		int t=0;
		int temp,rem;
		for(int i=100;i<=200;i++)
		{
			temp=i;
			t=0;
			while(temp!=0)
			{
				rem = temp%10;
				if(!(rem==4 || rem==9 || rem==1))
				{
					t=1;
					break;
				}
				temp=temp/10;
			}
			if(t==0)
				count++;
			
		}
		System.out.print(count);
	}
}
