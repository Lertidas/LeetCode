import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem47 {
    public String solve() {
        int[] nums = new int[]{1, 2, 3};
        return String.valueOf(permuteUnique(nums));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> lst1 = new ArrayList<>();
            lst1.add(nums[0]);
            lst.add(lst1);
        }
        else {
            int[] remaining;
            int count;
            HashSet<Integer> used = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!used.contains(nums[i])) {
                    remaining = new int[nums.length - 1];
                    count = 0;
                    for (int j = 0; j < nums.length; j++) {
                        if (j != i) {
                            remaining[count++] = nums[j];
                        }
                    }
                    // Add nums[i] to all permutations
                    List<List<Integer>> results = permuteUnique(remaining);
                    addVal(results, nums[i]);
                    lst.addAll(results);
                    used.add(nums[i]);
                }
            }
        }
        return lst;
    }
    private void addVal(List<List<Integer>> lst, int val) {
        for (List<Integer> lst1 : lst) {
            lst1.add(val);
        }
    }
}
