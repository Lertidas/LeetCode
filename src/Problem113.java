import java.util.ArrayList;
import java.util.List;

public class Problem113 implements Problem {
    @Override
    public String solve() {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        int targetSum = 22;
        return String.valueOf(pathSum(treeNode, targetSum));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        else {
            List<List<Integer>> list = new ArrayList<>();
            pathSum(root, targetSum, list, new ArrayList<>());
            return list;
        }
    }
    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer> branchList) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                List<Integer> newList = new ArrayList<>(branchList);
                newList.add(root.val);
                list.add(newList);
            }
        }
        else {
            if (root.left != null) {
                List<Integer> newList1 = new ArrayList<>(branchList);
                newList1.add(root.val);
                pathSum(root.left, targetSum - root.val, list, newList1);
            }
            if (root.right != null) {
                List<Integer> newList2 = new ArrayList<>(branchList);
                newList2.add(root.val);
                pathSum(root.right, targetSum - root.val, list, newList2);
            }
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
