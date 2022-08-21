import javax.swing.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {
    public String solve() {
        int[] candidates = new int[]{2};
        int target = 1;
        return combinationSum(candidates, target).toString();
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = combinationSumRecursive(0, candidates, target);
        reverseLists(result);
        return result;
    }
    private List<List<Integer>> combinationSumRecursive(int value, int[] candidates, int target) {
        List<List<Integer>> lst1 = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (value + candidates[i] < target) {
                // Continue recursively
                combineLists(lst1, addValueToList(candidates[i],
                        combinationSumRecursive(value + candidates[i],
                                Arrays.copyOfRange(candidates, i, candidates.length),
                                target)));
            }
            else if (value + candidates[i] == target) {
                // Return combination
                List<Integer> lst2 = new ArrayList<>();
                lst2.add(candidates[i]);
                lst1.add(lst2);
            }
        }
        return lst1;
    }
    private List<List<Integer>> addValueToList(int value, List<List<Integer>> lst) {
        for (List<Integer> lst2 : lst) {
            lst2.add(value);
        }
        return lst;
    }
    private List<List<Integer>> combineLists(List<List<Integer>> base, List<List<Integer>> toAdd) {
        base.addAll(toAdd);
        return base;
    }
    private void reverseLists(List<List<Integer>> lst1) {
        for (int i = 0; i < lst1.size(); i++) {
            List<Integer> lst2 = lst1.get(i);
            List<Integer> lst3 = new ArrayList<>();
            for (int j = lst2.size() - 1; j >= 0; j--) {
                lst3.add(lst2.get(j));
            }
            lst1.set(i, lst3);
        }
    }
}
