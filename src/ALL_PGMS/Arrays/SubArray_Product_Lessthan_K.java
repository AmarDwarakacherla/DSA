package ALL_PGMS.Arrays;

public class SubArray_Product_Lessthan_K {
	public static void main(String[] args)
	{
		int nums[] = new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		int k = 19;
		System.out.print(printCount(nums,k));
	}

	private static int  printSubArrayCount(int[] nums, int k) {
		long product = 1;
		int count=0;
		for(int i=0;i<nums.length;i++)
		{
			product = 1;
			for(int j=i;j<nums.length;j++)
			{
				product *= nums[j];
				if(product<k)
					count++;
			}
		}
		return count;
	}
	private static int printCount(int[] nums,int k)
	{
		int n =  nums.length;
		int start = 0;
		int end = 0;
		int product = 1;
		int ans=0;
		while(end<n)
		{
			product *= nums[end];
			while(product>=k && start<=end)
			{
				product /= nums[start];
				start++;
			}
			ans += end-start+1;
			
			end++;
			
		}
		return ans;
	}
}
