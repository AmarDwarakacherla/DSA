package ALL_PGMS.Arrays;
import java.util.*;
public class length_longest_subsequence {
	public static int  longest_Subsequence(int a[])
	{
		int maxlen = 0;
		for(int i=0;i<a.length;i++)
		{
			ArrayList<Integer> t = new ArrayList<>();
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
					t.add(a[j]);
			}
			if(maxlen<t.size())
			{
				maxlen = t.size();
				System.out.print(t);
			}
		}
		return maxlen;
	}
	public static void main(String[] args) {
		int[] a = {3,4,-1,0,6,2,3};
		System.out.print(longest_Subsequence(a));
	}
}
