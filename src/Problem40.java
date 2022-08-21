import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem40 {
    public String solve() {
        int[] candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;
        return combinationSum2(candidates, target).toString();
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = combinationSumRecursive(0, candidates, target);
        return removeDupes(result);
    }
    private List<List<Integer>> combinationSumRecursive(int value, int[] candidates, int target) {
        List<List<Integer>> lst1 = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!hashSet.contains(candidates[i])) {
                hashSet.add(candidates[i]);
                if (value + candidates[i] < target) {
                    // Continue recursively
                    combineLists(lst1, addValueToList(candidates[i],
                            combinationSumRecursive(value + candidates[i],
                                    Arrays.copyOfRange(candidates, i + 1, candidates.length),
                                    target)));
                }
                else if (value + candidates[i] == target) {
                    // Return combination
                    List<Integer> lst2 = new ArrayList<>();
                    lst2.add(candidates[i]);
                    lst1.add(lst2);
                }
                else if (value + candidates[i] > target) {
                    break;
                }
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
    private List<List<Integer>> removeDupes(List<List<Integer>> lst1) {
        List<List<Integer>> lst2 = new ArrayList<>();
        HashSet<String> used = new HashSet<>();
        String rep = "";
        for (List<Integer> lst : lst1) {
            // Check if in HashSet
            rep = strRepresentation(lst);
            if (!used.contains(rep)) {
                used.add(rep);
                // Add to lst2
                lst2.add(lst);
            }
        }
        return lst2;
    }
    private String strRepresentation(List<Integer> lst) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : lst) {
            sb.append(i);
            sb.append("+");
        }
        return sb.toString();
    }
}
