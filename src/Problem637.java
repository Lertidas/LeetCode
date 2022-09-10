import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem637 {
    public String solve() {
        TreeNode root = new TreeNode(2147483647,
                new TreeNode(2147483647),
                new TreeNode(2147483647));
        return averageOfLevels(root).toString();
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        HashMap<Integer, double[]> totals = new HashMap<>();
        totalsAtLevels(root, totals, 0);
        for (Integer i : totals.keySet()) {
            averages.add(totals.get(i)[0] / (totals.get(i)[1]));
        }
        return averages;
    }
    public void totalsAtLevels(TreeNode root, HashMap<Integer, double[]> hm, int depth) {
        if (root != null) {
            if (hm.containsKey(depth)) {
                hm.put(depth, new double[]{hm.get(depth)[0] + root.val, hm.get(depth)[1] + 1});
            }
            else {
                hm.put(depth, new double[]{root.val, 1});
            }
            // Call left and right
            totalsAtLevels(root.left, hm, depth + 1);
            totalsAtLevels(root.right, hm, depth + 1);
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
