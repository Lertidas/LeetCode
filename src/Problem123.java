import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem123 implements Problem{
    @Override
    public String solve() {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        return String.valueOf(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            prices[i] = prices[i + 1] - prices[i];
        }
        List<Integer> profits = new ArrayList<>();
        List<Integer> separators = new ArrayList<>();
        int currentProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < 0) {
                if (currentProfit > 0) {
                    profits.add(currentProfit);
                }
                // Add in separators
                if (profits.size() > 0) {
                    if (currentProfit > 0) {
                        separators.add(prices[i]);
                    }
                    else {
                        separators.set(separators.size() - 1,
                                separators.get(separators.size() - 1) + prices[i]);
                    }
                }
                currentProfit = 0;
            }
            else {
                currentProfit += prices[i];
            }
        }
        if (currentProfit > 0) {
            profits.add(currentProfit);
        }

        // Remove last seperator if equal in size
        if (profits.size() == separators.size()) {
            separators.remove(separators.size() - 1);
        }

        // Merge cases
        mergeCases(profits, separators, 2);

        profits.sort(Collections.reverseOrder());

        // Get max profit
        int k = Math.min(2, profits.size());
        int maxProfit = 0;
        for (int i = 0; i < k; i++) {
            maxProfit += profits.get(i);
        }
        return maxProfit;
    }
    private void mergeCases(List<Integer> profits, List<Integer> separators, int k) {
        int merges = profits.size() - k;
        if (merges > 0) {
            // Update separators
            for (int i = 0; i < separators.size(); i++) {
                separators.set(i,
                        separators.get(i) + profits.get(i) + profits.get(i + 1));
            }
            // Sort list
            separators.sort(Collections.reverseOrder());
        }
    }
}
