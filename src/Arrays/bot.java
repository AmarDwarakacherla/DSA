package Arrays;

public class bot {
	public static int Approach1(int[] arr)
	{
		int maxsum = 0, sum = 0;
		int start = 0, end = 0, tempstart = 0;
		for(int i=0;i<arr.length;i++)
		{
			sum = 0;
			tempstart = i;
			for(int j=i;j<arr.length;j++)
			{
				sum += arr[j];
				if(sum > maxsum)
				{
					maxsum = sum;
					start = tempstart;
					end = j;
				}
			}
		}
		for(int i=start;i<=end;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		return maxsum;
	}
	public static int Approach2(int[] arr)
	{
		int sum = 0, maxsum = 0;
		for(int i=0;i<arr.length;i++)
		{
			sum = Math.max(arr[i], sum+arr[i]);
			maxsum = Math.max(sum, maxsum);
		}
		return maxsum;
	}
	public static void main(String[] args)
	{
		int arr[] = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.print(Approach1(arr));
		System.out.print(Approach2(arr));
		
		
	}

}
