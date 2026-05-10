package ALL_PGMS.Arrays;

import java.util.*;

public class Set_Matrix_Zeros {
	public static int[][] one(int[][] a)
	{
		HashSet<Integer> row = new HashSet<>();
		HashSet<Integer> col = new HashSet<>();
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]==0)
				{
					row.add(i);
					col.add(j);
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(row.contains(i)||col.contains(j))
					a[i][j]=0;
					
			}
		}
//		for(int r:row)
//		{
//			for(int j=0;j<a[0].length;j++)
//			{
//				a[r][j]=0;
//			}
//		}
//		for(int c:col)
//		{
//			for(int i=0;i<a.length;i++)
//			{
//				a[i][c]=0;
//			}
//		}
		return a;
	}
	
	
	
	public static int[][] two(int[][] a)
	{
		int[] row = new int[a.length];
		int[] col = new int[a[0].length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(a[i][j]==0)
				{
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(row[i]==1 || col[j]==1)
				{
					a[i][j]=0;
				}
			}
		}
		return a;
	}
	
	public static int[][] three(int[][] a)
	{
		boolean row=false,col=false;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(a[i][j]==0)
				{
					if(i==0) row =true;
					if(j==0) col = true;
					a[i][0] = 0;
					a[0][j] = 0;
				}
			}
		}
		for(int i=1;i<a.length;i++)
		{
			for(int j=1;j<a[0].length;j++)
			{
				if(a[i][0] == 0 || a[0][j]==0)
					a[i][j]=0;
			}
		}
		if(row)
		{
			for(int i=0;i<a[0].length;i++)
				a[0][i]=0;
				
		}
		if(col)
		{
			for(int j=0;j<a.length;j++)
				a[j][0]=0;
		}
		return a;
	}
	public static void main(String[] args)
	{
		int a[][]= {{0,2,3,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int[][] result = one(a);
		for(int i=0;i<result.length;i++)
		{
			System.out.println(Arrays.toString(result[i]));
		}
	}

}
