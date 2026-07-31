package ALL_PGMS;

import java.util.*;

public class trash {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "aaaaaaaa";
        char[] ch = str.toCharArray();
        int n = str.length();
        StringBuilder a = new StringBuilder();
        HashSet<Character> t = new HashSet<>();
        for(char c:ch)
        	t.add(c);
        

        int r = n % 16;
        if (n < 16) {
        	for (char c : t) {
                a.append(c);
            }
            if (r >= 10 && r <= 15) {
                a.append((char) ('a' + r - 10));
            } else {
                a.append(r);
            }
        } else {
            a.append(Integer.toHexString(n));
        }
//        System.out.println(a.reverse().toString());
        
        
        
        String s1="HelloWorld";
        String s2="Hello";
        String s3="World";
        String s4=s2+s3;
        System.out.print(s4);
        System.out.print(s1.equals(s4));
    }
}
