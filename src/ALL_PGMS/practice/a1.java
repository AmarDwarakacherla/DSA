package ALL_PGMS.practice;
import java.util.*;
public class a1 {
	public static void main(String[] args)
	{
		int arr[] = new int[] {2,4,1,3,5};
		ArrayList<ArrayList<Integer>> t = new ArrayList<>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					t.add(new ArrayList<>(Arrays.asList(arr[i],arr[j])));
				}
			}
		}
		System.out.print(t);
	}
}
