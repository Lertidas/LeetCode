public class Problem55Revised {
    public String solve() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        return Boolean.toString(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxIndex = 0;
        int index;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex >= nums.length - 1) {
                return true;
            }
            else if (nums[i] == 0 && maxIndex <= i) {
                return false;
            }
            else {
                index = nums[i] + i;
                if (index > maxIndex) {
                    maxIndex = index;
                }
            }
        }
        return true;
    }
}
