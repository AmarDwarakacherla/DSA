package SWITCH;

public class Valid_Palindrome {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalinSentApproach2(s));
    }

    public static boolean isPalinSentApproach1(String s) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch > 'A' && ch < 'Z' || ch > 'a' && ch < 'z') {
                str.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder rev = new StringBuilder(str);
        rev.reverse();
        return str.toString().equals(rev.toString());
    }

    public static boolean isPalinSentApproach2(String s) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        String res = str.toString();
        int start = 0, end = str.length()-1;
        while(start < end){
            if(res.charAt(start)!=res.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }
}
