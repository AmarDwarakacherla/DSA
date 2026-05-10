package ALL_PGMS.Strings;

public class Freq_Sort_Character {
	public static String freqSort(String s)
	{
		char[] ch = s.toCharArray();
		int[] count =new int[127];
		for(char i:ch)
			count[i]++;
		for(int pos=0;pos<ch.length;)
		{
			int max = 0;
			for(int i=0;i<count.length;i++)
				if(count[i]>count[max])
					max=i;
			while(count[max]-- > 0)
				ch[pos++]=(char)max;
				
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		String word = "amarm";
		System.out.print(freqSort(word));
//		System.out.print("Ame");
	}
}
