import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15r {
    public String solve() {
        int[] input = new int[]{-1, -1, 0, 1};
        return threeSum(input).toString();
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // Result list
        List<List<Integer>> result = new ArrayList<>();
        // Sort list
        Arrays.sort(nums);
        int l, r;
        List<Integer> values;
        for (int a = 0; a < nums.length - 2; a++) {
            if ((a == 0 || nums[a] != nums[a - 1]) && nums[a] < 1) {
                l = a + 1;
                r = nums.length - 1;
                while (l < r) {
                    int sum = (nums[l] + nums[r]) * -1;
                    // Case when equal
                    if (sum == nums[a]) {
                        values = new ArrayList<>();
                        values.add(nums[a]);
                        values.add(nums[l]);
                        values.add(nums[r]);
                        result.add(values);
                        l += 1;
                        r -= 1;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l += 1;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r -= 1;
                        }
                    }
                    // Case when greater than
                    else if (sum < nums[a]) {
                        r -= 1;
                        while (l < r && nums[r] == nums[r + 1]) {
                            r -= 1;
                        }
                    }
                    // Case when less than
                    else {
                        l += 1;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l += 1;
                        }
                    }
                }
            }
        }
        return result;
    }
}
