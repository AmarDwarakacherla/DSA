package ALL_PGMS.Recursion;
import java.util.*;
public class Fibonacci_Series {
	public static int fib(int n)
	{
		if(n==0)
		{
			System.out.println(0);
			return 0;
		}
		if(n==1)
		{
			System.out.println(1);
			return 1;
		}
		System.out.println(fib(n-1)+fib(n-2));
		return fib(n-1)+fib(n-2);
	}
	public static void  main(String[] args)
	{
		int n=4;
		ArrayList<Integer> t = new ArrayList<>();
		for(int i=0;i<n;i++)
			t.add(fib(i));
		System.out.print(t);
	}

}
