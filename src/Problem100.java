public class Problem100 implements Problem{
    @Override
    public String solve() {
        return null;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return true;
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
