package ALL_PGMS.Recursion;

public class Linear_Search {
	public static int search(int a[],int key,int index)
	{
		if(a.length<=index)
			return -1;
		if(a[index]==key)
			return index;
		return search(a,key,index+1);
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,4,5,7,8,10};
		int key=10;
		int index = search(a,key,0);
		if(index!=-1)
			System.out.print(key+"="+index);
		else
			System.out.print("Not found");
	}

}
