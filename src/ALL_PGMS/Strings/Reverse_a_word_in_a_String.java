package ALL_PGMS.Strings;

import java.util.Arrays;

public class Reverse_a_word_in_a_String {
	public static void main(String[] args)
	{
		String name="Amar nath Reddy";
		String[] words=name.split(" ");
		System.out.print(Arrays.toString(words));
		for(int i=0;i<words.length;i++)
		{
			String empty="";
			for(int j=0;j<words[i].length();j++)
			{
				empty=words[i].charAt(j)+empty;
			}
			words[i]=empty;
		}
		System.out.print(Arrays.toString(words));
		String result="";
		for(String i : words)
		{
			result=result+i+" ";
		}
		result=result.trim();
		System.out.print(result);
		
	}
}
