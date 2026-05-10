package ALL_PGMS.Arrays;
import java.util.*;

public class Rotate_Image {
	public static void rotate1(int[][] a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(a[i]));
		//transpose 
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int t=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=t;
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(a[i]));
		//rotate row
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int t=a[i][j];
				a[i][j]=a[i][n-j-1];
				a[i][n-j-1]=t;
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(a[i]));
	}
	
	
	public static void rotate2(int[][] a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(a[i]));
		for(int i=0;i<(n+1)/2;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				//t =bottom left
				int t=a[n-1-j][i];
				//bottom left = bottom right
				a[n-j-1][i] = a[n-i-1][n-j-1];
				//bottom right = top right;
				a[n-i-1][n-j-1] = a[j][n-i-1];
				//top right = top left
				a[j][n-i-1] = a[i][j];
				//top left = t
				a[i][j] = t;
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(a[i]));
	}
	public static void main(String[] args)
	{
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		rotate2(a);
		
	}

}
