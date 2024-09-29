class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE); // Correct max and min range for integer values
    }

    boolean dfs(TreeNode root, long maxSoFar, long minSoFar) {
        if (root == null)
            return true;
        if (root.val <= minSoFar || root.val >= maxSoFar) {
            return false;
        }
        return dfs(root.left, root.val, minSoFar)  // Left subtree's max becomes root's value
                && dfs(root.right, maxSoFar, root.val); // Right subtree's min becomes root's value
    }
}
