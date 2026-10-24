package Months.Oct_2026;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("" ,n , res);
        return res;
    }
    public static void generate(String str, int n, List<String> res){
        if(str.length() == 2*n){
            if(isValid(str)){
                res.add(str);
            }
            return;
        }
        generate(str + "(" , n ,res);

        generate(str + ")" ,n , res);
    }
    public static boolean isValid(String str){
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch == '(')
                count++;
            else if(ch == ')')
                count--;
            if(count < 0) return false;
        }

        return count == 0;
    }
}
