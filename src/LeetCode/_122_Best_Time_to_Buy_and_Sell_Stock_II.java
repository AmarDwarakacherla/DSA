package LeetCode;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        System.out.println(maxProfitApproach2(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfitApproach1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static int maxProfitApproach2(int[] prices) {
        int profit = 0, i = 0, n = prices.length, buy = 0, sell = 0;
        while(i<n-1){
            //to find the buying price
            while(i<n-1 && prices[i]>=prices[i+1]){
                i++;
            }
            buy = prices[i];
            //to find the selling price
            while(i<n-1 && prices[i]<=prices[i+1]){
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;

    }
}

