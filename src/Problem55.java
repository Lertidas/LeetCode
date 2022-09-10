import java.util.ArrayList;
import java.util.List;

public class Problem55 {
    public String solve() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        return Boolean.toString(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        else if (nums[0] == 0) {
            return false;
        }
        List<Integer> zeroes = new ArrayList<>();
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroes.add(i);
            }
            else {
                for (int j = zeroes.size() - 1; j >= 0; j--) {
                    if (nums[i] > zeroes.get(j) - i) {
                        zeroes.remove(j);
                    }
                }
            }
        }
        return zeroes.size() == 0;
    }
}
