public class Problem27 {
    public String solve() {
        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        int val = 0;
        return Integer.toString(removeElement(input, val));
    }
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i - k] = nums[i];
            if (nums[i] == val) {
                k += 1;
            }
        }
        return nums.length - k;
    }
}
