package ALL_PGMS.practice;

public class HackerRank2 {
	public static String stringReplace(String s,String substr)
	{
		char ch[] = s.toCharArray();
		StringBuilder str = new StringBuilder();
		int t = 0;
		for(char c : ch)
		{
			if(c=='?')
			{
				if(t<substr.length())
				{
					str.append(substr.charAt(t));
					t++;
				}
				else
					str.append('a');
			}
			else if(t<substr.length() && c==substr.charAt(t))
			{
				str.append(c);
				t++;
			}
			else
				str.append(c);
		}
		return str.toString();
	}
	public static void main(String[] args) {
		String s= new String("??c????er");
		String substr = new String("deciph");
		System.out.print(stringReplace(s,substr));
		

	}

}
