import java.util.Arrays;

public class Problem34 {
    public String solve() {
        int[] nums = new int[]{};
        int target = 0;
        return Arrays.toString(searchRange(nums, target));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int[] results = findTarget(nums, target, 0, nums.length - 1);
        if (results != null) {
            int left = findLeft(nums, target, results[1], results[0]);
            int right = findRight(nums, target, results[0], results[2]);
            result[0] = left;
            result[1] = right;
        }
        return result;
    }
    public int[] findTarget(int[] nums, int target, int l, int r) {
        int pos = (r + l) / 2;
        if (r < 0 || l >= nums.length) {
            return null;
        }
        if (nums[pos] == target) {
            int[] results = new int[3];
            results[0] = pos;
            results[1] = l;
            results[2] = r;
            return results;
        }
        else if (r == l) {
            return null;
        }
        else if (nums[pos] > target) {
            return findTarget(nums, target, l, pos - 1);
        }
        else {
            return findTarget(nums, target, pos + 1, r);
        }
    }
    private int findRight(int[] nums, int target, int l, int r) {
        int pos = (r + l) / 2;
        if (nums[pos] == target && (pos + 1 >= nums.length || nums[pos + 1] != target)) {
            return pos;
        }
        // Go further left
        else if (nums[pos] != target) {
            return findRight(nums, target, l, pos - 1);
        }
        // Go further right
        else {
            return findRight(nums, target, pos + 1, r);
        }
    }
    private int findLeft(int[] nums, int target, int l, int r) {
        int pos = (r + l) / 2;
        if (nums[pos] == target && (pos - 1 < 0 || nums[pos - 1] != target)) {
            return pos;
        }
        // Go further right
        else if (nums[pos] != target) {
            return findLeft(nums, target, pos + 1, r);
        }
        // Go further left
        else {
            return findLeft(nums, target, l, pos - 1);
        }
    }
}
