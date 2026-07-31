package ALL_PGMS.practice;

import java.util.*;
public class bot {
	String name;
	bot()
	{
		
	}
	bot(String name)
	{
		this.name = name;
	}
	void getname()
	{
		System.out.print(name);
	}
	static {
		System.out.print("hello");
	}
	public static void main(String[] args)
	{
		String str = new String("13579");
		char c[] = str.toCharArray();
		boolean t = true;
		while(t)
		{
			t = false;
			for(int i=0;i<c.length-1;i++)
			{
				if(((c[i]-'0')%2)==((c[i+1]-'0')%2))
				{
					if(c[i]<c[i+1])
					{
						char temp = c[i];
						c[i] = c[i+1];
						c[i+1] = temp;
						t = true;
					}
				}
			}
		}
		System.out.print(Arrays.toString(c));
		
		bot b1 = new bot("Amar");
		new bot().getname();
		b1.getname();
		
		
		
	}
}