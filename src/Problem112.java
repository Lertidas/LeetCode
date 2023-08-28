public class Problem112 implements Problem {
    @Override
    public String solve() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        int targetSum = 1;
        return String.valueOf(hasPathSum(root, targetSum));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        else {
            return pathSum(root, targetSum);
        }
    }
    private boolean pathSum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        else {
            boolean left = root.left != null && pathSum(root.left, targetSum - root.val);
            boolean right = root.right != null && pathSum(root.right, targetSum - root.val);
            return left || right;
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
