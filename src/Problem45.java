public class Problem45 {
    public String solve() {
        int[] nums = new int[]{1, 2, 3};
        return String.valueOf(jump(nums));
    }
    public int jump(int[] nums) {
        int jumps = 0;
        int pos = 0;
        int[] points = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            points[i] = nums[i] + i;
        }
        // Iterate over points to make choice
        while (true) {
            // Return if in reach of end
            if (pos == nums.length - 1) {
                return jumps;
            }
            else if (pos + nums[pos] >= nums.length - 1) {
                return jumps + 1;
            }
            // Options
            int maxVal = 0;
            int nexPos = pos;
            for (int i = 1; i <= nums[pos]; i++) {
                if (points[pos + i] >= maxVal) {
                    maxVal = points[pos + i];
                    nexPos = pos + i;
                }
            }
            pos = nexPos;
            jumps += 1;
        }
    }
}
