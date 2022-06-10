public class Problem26 {
    public String solve() {
        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        return Integer.toString(removeDuplicates(input));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k += 1;
            }
        }
        return k;
    }
}
