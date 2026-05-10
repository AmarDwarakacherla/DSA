package ALL_PGMS.practice;
import java.util.*;
public class trash {
	
	public static int min_operations(int[] arr)
	{
		Map<Integer,Integer> freq = new HashMap<>();
		for(int i: arr)
			freq.put(i, freq.getOrDefault(i, 0)+1);
		int op = 0;
//		Iterator it = freq.entrySet().iterator();
//		while(it.hasNext())
		for(Map.Entry<Integer, Integer> entry : freq.entrySet())
		{
			int num = entry.getKey();
			int count = entry.getValue();
			if(num > count)
				op++;
			else if(count > num)
				op++;
		}
		return op;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 2, 3, 3, 4};
        int result = min_operations(arr);
        System.out.println("Minimum operations required: " + result);

	}

}
