package GeeksForGeeks;

public class Check_if_All_Bits_Set {
    public static void main(String[] args) {
        System.out.println(isBitSet(6));
    }
    public static boolean isBitSet(int n) {
        // code here
        if(n == 0) return false;
        return (n & (n+1)) == 0;
    }
}
