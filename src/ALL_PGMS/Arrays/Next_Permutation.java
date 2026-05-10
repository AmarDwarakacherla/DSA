package ALL_PGMS.Arrays;

import java.util.Arrays;

public class Next_Permutation {
	 public static void nextPermutation(int[] nums) 
	 {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j=nums.length-1;
            while(j>=0 && nums[j]<=nums[i])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1); 
    }
    public static void swap(int[] a,int i,int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void reverse(int[] a,int start)
    {
        int end=a.length-1;
        while(start<end)
        {
            swap(a,start,end);
            start++;
            end--;
        }
    }
	public static void main(String[] args)
	{
		int a[] = {1,2,3};
		nextPermutation(a);
		System.out.print(Arrays.toString(a));
	}

}
