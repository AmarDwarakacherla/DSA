package ALL_PGMS.Strings;
import java.util.*;
public class AnagramCheck {
	public static boolean checkAnagram(String a, String b)
	{
		char[] a1 = a.toCharArray();
		Arrays.sort(a1);
		char[] b1 = a.toCharArray();
		Arrays.sort(b1);
		if(a.length()!=b.length())
			return false;
		for(int i=0;i<a1.length;i++)
		{
			if(a1[i]!=b1[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.print(checkAnagram("amar","ama"));
	}
}
