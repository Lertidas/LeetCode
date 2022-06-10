import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    public String solve() {
        return Arrays.toString(twoSum(new int[]{3, 2, 4}, 6));
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashMap.containsKey(difference) && hashMap.get(difference) != i) {
                return new int[]{i, hashMap.get(difference)};
            }
        }
        return new int[]{};
    }
}
