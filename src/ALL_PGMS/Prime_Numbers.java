package ALL_PGMS;

import java.util.*;
public class Prime_Numbers {
	public static boolean isprime(int n)
	{
		for(int i=2;i<Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	//time COmplexity
	//O[sqrt(n)(log(log(n))]
	public static HashSet<Integer> seiveprime(int n)
	{
		HashSet<Integer> prime = new HashSet<>();
		for(int i=2;i*i<=n;i++)
		{
			if(isprime(i))
			{
				for(int j=i*i;j<=n;j=j+i)
				{
					prime.add(j);
				}
			}
		}
//		for(int i=2;i<=n;i++)
//		{
//			if(!prime.contains(i))
//				System.out.println(i);
//		}
//		for(int Integer: prime)
//			System.out.print(Integer);
//		
		return prime;
		
	}
	public static void main(String[] args)
	{
		seiveprime(15);
		HashSet<Integer> p = seiveprime(15);
		for(int Integer: p)
			System.out.print("\n"+Integer);
		
	}
}
