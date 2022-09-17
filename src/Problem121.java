public class Problem121 implements Problem{
    @Override
    public String solve() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        return String.valueOf(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price - minVal > maxProfit) {
                maxProfit = price - minVal;
            }
            if (price < minVal) {
                minVal = price;
            }
        }
        return maxProfit;
    }
}
