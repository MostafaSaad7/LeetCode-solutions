/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p != null && q != null && p.val == q.val)) {
            boolean leftSubTree=isSameTree(p.left,q.left);
            boolean rightSubTree=isSameTree(p.right,q.right);
            return leftSubTree && rightSubTree;
        } else if ( p==null && q==null) {
            return true;
        }


        return false;
    }
}

