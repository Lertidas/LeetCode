import java.util.ArrayList;
import java.util.List;

public class Problem94 implements Problem{
    @Override
    public String solve() {
        TreeNode root = new TreeNode();
        return inorderTraversal(root).toString();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveTraversal(root, result);
        return result;
    }
    private void recursiveTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursiveTraversal(root.left, result);
            result.add(root.val);
            recursiveTraversal(root.right, result);
        }
    }
    class TreeNode {
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
