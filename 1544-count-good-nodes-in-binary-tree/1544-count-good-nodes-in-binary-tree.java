
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
 *
 *
 *
 * */

class Solution {

    int result = 0;

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        int maxSoFar = Integer.MIN_VALUE;

        dfs(root, maxSoFar);

        return result;

    }

    private void dfs(TreeNode root, int maxSoFar) {
        if (root == null)
            return;

        if (root.val >= maxSoFar) {
            result++;
            maxSoFar = root.val;

        }

            dfs(root.left, maxSoFar);
            dfs(root.right, maxSoFar);
    }
}