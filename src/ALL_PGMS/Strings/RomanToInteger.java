package ALL_PGMS.Strings;
import java.util.*;

public class RomanToInteger {
	public static int romantoint(String s)
	{
		HashMap<Character,Integer> m = new HashMap<>();
		m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
        	if(i<s.length()-1 && m.get(s.charAt(i))<m.get(s.charAt(i+1)))
        	{
        		ans-=m.get(s.charAt(i));
        		System.out.println(m.get(s.charAt(i)));
        	}
        	else
        	{
        		ans+=m.get(s.charAt(i));
        		System.out.println(m.get(s.charAt(i)));
        	}
        }
		return ans;
	}
	public static int easy(String s)
	{
		int ans=0,num=0;
		for(int i=s.length()-1;i>=0;i--)
		{
			switch(s.charAt(i))
			{
			case 'I': num = 1; break;
            case 'V': num = 5; break;
            case 'X': num = 10; break;
            case 'L': num = 50; break;
            case 'C': num = 100; break;
            case 'D': num = 500; break;
            case 'M': num = 1000; break;
			}
			if(4*num<ans)
				ans-=num;
			else
				ans+=num;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		System.out.print(romantoint("XIV"));
		System.out.print(easy("XIV"));
	}

}
