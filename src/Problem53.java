public class Problem53 {
    public String solve() {
        int[] nums = new int[]{5,4,-1,7,8};
        return String.valueOf(maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int cost = 0;
        int maxSum = sum;
        for (int r = 1; r < nums.length; r++) {
            cost += nums[r - 1];
            sum += nums[r];
            if (cost <= 0) {
                sum = nums[r];
                cost = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
