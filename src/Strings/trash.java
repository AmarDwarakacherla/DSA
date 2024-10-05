package Strings;
import java.util.*;
public class trash {
	public static int equilibrium(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int left = 0;
			int right =0;
			for(int j=0;j<i;j++)
			{
				left+=a[j];
			}
			for(int j=i+1;j<a.length;j++)
			{
				right+=a[j];
			}
			if(left == right)
				return i;
		}
		return -1;
	}
	public static int euilibrium(int[] a)
	{
		int  sum = 0;
        for(int i: a)
            sum+=i;
        int left = 0;
        int  right = sum;
        for(int i=0;i<a.length;i++)
        {
            right-=a[i];
            if(left == right)
                return i;
            left+=a[i];
        }
            
        return -1;
	}
	public static void main(String[] args)
	{
		int a[] = new int[] {0,1,3,-2,-1};
		System.out.print(euilibrium(a));
		
		
	}

}
