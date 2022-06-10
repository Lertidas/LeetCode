import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem15 {
    public String solve() {
        int[] input = new int[]{};
        return threeSum(input).toString();
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> set = new HashMap<>();
        HashSet<String> used = new HashSet<>();
        // Add nums to HashMap containing index
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        // Check for all two sum combinations
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = (nums[i] + nums[j]) * -1;
                if (set.containsKey(sum) && set.get(sum) != i && set.get(sum) != j) {
                    String sForm = toStringForm(nums[i], nums[j], sum);
                    if (!used.contains(sForm)) {
                        used.add(sForm);
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(sum);
                        result.add(lst);
                    }
                }
            }
        }
        return result;
    }
    private String toStringForm(int a, int b, int c) {
        if (a <= b && a <= c) {
            if (b <= c) {
                return a + "*" + b + "*" + c;
            }
            else {
                return a + "*" + c + "*" + b;
            }
        }
        else if (b <= a && b <= c) {
            if (a <= c) {
                return b + "*" + a + "*" + c;
            }
            else {
                return b + "*" + c + "*" + a;
            }
        }
        else {
            if (a <= b) {
                return c + "*" + a + "*" + b;
            }
            else {
                return c + "*" + b + "*" + a;
            }
        }
    }
}
