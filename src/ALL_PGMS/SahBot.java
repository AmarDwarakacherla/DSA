package ALL_PGMS;

public class SahBot {
	public static String ans(String s)
	{
		int c=0;
		StringBuilder str = new StringBuilder();
		c=1;
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{
				c++;
			}
			else
			{
				str.append(s.charAt(i));
				str.append(c);
				c=1;
			}
		}
		 str.append(s.charAt(s.length() - 1));
		 str.append(c);
		return str.toString();
	}
    public static void main(String[] args) {
    	System.out.print(ans("aaaabba"));
////        String[] a = {"Apple", "Amar", "Banana"};
////        for (int i = 0; i < a.length; i++) {
////            for (int j = i + 1; j < a.length; j++) {
////                if (a[i].compareTo(a[j]) > 0) {
////                    String temp = a[i];
////                    a[i] = a[j];
////                    a[j] = temp;
////                }
////            }
////        }
////        for (String s : a) {
////            System.out.println(s);
////        }
//    	int a[] = {3,2,1,7,5,4};
////    	System.out.print(find(a));
    	
    }
}



