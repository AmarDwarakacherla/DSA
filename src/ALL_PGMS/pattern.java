package ALL_PGMS;

public class pattern {

	public static void main(String[] args) {
		int n =5;
		for(int i=0;i<n*2-1;i++)
		{
			for(int j=0;j<n*2-1;j++)
			{
				int top = i;
				int bottom = j;
				int left = (n*2-2)-i;
				int right = (n*2-2)-j;
				System.out.print(n-(Math.min(Math.min(left, right), Math.min(top, bottom))));
				
			}
			System.out.println();
		}

	}

}
