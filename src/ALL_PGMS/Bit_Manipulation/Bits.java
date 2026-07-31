package ALL_PGMS.Bit_Manipulation;

public class Bits {
	static int CountSetBits(int n)
	{
	
		int c=0;
		while(n!=0)
		{
			n=n&(n-1);
			c++;
		}
		return c;
	}
	static int FindRightMostSetBit(int n)
	{
//		return (int) (Math.log10(n ^ (n &(n-1)))/Math.log10(2))+1;
		
		int mask=1;
		if(n==-1)
			return -1;
		int pos=0;
		while((n & mask) ==0)
		{
			mask=mask<<1;
			pos++;
		}
		return pos+1;
	}
	static boolean PowerOf2(int n)
	{
		if(n==0)
			return false;
		return (n&(n-1))==0;
		
	}
	static int CountConsecutiveOnes(int n)
	{
		int count=0;
		while(n>0)
		{
			n = n & (n<<1);
			count++;
		}
		return count;
	}
	static int SwapEvenOddBits(int n)
	{
		return ((n & 0xaaaaaaaa)>>>1 | (n & 0x55555555)<<1);
	}
	public static void main(String[] args)
	{
		System.out.print(SwapEvenOddBits(181));
	}
		

}
