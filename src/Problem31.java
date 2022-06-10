import java.util.Arrays;

public class Problem31 {
    public String solve() {
        int[] input = new int[]{1, 1, 5};
        nextPermutation(input);
        return Arrays.toString(input);
    }
    public void nextPermutation(int[] nums) {
        if (nums.length >= 2) {
            int prev;
            for (int i = nums.length - 2; i >= 0; i--) {
                prev = i + 1;
                if (nums[i] < nums[prev]) {
                    // Found target value
                    for (int j = nums.length - 1; j > i; j--) {
                        // Found value to swap
                        if (nums[j] > nums[i]) {
                            // Swap initial values
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            // Swap all remaining values
                            for (int k = 0; k < (nums.length - i - 1) / 2; k++) {
                                temp = nums[i + k + 1];
                                nums[i + k + 1] = nums[nums.length - 1 - k];
                                nums[nums.length - 1 - k] = temp;
                            }
                            return;
                        }
                    }
                }
            }
            // Else if in reverse order, reverse order
            // Swap all remaining values
            int temp;
            for (int i = 0; i < nums.length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
    }
}
