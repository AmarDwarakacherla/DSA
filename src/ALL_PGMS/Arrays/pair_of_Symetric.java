package ALL_PGMS.Arrays;
import java.util.*;
public class pair_of_Symetric {
	public static int[][] findpairs(int[][] arr)
	{
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer,Integer> store = new HashMap<>();
		for(int[] n: arr)
		{
			int first = n[0], second = n[1];
			if(store.containsKey(second) && store.get(second)==first)
			{
				res.add(Arrays.asList(second, first));
                res.add(Arrays.asList(first, second));
			}
			else
			{
				store.put(first, second);
			}		
		}
		int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
        	result[i][0] = res.get(i).get(0);
        	result[i][1] = res.get(i).get(1);
        }
		return result;
	}

	public static void main(String[] args) {
		int arr[][] = new int[][] {{3, 4}, {1, 2}, {6,10},{5, 2}, {6,2},{7, 10}, {4, 3}, {2, 5},{3,2}};
		int t[][] = findpairs(arr);
		for(int[] n: t)
		{
			System.out.print(Arrays.toString(n)+" ");
		}

	}

}
