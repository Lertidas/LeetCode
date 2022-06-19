import java.util.Arrays;

public class Problem35 {
    public String solve() {
        int[] nums = new int[]{1,3};
        int target = 4;
        return Integer.toString(searchInsert(nums, target));
    }
    public int searchInsert(int[] nums, int target) {
        return findInsert(nums, target, 0, nums.length - 1);
    }
    public int findInsert(int[] nums, int target, int l, int r) {
        int pos = (r + l + 1) / 2;
        if (r < 0 || l >= nums.length) {
            return 0;
        }
        // Cases where on border
        if (pos - 1 < 0) {
            if (target <= nums[pos]) {
                return pos;
            }
            else {
                return pos + 1;
            }
        }
        else if (pos == nums.length - 1) {
            if (nums[pos - 1] < target && target <= nums[pos]) {
                return pos;
            }
            else if (nums[pos - 1] == target) {
                return pos - 1;
            }
            else if (r - l == 1 && target < nums[pos - 1]) {
                return pos - 1;
            }
            else if (target < nums[pos]){
                return findInsert(nums, target, l, pos);
            }
            else {
                return nums.length;
            }
        }
        else if (pos == 1) {
            if (nums[pos - 1] < target && target <= nums[pos]) {
                return pos;
            }
            else if (nums[pos - 1] == target) {
                return 0;
            }
            else if (target < nums[pos - 1]){
                return 0;
            }
            else {
                return findInsert(nums, target, pos, r);
            }
        }
        // Standard case
        else {
            if (nums[pos - 1] < target && target <= nums[pos]) {
                return pos;
            }
            else if (nums[pos - 1] == target) {
                return pos - 1;
            }
            else if (target < nums[pos]){
                return findInsert(nums, target, l, pos);
            }
            else {
                return findInsert(nums, target, pos, r);
            }
        }
    }
}
