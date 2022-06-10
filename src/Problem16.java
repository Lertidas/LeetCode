import java.util.Arrays;

public class Problem16 {
    public String solve() {
        int[] input = new int[]{1,1,1,1};
        int target = 0;
        return Integer.toString(threeSumClosest(input, target));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int absDist = Integer.MAX_VALUE;
        int bestSum = 0;
        for (int a = 0; a < nums.length - 2; a++) {
            int val = nums[a];
            int l = a + 1;
            int r = nums.length - 1;
            int sum;
            int dist;
            while (l < r) {
                sum = nums[l] + nums[r] + val;
                dist = target - sum;
                if (Math.abs(dist) < absDist) {
                    absDist = Math.abs(dist);
                    bestSum = sum;
                }
                if (dist > 0) {
                    l += 1;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l += 1;
                    }
                }
                else {
                    r -= 1;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r -= 1;
                    }
                }
            }
        }
        return bestSum;
    }
}
