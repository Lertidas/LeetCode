import java.util.Arrays;

public class Problem41 {
    public String solve() {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        return String.valueOf(firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        // Eliminate negative values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        // Setup array to -1 and 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                updateValues(i, nums[i], nums);
            }
        }
        // Look through array and find first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    private void updateValues(int i, int val, int[] nums) {
        if (val - 1 == i) {
            nums[i] = -1;
        }
        if (val > 0 && val <= nums.length) {
            int v2 = nums[val - 1];
            if (v2 != -1) {
                nums[val - 1] = -1;
                updateValues(val - 1, v2, nums);
            }
        }
    }
}
