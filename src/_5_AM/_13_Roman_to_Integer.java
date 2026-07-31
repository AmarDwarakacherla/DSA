package _5_AM;

import java.util.HashMap;
import java.util.Map;

public class _13_Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(new _13_Roman_to_Integer().romanToInt("IV"));
        System.out.println(romanToIntApproach2("IV"));
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res -= map.get(s.charAt(i));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(s.length()-1));
        return res;

    }
    public static int romanToIntApproach2(String s) {
        int res = 0;
        for(int i=0;i<s.length()-1;i++){
            int curr = value(s.charAt(i));
            int next = value(s.charAt(i+1));
            if(curr<next){
                res -= curr;
            }else{
                res += curr;
            }
        }
        res += value(s.charAt(s.length()-1));
        return res;
    }
    private static int value(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}
