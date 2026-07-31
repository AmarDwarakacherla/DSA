package ALL_PGMS.Arrays;

public class Rotate_Array_Left_OR_Right {
	public static void rotate(int[] arr,int k)
	{
		if(arr.length==0)
			return;
		if(k>arr.length)
			return;
		
		reverse(arr,0,arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
	}
	public static void reverse(int[] arr,int start,int end)
	{
		int t=0;
		while(start<=end)
		{
			t=arr[start];
			arr[start]=arr[end];
			arr[end]=t;
			start++;end--;
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[]{3,7,8,9,10,11};
		int k = 3;
		rotate(arr,k);
		for(int i:arr)
			System.out.print(i);
		

	}

}
