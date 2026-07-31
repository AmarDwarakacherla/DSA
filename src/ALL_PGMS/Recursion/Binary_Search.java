package ALL_PGMS.Recursion;

public class Binary_Search {

	public static int search(int[] a,int key,int start,int end)
	{
		if(start>end)
			return -1;
		int mid = start+(end-start)/2;
		if(a[mid]==key)
			return mid;
		if(a[mid]>key)
			return search(a,key,start,mid-1);
		return search(a,key,mid+1,end);
	}
	public static void main(String[] args)
	{
		int a[]= {1,2,3,5,7,20,25};
		int key = 25;
		int i = search(a,key,0,a.length-1);
		System.out.print(i);
	}
}
