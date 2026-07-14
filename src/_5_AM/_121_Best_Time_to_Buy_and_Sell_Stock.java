package _5_AM;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int price : prices){
            min = Math.min(min, price);
            max = Math.max(max, price-min);
        }
        return max;
    }
}
