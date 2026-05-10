package ALL_PGMS;

import java.util.Arrays;
import java.util.*;

public class Pascals_Triangle {
	public static List<List<Integer>> pascal(int num)
	{
		List<List<Integer>> result = new ArrayList<>();
		if(num==0)
			return result;
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		result.add(firstRow);
		
		for(int i=1;i<num;i++)
		{
			List<Integer> prev = result.get(i-1);
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for(int j=0;j<i-1;j++)
			{
				row.add(prev.get(j)+prev.get(j+1));
			}
			row.add(1);
			result.add(row);
		}
		
		return result;			
	}
	 public static int[][] pascal1(int N) {
	        int ans[][] = new int[N][];
	        if(N==0)
	            return ans;

	        ans[0]=new int[]{1};//ans[0][0]=1;
	        
	        for(int i=1;i<N;i++)
	        {
	            int prev[] = new int[i+1];
	            prev[0]=1;
	            prev[i]=1;
	            for(int j=1;j<i;j++)
	            {
	                prev[j]=ans[i-1][j]+ans[i-1][j-1];
	            }
	            ans[i]=prev;
	        }
	        return ans;
	    }
	 public static long nCr(int n,int r)
	 {
		 long ans=1;
		 for(int i=0;i<r;i++)
		 {
			 ans=ans*(n-i);
			 ans=ans/(i+1);
			 System.out.print(ans);
		 }
		 return ans;
	 }
	public static void main(String[] args)
	{
		List<List<Integer>> ans = pascal(5);
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
        System.out.print("\n"+""+nCr(5,2));
        
		int[][] result = pascal1(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
	}

}
