public class Problem33 {
    public String solve() {
        int[] input = new int[]{1, 3};
        int target = 0;
        return Integer.toString(search(input, target));
    }
    public int search(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        return binSearch(nums, target, 0, nums.length - 1);
    }
    private int binSearch(int[] nums, int target, int l, int r) {
        // Check for strange cases
        if (l >= r) {
            if (nums[r] == target) {
                return r;
            }
            else {
                return -1;
            }
        }
        int midpoint = l + ((r - l + 1) / 2);
        int val = nums[midpoint];
        if (val == target) {
            return l + ((r - l + 1) / 2);
        }
        // Case where middle is greater than left
        else if (nums[0] < val) {
            if (target > nums[0] && target < val) {
                return binSearch(nums, target, l, midpoint - 1);
            }
            else {
                return binSearch(nums, target, midpoint + 1, r);
            }
        }
        // Case where left is greater than middle
        else {
            if (target > val && target < nums[0]) {
                return binSearch(nums, target, midpoint + 1, r);
            }
            else {
                return binSearch(nums, target, l, midpoint - 1);
            }
        }
    }
}
