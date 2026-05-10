package ALL_PGMS.Arrays;
import java.util.*;
public class sam {
	public static boolean Prime(int n)
	{
		if(n<=0)
			return false;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=input.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			boolean t=Prime(arr[i]);
			System.out.println(arr[i]+" "+t);
		}
		
		
	}

}
