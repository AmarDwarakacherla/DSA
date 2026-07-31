package ALL_PGMS.Strings;

public class ATOI {
	public static int atoi(String s)
	{
		String t = "";
		int i=0;
		if(s.charAt(0)=='-')
		{
			t=t+s.charAt(0);
			i=1;
		}
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                t = t + s.charAt(i);
            } else {
                break;
            }
        }
        if (t.isEmpty()) {
            return 0; 
        }
        int x = Integer.parseInt(t);
        return x;
	}
	public static void main(String[] args)
	{
		System.out.print(atoi("-245ame25"));
	}

}
