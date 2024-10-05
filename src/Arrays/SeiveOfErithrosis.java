package Arrays;

public class SeiveOfErithrosis {
	public static boolean findprime(int n, boolean[] isprime)
	{
		isprime[0]=isprime[1]=false;
		for(int i=2;i<=n;i++)
			isprime[i] = true;
		for(int i=2;i*i<=n;i++)
		{
			if(isprime[i]==true)
			{
				for(int j=i*i; j<=n; j+=i)
					isprime[j] = false;
			}
		}
		return isprime[n];
	}
	public static void main(String[] args)
	{
		int n = 15;
		boolean[] isprime = new boolean[n+1];
		System.out.println(findprime(n,isprime));
//		for(boolean i: isprime)
//			System.out.println(i);
		
		for (int i = 0; i < n; i++) { 
            if (isprime[i] && isprime[n - i]) { 
                System.out.print(i + " " + (n - i)); 
                break;
            } 
        } 
	}

}
