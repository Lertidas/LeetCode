import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    public String solve() {
        int[] input = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        return fourSum(input, target).toString();
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int targetAbs = Math.abs(target);
        for (int a = 0; a < nums.length - 3 && nums[a] <= targetAbs; a++) {
            if (a == 0 || nums[a] != nums[a - 1]) {
                for (int b = a + 1; b < nums.length - 2; b++) {
                    if (b == a + 1 || nums[b] != nums[b - 1]) {
                        int l = b + 1;
                        int r = nums.length - 1;
                        while (l < r) {
                            int sum = nums[a] + nums[b] + nums[l] + nums[r];
                            if (sum == target) {
                                List<Integer> lst = new ArrayList<>();
                                lst.add(nums[a]);
                                lst.add(nums[b]);
                                lst.add(nums[l]);
                                lst.add(nums[r]);
                                result.add(lst);
                                l += 1;
                                while (l < r && nums[l] == nums[l - 1]) {
                                    l += 1;
                                }
                                r -= 1;
                                while (l < r && nums[r] == nums[r + 1]) {
                                    r -= 1;
                                }
                            }
                            else if (sum > target) {
                                r -= 1;
                                while (l < r && nums[r] == nums[r + 1]) {
                                    r -= 1;
                                }
                            }
                            else {
                                l += 1;
                                while (l < r && nums[l] == nums[l - 1]) {
                                    l += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
