package SWITCH;

public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfitApproach1(prices));
        System.out.println(maxProfitApproach2(prices));
    }
    public static int maxProfitApproach1(int[] prices) {
        int result = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                result = Math.max(result, prices[j]-prices[i]);
            }
        }
        return result;
    }
    public static int maxProfitApproach2(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
