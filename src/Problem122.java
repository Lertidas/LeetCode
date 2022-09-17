public class Problem122 implements Problem{
    @Override
    public String solve() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        return String.valueOf(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
