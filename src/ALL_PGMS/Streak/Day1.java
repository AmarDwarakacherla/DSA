package ALL_PGMS.Streak;
import java.util.*;
public class Day1 {
	public static int[] unique(int arr[])
	{
		ArrayList<Integer> t = new ArrayList<>();
		for(int i=0;i<arr.length;i++)
		{
			if(i<arr.length-1 && arr[i]==arr[i+1])
				continue;
			else
				t.add(arr[i]);
		}
		
		int[] result = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            result[i] = t.get(i);
        }
        return result;
	}
	public static int[] uniquearray(int arr[])
	{
		Set<Integer> t = new HashSet<>();
		for(int i:arr)
			t.add(i);
		int[] result = new int[t.size()];
        int i = 0;
        for (int num : t) {
            result[i++] = num;
        }
        return result;
	}
	public static void main(String[] args)
	{
		int arr[] = new int[] {1,1,2,2,2,3,3,4,4,5,5,5,6};
		int t[] = unique(arr);
		System.out.println(Arrays.toString(t));
		int temp[] = uniquearray(arr);
		System.out.print(Arrays.toString(temp));
	}
}