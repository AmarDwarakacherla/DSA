package ALL_PGMS.Arrays;

import java.util.Arrays;

public class Remove_Duplicate_Numbers {
	public static int[] unique(int nums[])
	{
		int i=0;
		int x=0;
		for(int j=1;j<nums.length;j++)
		{
			if(nums[i]!=nums[j])
			{
				i++;x++;
				nums[i]=nums[j];
				
				
			}
		}
		int t[] = new int[x+1];
		for(int j=0;j<=x;j++)
		{
			
			t[j]=nums[j];
		}
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] {1,1,1,2,2,3};
		int a[] = unique(nums);
		System.out.print(Arrays.toString(a));
	}

}
