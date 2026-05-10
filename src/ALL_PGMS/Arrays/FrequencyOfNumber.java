package ALL_PGMS.Arrays;


import java.util.HashMap;
import java.util.Map;

public class FrequencyOfNumber {
	
	public static void main(String[] args)
	{
		int a[] =new int[] {1,1,4,5,7,7,5,4,3,1,1,7};
		int freq[] =  new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			int count =1;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					count++;
					freq[j]=-1;
				}
			}
			if(freq[i]!=-1)
				freq[i]=count;
		}
		for(int i=0;i<freq.length;i++)
		{
			if(freq[i]!=-1)
			{
				System.out.println(a[i]+" :"+freq[i]);
			}
		}
		
		
		
		HashMap<Integer,Integer> set = new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			if(set.containsKey(a[i]))
			{
				set.put(a[i],set.get(a[i])+1);
			}
			else
			{
				set.put(a[i],1);
			}
		}
		for(Map.Entry entry:set.entrySet())
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
